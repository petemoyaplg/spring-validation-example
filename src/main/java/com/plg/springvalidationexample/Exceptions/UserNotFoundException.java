package com.plg.springvalidationexample.Exceptions;

public class UserNotFoundException extends Exception {
  public UserNotFoundException(String message) {
    super(message);
  }
}
