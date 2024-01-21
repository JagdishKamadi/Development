package generic_list;

public class GenericListService<T> {
    private Node<T> head;
    private Node<T> tail;

    public void insert(T data) {

        Node<T> tNode = new Node<>(data);

        if (head == null) {
            head = tail = tNode;
        } else {
            tail.next = tNode;
            tail = tNode;
        }
    }

    public void insertAtStart(T data) {
        Node<T> tNode = new Node<>(data);
        tNode.next = head;
        head = tNode;
    }

    public void insertAt(Integer index, T data) {

        if (index > size() && index < 0) {
            throw new IndexOutOfBoundException(index);
        }

        if (index == 0) {
            insertAtStart(data);
        } else {
            Node<T> tNode = new Node<>(data);
            Node travers = head;

            for (int i = 0; i < index - 1; i++) {
                travers = travers.next;
            }
            tNode.next = travers.next;
            travers.next = tNode;
        }
    }

    public void deleteAt(final Integer index) {
        if (index > size() && index < 0) {
            throw new IndexOutOfBoundException(index);
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node travers = head;

            for (int i = 0; i < index - 1; i++) {
                travers = travers.next;
            }
            Node deleteNode = travers.next;
            travers.next = deleteNode.next;
        }
    }

    public void show() {

        if (head == null) {
            System.out.println("[null]\n");
        } else {
            Node node = head;
            System.out.print("[");
            while (node.next != null) {
                System.out.print(node.data + ",");
                node = node.next;
            }
            System.out.print(node.data + "]\n");
        }
    }

    public Integer size() {
        int count = 0;
        Node travers = head;

        while (travers != null) {
            travers = travers.next;
            count++;
        }
        return count;
    }
}
