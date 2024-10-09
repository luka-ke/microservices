package com.example.ordermanagement.repository;

import com.example.ordermanagement.dto.UserDTO;
import com.example.ordermanagement.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRepo {
    private final UserRepoInterface userRepoInterface;

    public UserDTO findUserById(String id) {
        var user = userRepoInterface.findById(id).orElse(null);
        return mapToUserDTO(user);
    }
    public UserDTO mapToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
