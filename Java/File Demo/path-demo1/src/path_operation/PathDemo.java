package path_operation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) {
        Path directory = Paths.get(".");
        System.out.println(directory.toAbsolutePath());

        String fileName = "config.txt";
        Path path = Paths.get(fileName);
        System.out.println("Absolute Path : " + path.toAbsolutePath());

        String filePath = "D:\\Jagdish\\Development\\Java Demo\\File Demo\\path-demo1";
        Path path2 = Paths.get(filePath, "config.txt");
        System.out.println("Absolute Path : " + path2.toAbsolutePath());

        String filePath2 = "D:\\Jagdish\\..\\Java Demo\\File Demo\\path-demo1";
        Path path3 = Paths.get(filePath2);
        System.out.println("Normalize path :" + path3.normalize());

        // some other operations
        System.out.println("File Name : "+path2.getFileName());

        // now read the file
        try (FileReader fileReader = new FileReader(path.toFile())) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getCause());
        }


    }
}