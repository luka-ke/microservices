package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepoInterface extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
}
