package services;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alvarenga.domain.Account;
import com.alvarenga.repositories.AccountRepository;
import com.alvarenga.services.AccountService;

import domain.builders.AccountBuilder;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {
  @Mock
  private AccountRepository repository;

  @InjectMocks
  private AccountService accountService;

  @Test
  public void shouldSaveAccountWithSuccess() {
    Mockito.when(repository.save(any())).thenReturn(AccountBuilder.oneAccount().build());

    Account accountToSave = AccountBuilder.oneAccount().build();

    Account savedAccount = accountService.save(accountToSave);

    Assertions.assertNotNull(savedAccount.getId());
  }
}