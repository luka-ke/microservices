package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.OrderDTO;
import com.example.ordermanagement.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @CrossOrigin
    @GetMapping("/api/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        var orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/log-cached-orders")
    public ResponseEntity<Void> logCachedOrders() {
        orderService.logCachedOrders();
        return ResponseEntity.ok().build();
    }
    @CrossOrigin
    @GetMapping("/api/orders/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable String id) {
        var order = orderService.getOrderById(id);
        return order != null ? new ResponseEntity<>(order, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PostMapping("/api/orders")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO order) {
        var createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/api/orders/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable String id, @RequestBody OrderDTO order) {
        var updatedOrder = orderService.updateOrder(id, order);
        return updatedOrder != null ? new ResponseEntity<>(updatedOrder, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/api/orders/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable String id) {
        var order = orderService.deleteOrder(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
