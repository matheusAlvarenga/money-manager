package domain.builders;

import com.alvarenga.domain.Account;
import com.alvarenga.domain.User;

public class AccountBuilder {
  private Long id;
  private String name;
  private User user;

  private AccountBuilder() {
  }

  public static AccountBuilder oneAccount() {
    AccountBuilder builder = new AccountBuilder();

    initData(builder);

    return builder;
  }

  private static void initData(AccountBuilder builder) {
    builder.id = 1L;
    builder.name = "Valid name";
    builder.user = UserBuilder.oneUser().build();
  }

  public AccountBuilder withId(Long id) {
    this.id = id;
    return this;
  }

  public AccountBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public AccountBuilder withUser(User user) {
    this.user = user;
    return this;
  }

  public Account build() {
    return new Account(this.id, this.name, this.user);
  }
}
