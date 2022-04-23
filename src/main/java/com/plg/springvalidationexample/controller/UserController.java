package com.plg.springvalidationexample.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.plg.springvalidationexample.Exceptions.UserNotFoundException;
import com.plg.springvalidationexample.dto.UserDto;
import com.plg.springvalidationexample.model.User;
import com.plg.springvalidationexample.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

  // private static final Logger logger =
  // Logger.getLogger(UserController.class.getName());
  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

  @Autowired
  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto, HttpServletRequest request) {
    LOGGER.trace("Début de la méthode getAllUser");
    LOGGER.debug("URI : " + request.getRequestURI());
    return new ResponseEntity<>(this.userService.saveUser(userDto), HttpStatus.CREATED);
  }

  @GetMapping("/fetchAll")
  public ResponseEntity<List<User>> getAllUser(HttpServletRequest request) {
    LOGGER.trace("Début de la méthode getAllUser");
    LOGGER.debug("URI : " + request.getRequestURI());
    return ResponseEntity.ok(this.userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<User>> getUser(@PathVariable UUID id,
      HttpServletRequest request) throws UserNotFoundException {
    LOGGER.trace("Début de la méthode getAllUser");
    LOGGER.debug("URI : " + request.getRequestURI());
    return ResponseEntity.ok(this.userService.getOneUser(id));
  }

}
