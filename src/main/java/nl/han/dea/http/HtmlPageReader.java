package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HtmlPageReader {
    public String readFile(String filename) {
        var fullFileName = "pages/".concat(filename);
        try {
            

            var file = getClass().getClassLoader().getResourceAsStream(fullFileName);

            var fileAsString = new String(file.readAllBytes());

            return fileAsString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}