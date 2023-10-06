package services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.alvarenga.domain.User;
import com.alvarenga.repositories.UserRepository;
import com.alvarenga.services.UserService;

import domain.builders.UserBuilder;

public class UserServiceTest {
  private UserService userService;

  @Test
  public void shouldReturnEmptyIfUserIsUnexistent() {
    UserRepository repository = Mockito.mock(UserRepository.class);

    userService = new UserService(repository);

    Optional<User> user = userService.getUserByEmail("unexistent_email@mail.com");
    Assertions.assertTrue(user.isEmpty());
  }

  @Test
  public void shouldReturnUserIfUserIsExistent() {
    UserRepository repository = Mockito.mock(UserRepository.class);

    userService = new UserService(repository);

    Mockito.when(repository.getUserByEmail(any())).thenReturn(Optional.of(UserBuilder.oneUser().build()));

    Optional<User> user = userService.getUserByEmail("unexistent_email@mail.com");
    Assertions.assertTrue(user.isPresent());
  }
}
