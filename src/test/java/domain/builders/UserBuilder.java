package domain.builders;

import com.alvarenga.domain.User;

public class UserBuilder {
  private Long id;
  private String name;
  private String email;
  private String password;

  private UserBuilder() {
  }

  public static UserBuilder oneUser() {
    UserBuilder builder = new UserBuilder();

    initData(builder);

    return builder;
  }

  private static void initData(UserBuilder builder) {
    builder.id = 1L;
    builder.name = "Valid name";
    builder.email = "valid_email@mail.com";
    builder.password = "valid_password";
  }

  public UserBuilder withId(Long id) {
    this.id = id;
    return this;
  }

  public UserBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public UserBuilder withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserBuilder withPassword(String password) {
    this.password = password;
    return this;
  }

  public User build() {
    return new User(this.id, this.name, this.email, this.password);
  }
}
