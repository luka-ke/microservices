package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.OrderDTO;
import com.example.ordermanagement.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {
//
//    @InjectMocks
//    private OrderController orderController;
//
//    @Mock
//    private OrderService orderService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllOrders() {
//        List<OrderDTO> orders = List.of(new OrderDTO());
//        when(orderService.getAllOrders()).thenReturn(orders);
//
//        ResponseEntity<List<OrderDTO>> response = orderController.getAllOrders();
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(orders, response.getBody());
//    }
//
//    @Test
//    void testGetOrderById() {
//        String id = "1";
//        OrderDTO orderDTO = new OrderDTO();
//        when(orderService.getOrderById(id)).thenReturn(orderDTO);
//
//        ResponseEntity<OrderDTO> response = orderController.getOrderById(id);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(orderDTO, response.getBody());
//    }
//
//    @Test
//    void testCreateOrder() {
//        OrderDTO orderDTO = new OrderDTO();
//        when(orderService.createOrder(orderDTO)).thenReturn(orderDTO);
//
//        ResponseEntity<OrderDTO> response = orderController.createOrder(orderDTO);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals(orderDTO, response.getBody());
//    }
//
//    @Test
//    void testUpdateOrder() {
//        String id = "1";
//        OrderDTO orderDTO = new OrderDTO();
//        when(orderService.updateOrder(id, orderDTO)).thenReturn(orderDTO);
//
//        ResponseEntity<OrderDTO> response = orderController.updateOrder(id, orderDTO);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(orderDTO, response.getBody());
//    }
//
//    @Test
//    void testDeleteOrder() {
//        String id = "1";
//        when(orderService.deleteOrder(id)).thenReturn(new OrderDTO());
//
//        ResponseEntity<OrderDTO> response = orderController.deleteOrder(id);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//
//    }
}