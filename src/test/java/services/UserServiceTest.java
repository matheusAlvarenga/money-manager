package services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.alvarenga.domain.User;
import com.alvarenga.repositories.UserRepository;
import com.alvarenga.services.UserService;

import domain.builders.UserBuilder;

public class UserServiceTest {
  private UserService userService;
  private UserRepository repository;

  @BeforeEach
  public void setup() {
    repository = Mockito.mock(UserRepository.class);

    userService = new UserService(repository);
  }

  @Test
  public void shouldReturnEmptyIfUserIsUnexistent() {
    Optional<User> user = userService.getUserByEmail("unexistent_email@mail.com");
    Assertions.assertTrue(user.isEmpty());
  }

  @Test
  public void shouldReturnUserIfUserIsExistent() {
    Mockito.when(repository.getUserByEmail(any())).thenReturn(Optional.of(UserBuilder.oneUser().build()));

    Optional<User> user = userService.getUserByEmail("unexistent_email@mail.com");
    Assertions.assertTrue(user.isPresent());
  }

  @Test
  public void shouldCreateUserWithSuccess() {
    Mockito.when(repository.save(any())).thenReturn(UserBuilder.oneUser().build());

    User userToSave = UserBuilder.oneUser().withId(null).build();

    User savedUser = userService.save(userToSave);

    Assertions.assertNotNull(savedUser.getId());

    Mockito.verify(repository).getUserByEmail(userToSave.getEmail());
  }
}
