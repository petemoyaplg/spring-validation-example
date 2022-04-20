package com.plg.springvalidationexample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.plg.springvalidationexample.model.User;
import com.plg.springvalidationexample.model.dto.UserDto;
import com.plg.springvalidationexample.model.dto.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User saveUser(UserDto userDto) {
    User user = new User(
        UUID.randomUUID().toString(),
        userDto.getName(),
        userDto.getEmail(),
        userDto.getPassword(),
        userDto.getGender(),
        userDto.getAge(),
        userDto.getNationality());
    // return this.userRepository.save(user);
    return user;
  }

  public List<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  public Optional<User> getOneUser(UUID id) {
    return this.userRepository.findById(id);
  }
}
