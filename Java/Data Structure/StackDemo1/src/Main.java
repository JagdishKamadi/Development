public class Main {
    public static void main(String[] args) {
        StackService stack = new StackService();
        stack.push(1);
        stack.push(0);
        stack.push(89);
        stack.push(15);

        stack.show();

        System.out.println(stack.pop());

        stack.show();

        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());

        System.out.println("Size : " + stack.size());

        stack.push(68);
        stack.push(60);
        stack.show();
        System.out.println(stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("\n"+"*".repeat(20));
        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
        stack.show();
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}