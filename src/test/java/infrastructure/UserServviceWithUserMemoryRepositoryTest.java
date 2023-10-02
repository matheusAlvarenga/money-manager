package infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.alvarenga.domain.User;
import com.alvarenga.domain.exceptions.ValidationException;
import com.alvarenga.infrastructure.UserMemoryRepository;
import com.alvarenga.services.UserService;

import domain.builders.UserBuilder;

public class UserServviceWithUserMemoryRepositoryTest {
  private UserService userService = new UserService(new UserMemoryRepository());

  @Test
  public void shouldSaveValidUser() {
    User user = userService.save(UserBuilder.oneUser().withId(null).build());

    Assertions.assertNotNull(user.getId());
  }

  @Test
  public void shouldNotSaveUserWithExistingEmail() {
    ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> {
      userService.save(UserBuilder.oneUser().withEmail("same_email@mail.com").build());
      userService.save(UserBuilder.oneUser().withEmail("same_email@mail.com").build());
    });

    Assertions.assertEquals("Um usuário com o email same_email@mail.com já existe", exception.getMessage());
  }
}
