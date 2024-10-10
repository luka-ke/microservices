package com.example.usermanagement.controller;

import com.example.usermanagement.dto.AuthenticationRequest;
import com.example.usermanagement.dto.AuthenticationResponse;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserControllerTest {

//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    private UserService userService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetUser() {
//        String userId = "user-id";
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userId);
//        userDTO.setUserName("testUser");
//
//        when(userService.findUserById(userId)).thenReturn(userDTO);
//
//        ResponseEntity<UserDTO> response = userController.getUser(userId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDTO, response.getBody());
//    }
//
//    @Test
//    void testRegister() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserName("testUser");
//        userDTO.setEmail("test@example.com");
//        userDTO.setPassword("password");
//
//        AuthenticationResponse authResponse = new AuthenticationResponse();
//        authResponse.setToken("jwtToken");
//        authResponse.setUserEmail(userDTO.getEmail());
//
//        when(userService.register(userDTO)).thenReturn(authResponse);
//        when(userService.checkEmailUser(userDTO.getEmail())).thenReturn(false);
//
//        ResponseEntity<AuthenticationResponse> response = userController.register(userDTO);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("jwtToken", response.getBody().getToken());
//    }
//
//    @Test
//    void testAuthenticate() {
//        AuthenticationRequest request = new AuthenticationRequest();
//        request.setEmail("test@example.com");
//        request.setPassword("password");
//
//        AuthenticationResponse authResponse = new AuthenticationResponse();
//        authResponse.setToken("jwtToken");
//
//        when(userService.authenticate(request)).thenReturn(authResponse);
//
//        ResponseEntity<AuthenticationResponse> response = userController.authenticate(request);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("jwtToken", response.getBody().getToken());
//    }
//
//    @Test
//    void testUpdateUser() {
//        String userId = "user-id";
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userId);
//        userDTO.setUserName("updatedUser");
//
//        when(userService.updateUserDetails(userId, userDTO)).thenReturn(userDTO);
//
//        ResponseEntity<UserDTO> response = userController.updateUser(userId, userDTO);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDTO, response.getBody());
//    }
//
//    @Test
//    void testDeleteUser() {
//        String userId = "user-id";
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userId);
//
//        when(userService.deleteUser(userId)).thenReturn(userDTO);
//
//        ResponseEntity<UserDTO> response = userController.removeUser(userId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(userDTO, response.getBody());
//    }
}