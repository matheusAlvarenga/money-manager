package com.alvarenga.services;

import com.alvarenga.domain.Account;
import com.alvarenga.repositories.AccountRepository;

public class AccountService {
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account save(Account account) {
    return accountRepository.save(account);
  }
}
