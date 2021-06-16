package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountTest {
    @Test
    void should_invoke_repository_add_deposit_when_invoke_deposit() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Account account = new Account(transactionRepository, new Printer(new Console()));

        account.deposit(1);

        verify(transactionRepository).addDeposit(anyInt());
    }

    @Test
    void should_invoke_repository_add_withdraw_when_invoke_withdraw() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Account account = new Account(transactionRepository, new Printer(new Console()));

        account.withdraw(1);

        verify(transactionRepository).addWithdraw(anyInt());
    }

    @Test
    void should_invoke_printer_print_when_invoke_printStatement() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Printer printer = mock(Printer.class);
        Account account = new Account(transactionRepository, printer);

        account.printStatement();

        verify(printer).print(any());
    }

}
