package com.codegnan.service;


import com.codegnan.exceptions.UserNotFoundException;
import com.codegnan.model.User;

// Service interface — business logic layer

public interface UserService {

    void registerUser(User user);

    User loginUser(String username, String password) throws UserNotFoundException;

    User getUser(String username) throws UserNotFoundException;
}
