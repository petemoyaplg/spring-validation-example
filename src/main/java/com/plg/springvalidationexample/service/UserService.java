package com.plg.springvalidationexample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.plg.springvalidationexample.Exceptions.UserNotFoundException;
import com.plg.springvalidationexample.dto.UserDto;
import com.plg.springvalidationexample.model.User;
import com.plg.springvalidationexample.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class.getName());

  public User saveUser(UserDto userDto) {
    LOGGER.trace("Début de la méthode saveUser");
    User user = new User(
        UUID.randomUUID().toString(),
        userDto.getName(),
        userDto.getEmail(),
        userDto.getMobile(),
        userDto.getPassword(),
        userDto.getGender(),
        userDto.getAge(),
        userDto.getNationality());
    try {
      user = this.userRepository.save(user);
      LOGGER.debug("User " + user + " saved");
    } catch (Exception e) {
      LOGGER.error("error saveUser : " + e.getMessage());
    }
    return user;
  }

  public List<User> getAllUsers() {
    LOGGER.trace("Début de la méthode getOneUser");
    List<User> users = new ArrayList<>();
    try {
      users = this.userRepository.findAll();
    } catch (Exception e) {
      LOGGER.error("error getAllUsers : " + e.getMessage());
    }
    LOGGER.debug("List users trouvée !");
    return users;
  }

  public Optional<User> getOneUser(UUID id) throws UserNotFoundException {
    LOGGER.trace("Début de la méthode getOneUser");
    Optional<User> user = null;
    try {
      user = this.userRepository.findById(id.toString());
      if (user.isEmpty()) {
        LOGGER.error("User d'id " + id.toString() + " non trouvé");
        throw new UserNotFoundException("User not found");
      }
    } catch (Exception e) {
      LOGGER.error("error getOneUser : " + e.getMessage());
    }
    LOGGER.debug("User d'id " + id.toString() + " trouvé");
    return user;
  }
}
