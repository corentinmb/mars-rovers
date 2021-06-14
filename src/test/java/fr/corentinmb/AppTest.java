package fr.corentinmb;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class AppTest
{
    @Test
    void shouldReturnExpectedOutput() throws IOException {
        String path = "src/test/resources/input.txt";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        App.main(new String[] {absolutePath});
    }
}
