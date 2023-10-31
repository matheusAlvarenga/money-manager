package com.alvarenga.repositories;

import java.util.List;

import com.alvarenga.domain.Account;

public interface AccountRepository {
  Account save(Account account);

  List<Account> findAccountsByUserId(Long userId);
}
