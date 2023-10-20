package com.alvarenga.repositories;

import com.alvarenga.domain.Account;

public interface AccountRepository {
  Account save(Account account);
}
