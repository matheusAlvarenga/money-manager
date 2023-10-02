package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.User;
import com.alvarenga.services.UserService;

import domain.builders.UserBuilder;
import infrastructure.dummies.UserDummyRepository;

public class UserServiceTest {
  private UserService userService;

  @Test
  public void shouldSaveUser() {
    userService = new UserService(new UserDummyRepository());

    User user = UserBuilder.oneUser().withId(null).withEmail("unexistent_email@mail.com").build();

    User savedUser = userService.save(user);

    Assertions.assertNotNull(savedUser.getId());
  }
}
