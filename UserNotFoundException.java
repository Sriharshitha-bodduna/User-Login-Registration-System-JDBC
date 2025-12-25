package com.codegnan.exceptions;


//Custom exception — thrown when user is not found
//or login credentials are invalid

public class UserNotFoundException extends Exception {

 public UserNotFoundException(String message) {
     super(message);
 }
}
