package traversal;

public class Node {
    private Integer data;
    Node left;
    Node right;

    public Node(final Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Integer getData() {
        return this.data;
    }
}
