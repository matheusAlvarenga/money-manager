package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.User;
import com.alvarenga.domain.exceptions.ValidationException;

@DisplayName("Domain: User")
public class TestUser {

  @Test
  @DisplayName("Should create a valid user")
  public void shouldCreateValidUser() {
    User user = new User(1L, "Valid name", "valid_email@mail.com", "valid_password");

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
        () -> new User(1L, null, "valid_email@mail.com", "valid_password"));

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if name is empty")
  public void shouldThrowIfNameIsEmpty() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> new User(1L, "", "valid_email@mail.com", "valid_password"));

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }
}
