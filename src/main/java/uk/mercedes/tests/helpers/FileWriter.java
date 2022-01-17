package uk.mercedes.tests.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Manage the file I/O;
 */
public class FileWriter {

    public static void write(String filePath, String data) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath, "UTF-8");
            writer.println(data);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception ignore) {}
        }
    }
}
