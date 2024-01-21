package generic_demo;

public class OperationTest {
    public static void main(String[] args) {

        // for adding integer
        Operation<Integer> add = (a, b) -> a + b;
        System.out.println(add.process(2, 5));

        // for multiplication
        Operation<Float> mul = (x, y) -> (x * y);
        System.out.println(mul.process(4.5f, 5.6f));

        // for adding String
        Operation<String> addString = (str1, str2) -> {
            return str1 + str2;
        };
        System.out.println(addString.process("Jagdish", "Kamadi"));
    }
}
