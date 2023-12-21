public class StackService {
    private Integer capacity = 0;
    private Integer stack[];
    private Integer top = 0;

    public StackService() {
        this.capacity = 5;
        stack = new Integer[capacity];
    }

    public StackService(final Integer capacity) {
        this.capacity = capacity;
        stack = new Integer[capacity];
    }

    public void push(final Integer value) {
        if (!isFull()) {
            stack[top] = value;
            top++;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public Integer pop() {
        Integer value = 0;

        if (!isEmpty()) {
            top--;
            value = stack[top];
            stack[top] = null;
        } else {
            top = -1;
        }
        return value;
    }

    public Integer peek() {
        return !isEmpty() ? stack[top - 1] : null;
    }

    public Boolean isEmpty() {
        return top == 0;
    }

    public Boolean isFull() {
        return top == capacity;
    }

    public Integer size() {
        return top;
    }

    public void show() {
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
