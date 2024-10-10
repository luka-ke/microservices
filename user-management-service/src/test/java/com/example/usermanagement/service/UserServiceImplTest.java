package com.example.usermanagement.service;

import com.example.usermanagement.dto.AuthenticationRequest;
import com.example.usermanagement.dto.AuthenticationResponse;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.Role;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepo;
import com.example.usermanagement.repository.UserRepoInterface;
import com.example.usermanagement.security.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

//    @InjectMocks
//    private UserServiceImpl userService;
//
//    @Mock
//    private UserRepo userRepo;
//
//    @Mock
//    private UserRepoInterface userRepoInterface;
//
//    @Mock
//    private JwtService jwtService;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    private CacheManager cacheManager;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testRegisterUser() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUserName("testUser");
//        userDTO.setEmail("test@example.com");
//        userDTO.setPassword("password");
//
//        User mockUser = User.builder()
//                .id(UUID.randomUUID().toString())
//                .userName(userDTO.getUserName())
//                .email(userDTO.getEmail())
//                .password("encodedPassword")
//                .role(Role.USER)
//                .build();
//
//        when(userRepoInterface.save(any(User.class))).thenReturn(mockUser);
//        when(passwordEncoder.encode(userDTO.getPassword())).thenReturn("encodedPassword");
//        when(jwtService.generateToken(mockUser)).thenReturn("jwtToken");
//        when(userRepo.findUserByEmail(userDTO.getEmail())).thenReturn(null); // user doesn't exist
//
//        AuthenticationResponse response = userService.register(userDTO);
//
//        assertNotNull(response);
//        assertEquals("jwtToken", response.getToken());
//        assertEquals(mockUser.getEmail(), response.getUserEmail());
//        verify(userRepoInterface).save(any(User.class));
//    }
//
//    @Test
//    void testAuthenticateUser() {
//        AuthenticationRequest request = new AuthenticationRequest();
//        request.setEmail("test@example.com");
//        request.setPassword("password");
//
//        User mockUser = User.builder()
//                .id(UUID.randomUUID().toString())
//                .email(request.getEmail())
//                .password("encodedPassword")
//                .userName("testUser")
//                .build();
//
//        when(userRepoInterface.findByEmail(request.getEmail())).thenReturn(Optional.of(mockUser));
//        when(jwtService.generateToken(mockUser)).thenReturn("jwtToken");
//
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//
//        AuthenticationResponse response = userService.authenticate(request);
//
//        assertNotNull(response);
//        assertEquals("jwtToken", response.getToken());
//        assertEquals(mockUser.getEmail(), response.getUserEmail());
//        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
//    }
//
//    @Test
//    void testFindUserById() {
//        String id = "user-id";
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(id);
//        userDTO.setUserName("testUser");
//
//        when(userRepo.findUserById(id)).thenReturn(userDTO);
//
//        UserDTO foundUser = userService.findUserById(id);
//        assertNotNull(foundUser);
//        assertEquals(id, foundUser.getId());
//        verify(userRepo).findUserById(id);
//    }
//
//    @Test
//    void testDeleteUser() {
//        String userId = "user-id";
//        User mockUser = User.builder()
//                .id(userId)
//                .userName("testUser")
//                .email("test@example.com")
//                .password("encodedPassword")
//                .role(Role.USER)
//                .build();
//
//        when(userRepoInterface.findById(userId)).thenReturn(Optional.of(mockUser));
//
//        userService.deleteUser(userId);
//
//        verify(userRepoInterface).delete(mockUser);
//    }
//
//    @Test
//    void testUpdateUserDetails() {
//        String userId = "user-id";
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userId);
//        userDTO.setUserName("updatedUser");
//
//        User mockUser = User.builder()
//                .id(userId)
//                .userName("testUser")
//                .email("test@example.com")
//                .password("encodedPassword")
//                .role(Role.USER)
//                .build();
//
//        when(userRepoInterface.findById(userId)).thenReturn(Optional.of(mockUser));
//        when(userRepoInterface.save(any(User.class))).thenReturn(mockUser);
//
//        UserDTO updatedUser = userService.updateUserDetails(userId, userDTO);
//
//        assertNotNull(updatedUser);
//        assertEquals(userDTO.getUserName(), updatedUser.getUserName());
//        verify(userRepoInterface).save(any(User.class));
//    }

}