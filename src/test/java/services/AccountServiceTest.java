package services;

import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alvarenga.domain.Account;
import com.alvarenga.domain.exceptions.ValidationException;
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

  @Test
  public void shouldRejectDuplicatedAccount() {
    Mockito.when(repository.findAccountsByUserId(any()))
        .thenReturn(Arrays.asList(AccountBuilder.oneAccount().build()));

    Account accountToSave = AccountBuilder.oneAccount().build();

    ValidationException exception = Assertions.assertThrows(ValidationException.class, () -> {
      accountService.save(accountToSave);
    });

    Assertions.assertEquals(exception.getMessage(), "O usuário já possui uma conta com o mesmo nome");
  }

  @Test
  public void shouldSaveDuplicatedAccountWithDifferentNames() {
    Mockito.when(repository.findAccountsByUserId(any()))
        .thenReturn(Arrays.asList(AccountBuilder.oneAccount().withName("Another account").build()));
    Mockito.when(repository.save(any())).thenReturn(AccountBuilder.oneAccount().build());

    Account accountToSave = AccountBuilder.oneAccount().build();

    Account savedAccount = accountService.save(accountToSave);

    Assertions.assertNotNull(savedAccount.getId());
  }
}