package com.alvarenga.services;

import java.util.Optional;

import com.alvarenga.domain.User;
import com.alvarenga.domain.exceptions.ValidationException;
import com.alvarenga.repositories.UserRepository;

public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    if (this.userRepository.getUserByEmail(user.getEmail()).isPresent()) {
      throw new ValidationException(String.format("Um usuário com o email %s já existe", user.getEmail()));
    }

    return this.userRepository.save(user);
  }

  public Optional<User> getUserByEmail(String email) {
    return this.userRepository.getUserByEmail(email);
  }
}
