package com.alvarenga.services;

import java.util.List;

import com.alvarenga.domain.Account;
import com.alvarenga.domain.exceptions.ValidationException;
import com.alvarenga.repositories.AccountRepository;

public class AccountService {
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account save(Account account) {
    List<Account> accounts = accountRepository.findAccountsByUserId(account.getUser().getId());

    accounts.stream().forEach(exitentAccount -> {
      if (exitentAccount.getName().equalsIgnoreCase(account.getName())) {
        throw new ValidationException("O usuário já possui uma conta com o mesmo nome");
      }
    });

    return accountRepository.save(account);
  }
}
