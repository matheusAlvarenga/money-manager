package com.alvarenga.repositories;

import java.util.Optional;

import com.alvarenga.domain.User;

public interface UserRepository {

  User save(User user);

  Optional<User> getUserByEmail(String email);
}
