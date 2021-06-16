package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionRepositoryTest {

    @Test
    void should_add_transactions_with_given_amount_when_invoke_addDeposit() {
        Clock clock = mock(Clock.class);
        TransactionRepository repository = new TransactionRepository(clock);
        String dateString = "16/06/2021";
        when(clock.todayAsString()).thenReturn(dateString);
        int amount = 1;

        repository.addDeposit(amount);

        assertEquals(1, repository.transactions.size());
        assertEquals(amount, repository.transactions.get(0).amount());
        assertEquals(dateString, repository.transactions.get(0).date());
    }

    @Test
    void should_add_transactions_with_negative_given_amount_when_invoke_addWithdraw() {
        Clock clock = mock(Clock.class);
        TransactionRepository repository = new TransactionRepository(clock);
        String dateString = "16/06/2021";
        when(clock.todayAsString()).thenReturn(dateString);
        int amount = 1;

        repository.addWithdraw(amount);

        assertEquals(1, repository.transactions.size());
        assertEquals(-amount, repository.transactions.get(0).amount());
        assertEquals(dateString, repository.transactions.get(0).date());
    }

    @Test
    void should_return_unmodifiable_transactions_when_invoke_allTransactions() {
        Clock clock = mock(Clock.class);
        TransactionRepository repository = new TransactionRepository(clock);

        List<Transaction> transactions = repository.allTransactions();

        Assertions.assertThrows(UnsupportedOperationException.class, () -> transactions.add(new Transaction("", 1)));

    }

}
