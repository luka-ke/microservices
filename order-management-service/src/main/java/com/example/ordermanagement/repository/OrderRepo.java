package com.example.ordermanagement.repository;

import com.example.ordermanagement.dto.OrderDTO;
import com.example.ordermanagement.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderRepo {
    private final OrderRepoInterface orderRepoInterface;
    public List<OrderDTO> findAllOrders() {
        return orderRepoInterface.findAll().stream()
                .map(this::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findOrderById(String id) {
        return mapToOrderDTO(orderRepoInterface.findById(id).orElse(null));
    }

    public OrderDTO saveOrder(Order order) {
        return mapToOrderDTO(orderRepoInterface.save(order));
    }


    public OrderDTO deleteOrder(String id) {
        var order = findOrderById(id);
        orderRepoInterface.deleteById(id);
        return order;
    }
    public OrderDTO mapToOrderDTO(Order order) {
        if (order == null) {
            return null;
        }
        return OrderDTO.builder()
                .id(order.getId())
                .price(order.getPrice())
                .userId(order.getUser().getId())
                .status(order.getStatus())
                .quantity(order.getQuantity())
                .product(order.getProduct())
                .build();
    }
}
