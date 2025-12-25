package com.codegnan.service;


import com.codegnan.dao.UserDao;
import com.codegnan.dao.UserDaoImpl;
import com.codegnan.exceptions.UserNotFoundException;
import com.codegnan.model.User;

// Service implementation — acts as middle layer
// between Controller and DAO

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        dao.register(user);
    }

    @Override
    public User loginUser(String username, String password) throws UserNotFoundException {
        return dao.login(username, password);
    }

    @Override
    public User getUser(String username) throws UserNotFoundException {
        return dao.findByUsername(username);
    }
}

