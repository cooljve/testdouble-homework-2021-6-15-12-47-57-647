package com.tw.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void should_return_transaction_date_when_invoke_date() {
        String expectDate = "16/06/2021";
        int expectAmount = 100;
        Transaction transaction = new Transaction(expectDate, expectAmount);

        String date = transaction.date();

        assertEquals(expectDate, date);
    }

    @Test
    void should_return_transaction_amount_when_invoke_amount() {
        String expectDate = "16/06/2021";
        int expectAmount = 100;
        Transaction transaction = new Transaction(expectDate, expectAmount);

        int amount = transaction.amount();

        assertEquals(expectAmount, amount);
    }

    @Test
    void should_return_negative_1_when_invoke_compareTo_given_transaction_with_big_date(){
        Transaction small = new Transaction("16/06/2021", 100);
        Transaction big = new Transaction("20/06/2021", 100);

        int result = small.compareTo(big);

        assertEquals(-1, result);
    }

    @Test
    void should_return_1_when_invoke_compareTo_given_transaction_with_small_date(){
        Transaction small = new Transaction("16/06/2021", 100);
        Transaction big = new Transaction("20/06/2021", 100);

        int result = big.compareTo(small);

        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_invoke_compareTo_given_transaction_with_same_date(){
        Transaction one = new Transaction("16/06/2021", 100);
        Transaction two = new Transaction("16/06/2021", -100);

        int result = two.compareTo(one);

        assertEquals(1, result);
    }



}
