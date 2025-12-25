package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codegnan.exceptions.UserNotFoundException;
import com.codegnan.factory.ConnectionFactory;
import com.codegnan.model.User;

// DAO implementation class — performs JDBC operations
// using PreparedStatement

public class UserDaoImpl implements UserDao {

    // REGISTER USER
    @Override
    public void register(User user) {

        String sql = "INSERT INTO users VALUES (?,?,?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());

            pst.executeUpdate();
            System.out.println("User registered successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LOGIN USER
    @Override
    public User login(String username, String password) throws UserNotFoundException {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            } else {
                throw new UserNotFoundException("Invalid username or password");
            }

        } catch (SQLException e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }

    // FIND USER BY USERNAME
    @Override
    public User findByUsername(String username) throws UserNotFoundException {

        String sql = "SELECT * FROM users WHERE username=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            } else {
                throw new UserNotFoundException("User not found: " + username);
            }

        } catch (SQLException e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }
}
