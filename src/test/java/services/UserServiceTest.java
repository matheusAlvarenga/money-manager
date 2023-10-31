package services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alvarenga.domain.User;
import com.alvarenga.domain.exceptions.ValidationException;
import com.alvarenga.repositories.UserRepository;
import com.alvarenga.services.UserService;

import domain.builders.UserBuilder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
  @Mock
  private UserRepository repository;
  @InjectMocks
  private UserService userService;

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

  @Test
  public void shouldRejectAnExistentUser() {
    Mockito.when(repository.getUserByEmail(any())).thenReturn(Optional.of(UserBuilder.oneUser().build()));

    User userToSave = UserBuilder.oneUser().withId(null).build();

    ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> {
      userService.save(userToSave);
    });

    Assertions.assertTrue(exception.getMessage().contains("já existe"));

    Mockito.verify(repository).getUserByEmail(userToSave.getEmail());
    Mockito.verify(repository, Mockito.never()).save(userToSave);
  }
}
