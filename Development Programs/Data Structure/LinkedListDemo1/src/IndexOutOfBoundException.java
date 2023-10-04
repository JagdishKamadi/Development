public class IndexOutOfBoundException extends RuntimeException {
    public IndexOutOfBoundException() {
        super("Not a valid index!");
    }

    public IndexOutOfBoundException(int index) {
        super("Index " + index + " doesn't exist in list");
    }
}
