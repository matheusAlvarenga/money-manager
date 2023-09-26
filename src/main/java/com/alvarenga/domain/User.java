package com.alvarenga.domain;

import com.alvarenga.domain.exceptions.ValidationException;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(name, user.name)
        && Objects.equals(email, user.email) && Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password);
  }
}
