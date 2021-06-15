package fr.corentinmb;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest
{
    @Test
    void shouldReturnExpectedOutput() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String path = "src/test/resources/input.txt";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        App.main(new String[] {absolutePath});

        String expected =
            "1 3 N\n" +
            "5 1 E\n";

        assertThat(outContent.toString()).hasToString(expected);
    }
}
