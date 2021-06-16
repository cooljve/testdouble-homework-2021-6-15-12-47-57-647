package com.tw.banking;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleTest {
    @Test
    void should_print_line_in_console_when_invoke_printLine(){
        Console console = new Console();
        String line = "hello world";
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        console.printLine(line);

        assertThat(outputStream.toString()).contains(line);
    }

}
