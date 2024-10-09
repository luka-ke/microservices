package com.example.usermanagement.repository;

import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserRepo {
    private final UserRepoInterface userRepoInterface;

    public UserDTO findUserById(String id) {
        var user = userRepoInterface.findById(id).orElse(null);
        return mapToUserDTO(user);
    }

    public UserDTO findUserByEmail(String email) {
        var user = userRepoInterface.findByEmail(email).orElse(null);
        return mapToUserDTO(user);
    }

    public List<UserDTO> listUsers() {
        return userRepoInterface.findAll().stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
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

    public void deleteUser(String id) {
        userRepoInterface.deleteById(id);
    }

}
