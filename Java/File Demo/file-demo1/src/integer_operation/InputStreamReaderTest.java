package integer_operation;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in)) {
            int number = inputStreamReader.read();

            while (inputStreamReader.ready()) {
                System.out.println((char) number);
                number = inputStreamReader.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}