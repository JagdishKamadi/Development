package complex_demo;

/**
 * this is example where we are passing lambda as argument
 */

public class LambdaTest {
    interface Operation {
        int process(int n1, int n2);
    }

    public int performOperation(int a, int b, Operation operation) {
        return operation.process(a, b);
    }

    public static void main(String[] args) {
        Operation add = (a, b) -> (a + b);
        LambdaTest lambdaTest = new LambdaTest();
        System.out.println(lambdaTest.performOperation(5, 6, add));

        Operation mul = (a, b) -> a * b;
        System.out.println(lambdaTest.performOperation(4, 5, mul));

    }
}
