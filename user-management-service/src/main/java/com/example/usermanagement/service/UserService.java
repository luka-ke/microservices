package com.example.usermanagement.service;

import com.example.usermanagement.dto.AuthenticationRequest;
import com.example.usermanagement.dto.AuthenticationResponse;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.User;

import java.util.List;

public interface UserService {
    AuthenticationResponse register(UserDTO request);

    AuthenticationResponse returnFailedMessage();
    void logCachedUsers();

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse checkAuthenticatedUser(AuthenticationRequest request);

    boolean checkEmailUser(String email);

    AuthenticationResponse findUserByToken(String token);

    UserDTO updateUserDetails(String id, UserDTO body);

    UserDTO findUserById(String id);

    UserDTO deleteUser(String id);

    List<UserDTO> listUsers();
    UserDTO  updateSelfUser(String token, UserDTO userDTO);
    UserDTO becomeAdmin(String id);
}
