package com.igor.user.service.controller;

import com.igor.user.service.model.User;
import com.igor.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) {
        User user = userService.getUserProfile(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(@RequestHeader("Authorization") String jwt) {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}