package com.example.usermanagement.service;

import com.example.usermanagement.dto.AuthenticationRequest;
import com.example.usermanagement.dto.AuthenticationResponse;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.model.Role;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepo;
import com.example.usermanagement.repository.UserRepoInterface;
import com.example.usermanagement.security.JwtService;
import com.hazelcast.map.IMap;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserRepoInterface userRepoInterface;
    private final KafkaProducerService kafkaProducerService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CacheManager cacheManager;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    public AuthenticationResponse register(UserDTO request) {
        var uuid = UUID.randomUUID();
        var user = User.builder()
                .userName(request.getUserName())
                .role(Role.USER)
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .id(uuid.toString())
                .build();
        userRepoInterface.save(user);
        var jwtToken = jwtService.generateToken(user);
        var createdUser = userRepo.findUserById(uuid.toString());
        kafkaProducerService.sendMessage("USER_CREATED", createdUser.toString());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(createdUser.getId())
                .userEmail(createdUser.getEmail())
                .build();
    }

    public AuthenticationResponse returnFailedMessage() {
        return AuthenticationResponse.builder()
                .token(null)
                .message("user already exists")
                .error(true)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepoInterface.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(user.getId())
                .userEmail(user.getEmail())
                .userFirstName(user.getUserName())
                .build();
    }
    public void logCachedUsers() {
        Cache cache = cacheManager.getCache("user");
        if (cache != null) {

            IMap<String, UserDTO> userMap = (IMap<String, UserDTO>) cache.getNativeCache();
            List<UserDTO> cachedUsers = new ArrayList<>();
            for (String key : userMap.keySet()) {
                UserDTO user = userMap.get(key);
                if (user != null) {
                    cachedUsers.add(user);
                    logger.info("Cached User: {}", user);
                }
            }
            logger.info("Total Cached Users: {}", cachedUsers.size());
        } else {
            logger.warn("Cache 'user' not found");
        }
    }
    public AuthenticationResponse checkAuthenticatedUser(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepoInterface.findByEmail(request.getEmail())
                .orElseThrow();
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .userEmail(user.getEmail())
                .userFirstName(user.getUserName())
                .build();
    }

    public boolean checkEmailUser(String email) {
        var user = userRepo.findUserByEmail(email);
        if (user != null && user.getEmail() != null && user.getEmail().equals(email)) {
            return true;
        }
        return false;
    }

    public AuthenticationResponse findUserByToken(String token) {
        var userEmail = jwtService.extractUserName(token);
        var user = userRepo.findUserByEmail(userEmail);
        return AuthenticationResponse.builder().userId(user.getId()).userEmail(userEmail).error(false).message(null).build();
    }

    public UserDTO updateUserDetails(String id, UserDTO body) {

        UserDTO user = findUserById(id);
        var udpatedUser = User.builder()
                .id(user.getId())
                .userName(body.getUserName())
                .email(body.getEmail())
                .password(passwordEncoder.encode(body.getPassword()))
                .role(Role.USER)
                .build();
        var updatedUser = userRepoInterface.save(udpatedUser);
        return userRepo.mapToUserDTO(updatedUser);
    }
    @Cacheable(value = "user", key = "#id")
    public UserDTO findUserById(String id) {
        return userRepo.findUserById(id);
    }

    public UserDTO deleteUser(String id) {
        var user = findUserById(id);
        userRepo.deleteUser(id);
        return user;
    }

    public List<UserDTO> listUsers() {
        return userRepo.listUsers();
    }
}

