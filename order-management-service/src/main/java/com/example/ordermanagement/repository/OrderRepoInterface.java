package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepoInterface extends JpaRepository<Order, String> {
}
