package com.alvarenga.domain;

import com.alvarenga.domain.exceptions.ValidationException;

public class User {
  private Long id;
  private String name;
  private String email;
  private String password;

  public User(Long id, String name, String email, String password) {
    validate(name, email, password);

    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public void validate(String name, String email, String password) {
    if (name == null || name.isEmpty())
      throw new ValidationException("Name cannot be null or empty");
    if (email == null || email.isEmpty())
      throw new ValidationException("Email cannot be null or empty");
    if (password == null || password.isEmpty())
      throw new ValidationException("Password cannot be null or empty");
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

}
