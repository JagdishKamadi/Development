package generic_list;

public class IndexOutOfBoundException extends RuntimeException {
    public IndexOutOfBoundException() {
        super("Index Out of Bound Exception!");
    }

    public IndexOutOfBoundException(Integer index) {
        super("Index " + index + " is out of bound for list!");
    }
}
