package com.alvarenga.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alvarenga.domain.User;
import com.alvarenga.repositories.UserRepository;

public class UserMemoryRepository implements UserRepository {
  private List<User> users;
  private Long currentId;

  public UserMemoryRepository() {
    this.currentId = 0L;
    this.users = new ArrayList<>();

    this.save(new User(null, "User #1", "user@mail.com", "123456"));
  }

  @Override
  public User save(User user) {
    User newUser = new User(this.getNextId(), user.getName(), user.getEmail(), user.getPassword());

    this.users.add(newUser);

    return newUser;
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return this.users.stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst();
  }

  private Long getNextId() {
    return ++this.currentId;
  }
}
