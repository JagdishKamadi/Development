public class Node {
    public Integer data;
    public Node next;

    public Node() {

    }

    public Node(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
