package infrastructure.dummies;

import java.util.Optional;

import com.alvarenga.domain.User;
import com.alvarenga.repositories.UserRepository;

import domain.builders.UserBuilder;

public class UserDummyRepository implements UserRepository {

  @Override
  public User save(User user) {
    return UserBuilder.oneUser()
        .withName(user.getName())
        .withEmail(user.getEmail())
        .withPassword(user.getPassword())
        .build();
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    if ("valid_email@mail.com".equals(email))
      return Optional.of(UserBuilder.oneUser()
          .withEmail(email)
          .build());
    return Optional.empty();
  }
}
