package com.plg.springvalidationexample.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.plg.springvalidationexample.Exceptions.UserNotFoundException;
import com.plg.springvalidationexample.dto.UserDto;
import com.plg.springvalidationexample.model.User;
import com.plg.springvalidationexample.repository.UserRepository;

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
        userDto.getMobile(),
        userDto.getPassword(),
        userDto.getGender(),
        userDto.getAge(),
        userDto.getNationality());
    return this.userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return this.userRepository.findAll();
  }

  public Optional<User> getOneUser(UUID id) throws UserNotFoundException {
    Optional<User> user = this.userRepository.findById(id.toString());
    if (user.isEmpty())
      throw new UserNotFoundException("User not found");
    return user;
  }
}
