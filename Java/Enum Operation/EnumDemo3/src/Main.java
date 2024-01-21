import enum_ops.Operation;


public class Main {
    public static void main(String[] args) {
        Integer add = Operation.ADD.apply(4, 5);
        System.out.println(add);

        Integer sub = Operation.SUBTRACT.apply(4, 5);
        System.out.println(sub);
    }
}