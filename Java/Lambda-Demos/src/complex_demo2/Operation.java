package complex_demo2;

public class Operation {
    interface Operator {
        int process(int a, int b);
    }

    public int performOperation(int a, int b, Operator operator) {
        return operator.process(a, b);
    }
}
