package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.Account;
import com.alvarenga.domain.exceptions.ValidationException;

import domain.builders.AccountBuilder;
import domain.builders.UserBuilder;

public class TestAccount {

  @Test
  @DisplayName("Should create a valid account")
  public void shouldCreateAValidAccount() {
    Account account = AccountBuilder.oneAccount().build();

    Assertions.assertAll(
        "Account assertions",
        () -> Assertions.assertEquals(1L, account.getId()),
        () -> Assertions.assertEquals("Valid name", account.getName()),
        () -> Assertions.assertEquals(UserBuilder.oneUser().build(), account.getUser()));
  }

  @Test
  @DisplayName("Should throw a ValidationException if name is null")
  public void shouldThrowIfNameIsNull() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> AccountBuilder.oneAccount().withName(null).build());

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if name is empty")
  public void shouldThrowIfNameIsEmpty() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> AccountBuilder.oneAccount().withName("").build());

    Assertions.assertEquals("Name cannot be null or empty", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw a ValidationException if user is null")
  public void shouldThrowIfUserIsNull() {
    ValidationException exception = Assertions.assertThrows(
        ValidationException.class,
        () -> AccountBuilder.oneAccount().withUser(null).build());

    Assertions.assertEquals("User cannot be null", exception.getMessage());
  }
}
