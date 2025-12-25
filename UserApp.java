package com.codegnan.main;


import java.util.Scanner;

import com.codegnan.exceptions.UserNotFoundException;
import com.codegnan.model.User;
import com.codegnan.service.UserService;
import com.codegnan.service.UserServiceImpl;

// Controller class — contains main method
// and performs user interaction

public class UserApp {

    public static void main(String[] args) {

        UserService service = new UserServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== USER LOGIN & REGISTRATION SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter username: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter password: ");
                    String pwd = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    service.registerUser(new User(uname, pwd, email));
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String u = sc.nextLine();

                    System.out.print("Enter password: ");
                    String p = sc.nextLine();

                    try {
                        User user = service.loginUser(u, p);
                        System.out.println("Login successful! Welcome " + user.getUsername());
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
