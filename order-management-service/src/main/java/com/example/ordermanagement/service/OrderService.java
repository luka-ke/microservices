package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderDTO;

import java.util.List;
public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(String id);
    OrderDTO createOrder(OrderDTO order);
    OrderDTO updateOrder(String id, OrderDTO order);
    OrderDTO deleteOrder(String id);
    void logCachedOrders();
}
