package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.User;
import com.alvarenga.domain.exceptions.ValidationException;

import domain.builders.UserBuilder;

@DisplayName("Domain: User")
public class TestUser {

  @Test
  @DisplayName("Should create a valid user")
  public void shouldCreateValidUser() {
    User user = UserBuilder.oneUser().build();

    Assertions.assertAll(
        "User Assertions",
        () -> Assertions.assertEquals(1L, user.getId()),
        () -> Assertions.assertEquals("Valid name", user.getName()),
        () -> Assertions.assertEquals("valid_email@mail.com", user.getEmail()),
        () -> Assertions.assertEquals("valid_password", user.getPassword()));

  }

  @Test
  @DisplayName("Should throw a ValidationException if name is null")
  public void shouldThrowIfNameIsNull() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withName(null).build());

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if name is empty")
  public void shouldThrowIfNameIsEmpty() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withName("").build());

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if email is null")
  public void shouldThrowIfEmailIsNull() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withEmail(null).build());

    Assertions.assertEquals("Email cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if email is empty")
  public void shouldThrowIfEmailIsEmpty() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withEmail("").build());

    Assertions.assertEquals("Email cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if password is null")
  public void shouldThrowIfPasswordIsNull() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withPassword(null).build());

    Assertions.assertEquals("Password cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if password is empty")
  public void shouldThrowIfPasswordIsEmpty() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> UserBuilder.oneUser().withPassword("").build());

    Assertions.assertEquals("Password cannot be null or empty", exception.getMessage());
  }
}
