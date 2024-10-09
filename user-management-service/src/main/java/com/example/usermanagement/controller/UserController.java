package com.example.usermanagement.controller;

import com.example.usermanagement.dto.AuthenticationRequest;
import com.example.usermanagement.dto.AuthenticationResponse;
import com.example.usermanagement.dto.UserDTO;
import com.example.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }
    @GetMapping("/log-cached-users")
    public ResponseEntity<Void> logCachedOrders() {
        userService.logCachedUsers();
        return ResponseEntity.ok().build();
    }
    @CrossOrigin
    @GetMapping("/api/users")
    public ResponseEntity<List<UserDTO>> findAllUser() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/public/api/users")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDTO request
    ) {
        var userExists = userService.checkEmailUser(request.getEmail());
        if (userExists) {
            return ResponseEntity.internalServerError().body(userService.returnFailedMessage());
        } else {
            return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
        }
    }
    @CrossOrigin
    @PutMapping("/api/users/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable String id, @RequestBody UserDTO userBody
    ) {
        return new ResponseEntity<>(userService.updateUserDetails(id, userBody), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<UserDTO> removeUser(
            @PathVariable String id
    ) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/public/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return new ResponseEntity<>(userService.authenticate(request), HttpStatus.OK);

    }
}