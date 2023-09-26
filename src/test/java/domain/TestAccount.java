package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.Account;

import domain.builders.AccountBuilder;
import domain.builders.UserBuilder;

public class TestAccount {

  @Test
  public void shouldCreateAValidAccount() {
    Account account = AccountBuilder.oneAccount().build();

    Assertions.assertAll(
        "Account assertions",
        () -> Assertions.assertEquals(1L, account.getId()),
        () -> Assertions.assertEquals("Valid name", account.getName()),
        () -> Assertions.assertEquals(UserBuilder.oneUser().build(), account.getUser()));
  }
}
