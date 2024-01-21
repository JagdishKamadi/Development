package complex_demo2;

/**
 * this is example where we are passing lambda as argument
 */
public class OperationTest {
    public static void main(String[] args) {
        Operation operation = new Operation();
        Operation.Operator add = new Operation.Operator() {
            @Override
            public int process(int a, int b) {
                return a + b;
            }
        };

        System.out.println(operation.performOperation(4, 6, add));
    }
}
