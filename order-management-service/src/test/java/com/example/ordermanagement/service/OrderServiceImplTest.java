package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderDTO;
import com.example.ordermanagement.dto.UserDTO;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.Status;
import com.example.ordermanagement.model.User;
import com.example.ordermanagement.repository.OrderRepo;
import com.example.ordermanagement.repository.UserRepo;
import com.example.ordermanagement.repository.UserRepoInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
class OrderServiceImplTest {

//    @InjectMocks
//    private OrderServiceImpl orderService;
//
//    @Mock
//    private OrderRepo orderRepo;
//
//    @Mock
//    private UserRepo userRepo;
//
//    @Mock
//    private UserRepoInterface userRepoInterface;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllOrders() {
//        // Add your test implementation here
//    }
//
//    @Test
//    void testGetOrderById() {
//        OrderDTO order = OrderDTO.builder()
//                .id("order-003")
//                .userId("user-789")
//                .product("New Product Sample")
//                .quantity(10)
//                .price(199.99)
//                .status(Status.DONE)
//                .build();
//        String id = "order-003";
//
//        when(orderRepo.findOrderById(id)).thenReturn(order);
//
//        OrderDTO result = orderService.getOrderById(id);
//        assertNotNull(result);
//        assertEquals(order, result);
//        verify(orderRepo).findOrderById(id);
//    }
//
//    @Test
//    void testCreateOrder() {
//        // Arrange
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setUserId("123");
//        orderDTO.setStatus(Status.IN_PROGRESS);
//        orderDTO.setPrice(100.5);
//        orderDTO.setProduct("Test Product");
//        orderDTO.setQuantity(2);
//
//        // Create a mock user
//        UserDTO mockUser = new UserDTO();
//        mockUser.setId("123");
//        // Set other fields of the user as needed
//
//        // Mock the findUserById method
//        when(userRepo.findUserById(orderDTO.getUserId())).thenReturn(mockUser);
//        when(orderRepo.saveOrder(any())).thenReturn(orderDTO);
//        // Act
//        OrderDTO response = orderService.createOrder(orderDTO);
//
//        // Assert
//        assertNotNull(response);
//        assertEquals(orderDTO.getStatus(), response.getStatus());
//        assertEquals(orderDTO.getPrice(), response.getPrice());
//        assertEquals(orderDTO.getProduct(), response.getProduct());
//        assertEquals(orderDTO.getQuantity(), response.getQuantity());
//    }
//
//    @Test
//    void testUpdateOrder() {
//        OrderDTO order = OrderDTO.builder()
//                .id("order-002")
//                .userId("user-456")
//                .product("Another Sample Product")
//                .quantity(5)
//                .price(49.99)
//                .status(Status.IN_PROGRESS)
//                .build();
//        User user = User.builder().id("user-456").build();
//        String id = "order-002";
//        when(orderRepo.findOrderById(id)).thenReturn(order);
//        when(userRepoInterface.findById(order.getUserId())).thenReturn(Optional.of(user));
//        when(orderRepo.saveOrder(any(Order.class))).thenReturn(order);
//
//        OrderDTO updatedOrder = orderService.updateOrder(id, order);
//        assertNotNull(updatedOrder);
//        assertEquals(order, updatedOrder);
//        // additional assertions for updatedOrder
//        verify(orderRepo).saveOrder(any(Order.class));
//    }
//
//    @Test
//    void testDeleteOrder() {
//        OrderDTO order = OrderDTO.builder()
//                .id("order-001")
//                .userId("user-123")
//                .product("Sample Product")
//                .quantity(3)
//                .price(29.99)
//                .status(Status.IN_PROGRESS)
//                .build();
//        String id = "order-001";
//        when(orderRepo.deleteOrder(id)).thenReturn(order);
//
//        OrderDTO deletedOrder = orderService.deleteOrder(id);
//        assertNotNull(deletedOrder);
//        assertEquals(order.getId(), id);
//        verify(orderRepo).deleteOrder(id);
//    }
}