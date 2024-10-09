package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderDTO;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepo;
import com.example.ordermanagement.repository.UserRepo;
import com.hazelcast.map.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import com.example.ordermanagement.repository.UserRepoInterface;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepo orderRepo;
    private final KafkaProducerService kafkaProducerServicel;
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final UserRepo userRepo;
    private final UserRepoInterface userRepoInterface;
    private final CacheManager cacheManager;
    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepo.findAllOrders();
    }

    @Override
    @Cacheable(value = "order", key = "#id")
    public OrderDTO getOrderById(String id) {
        System.out.println("came in getOrderById-->");
        System.out.println("id-->"+ id);
        return orderRepo.findOrderById(id);
    }
    public void logCachedOrders() {
        Cache cache = cacheManager.getCache("order");
        if (cache != null) {
            // Assuming the cache is backed by Hazelcast IMap
            IMap<String, OrderDTO> orderMap = (IMap<String, OrderDTO>) cache.getNativeCache();
            List<OrderDTO> cachedOrders = new ArrayList<>();
            for (String key : orderMap.keySet()) {
                OrderDTO order = orderMap.get(key);
                if (order != null) {
                    cachedOrders.add(order);
                    logger.info("Cached Order: {}", order);
                }
            }
            logger.info("Total Cached Orders: {}", cachedOrders.size());
        } else {
            logger.warn("Cache 'order' not found");
        }
    }
    @Override
    public OrderDTO createOrder(OrderDTO order) {
        var uuid = UUID.randomUUID();
        var user = userRepo.findUserById(order.getUserId());
        var newOrder = Order.builder()
                .id(uuid.toString())
                .user(userRepoInterface.findById(user.getId()).orElse(null))
                .status(order.getStatus())
                .price(order.getPrice())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .build();
        kafkaProducerServicel.sendMessage("ORDER_CREATED", newOrder.toString());
        return orderRepo.saveOrder(newOrder);
    }

    @Override
    public OrderDTO updateOrder(String id, OrderDTO order) {
        var oldOrder = orderRepo.findOrderById(id);
        var user = userRepoInterface.findById(order.getUserId());
        var updatedOrder = Order.builder()
                .id(oldOrder.getId())
                .price(order.getPrice())
                .status(order.getStatus())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .user(user.orElse(null))
                .build();
       return orderRepo.saveOrder(updatedOrder);
    }

    @Override
    public OrderDTO deleteOrder(String id) {
       return orderRepo.deleteOrder(id);
    }
}
