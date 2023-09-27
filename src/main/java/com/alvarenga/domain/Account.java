package com.alvarenga.domain;

import com.alvarenga.domain.exceptions.ValidationException;

public class Account {
  private Long id;
  private String name;
  private User user;

  public Account(Long id, String name, User user) {
    validate(name, user);

    this.id = id;
    this.name = name;
    this.user = user;
  }

  public void validate(String name, User user) {
    if (name == null || name.isEmpty())
      throw new ValidationException("Name cannot be null or empty");
    if (user == null)
      throw new ValidationException("User cannot be null");
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public User getUser() {
    return this.user;
  }

}
