package com.igor.user.service.service;

import com.igor.user.service.model.User;

import java.util.List;


public interface UserService {
    public User getUserProfile(String jwt);
    public List<User> getAllUsers();

}