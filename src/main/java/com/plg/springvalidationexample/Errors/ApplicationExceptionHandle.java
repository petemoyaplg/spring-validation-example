package com.plg.springvalidationexample.Errors;

import java.util.HashMap;
import java.util.Map;

import com.plg.springvalidationexample.Exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandle {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> HandleInvalideArgument(MethodArgumentNotValidException ex) {
    Map<String, String> errorMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      errorMap.put(error.getField(), error.getDefaultMessage());
    });
    return errorMap;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(UserNotFoundException.class)
  public Map<String, String> HandleBusinessException(UserNotFoundException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("errorMessage", ex.getMessage());
    return errorMap;
  }

}
