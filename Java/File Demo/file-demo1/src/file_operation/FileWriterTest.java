package file_operation;

import java.io.*;
import java.nio.file.Files;

public class FileWriterTest {
    public static void main(String[] args) {
        String fileName = "temp.txt";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("My name is khan");

        } catch (IOException e) {
            System.out.println(e.getCause());
        }


        // we are reading here line by line
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getCause());
        } finally {
            // we are also deleting the file
            File file = new File(fileName);
            if (file.exists()) {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("File deleted successfully");
            }
        }
    }
}
