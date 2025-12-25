package com.codegnan.dao;


import com.codegnan.exceptions.UserNotFoundException;
import com.codegnan.model.User;

// DAO interface — defines database operations
// for User login and registration

public interface UserDao {

    // CREATE — register new user
    void register(User user);

    // READ — login validation
    User login(String username, String password) throws UserNotFoundException;

    // READ BY USERNAME
    User findByUsername(String username) throws UserNotFoundException;
}
