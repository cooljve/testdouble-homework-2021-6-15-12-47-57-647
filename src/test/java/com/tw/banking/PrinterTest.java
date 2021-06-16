package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PrinterTest {
    @Test
    void should_console_printLine_when_invoke_print() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);

        printer.print(new ArrayList<>());

        verify(console).printLine(Printer.STATEMENT_HEADER);
    }

    @Test
    void should_return_stable_format_string_when_invoke_statementLine() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        Transaction transaction = new Transaction("16/06/2021", 300);

        String result = printer.statementLine(transaction, transaction.amount());

        assertEquals("16/06/2021 | 300 | 300", result);
    }

    @Test
    void should_print_reverseOrder_info_when_invoke_print() {
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        Printer spyPrinter = spy(printer);
        Transaction one = new Transaction("16/06/2021", 300);
        Transaction two = new Transaction("18/06/2021", -100);
        Transaction three = new Transaction("20/06/2021", -100);
        List<Transaction> transactions = Arrays.asList(two, one, three);
        when(spyPrinter.statementLine(one, 300)).thenReturn("one");
        when(spyPrinter.statementLine(two, 200)).thenReturn("two");
        when(spyPrinter.statementLine(three, 100)).thenReturn("three");

        spyPrinter.print(transactions);

        InOrder inOrder = Mockito.inOrder(console);
        inOrder.verify(console).printLine("three");
        inOrder.verify(console).printLine("two");
        inOrder.verify(console).printLine("one");
    }

}
