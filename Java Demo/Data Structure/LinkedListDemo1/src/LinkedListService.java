public class LinkedListService {
    private Node head;
    private Node tail;


    public void insert(final Integer data) {
        Node node = new Node(data);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;

            /*Node travelNode = head;

            while (travelNode.next != null) {
                travelNode = travelNode.next;
            }
            travelNode.next = node;*/

        }
    }

    public void insertAtFirst(final Integer data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void insertAt(final Integer index, final Integer data) {
        if (index > size()) {
            throw new IndexOutOfBoundException(index);
        }

        if (index == 0) {
            insertAtFirst(data);
        } else {
            Node travelNode = head;
            for (int i = 0; i < index - 1; i++) {
                travelNode = travelNode.next;
            }
            Node node = new Node(data);
            node.next = travelNode.next;
            travelNode.next = node;
        }
    }

    public void deleteAt(final Integer index) {
        Node deleteNode = null;

        if (index > size() || index < 0) {
            throw new IndexOutOfBoundException(index);
        }

        if (index == 0) {
            deleteNode = head;
            head = head.next;
        } else {
            Node travelNode = head;
            for (int i = 0; i < index - 1; i++) {
                travelNode = travelNode.next;
            }
            // store delete the node
            deleteNode = travelNode.next;
            // link the node before delete node to node after delete node
            travelNode.next = deleteNode.next;
        }

    }


    public int size() {
        Node travelNode = head;

        int size = 0;

        while (travelNode != null) {
            travelNode = travelNode.next;
            size++;
        }
        return size;
    }

    public void show() {
        Node travelNode = head;

        if (head != null) {
            System.out.print("[");
            while (head != null && travelNode.next != null) {
                System.out.print(travelNode.data + ", ");
                travelNode = travelNode.next;
            }
        }

        if (head != null) {
            System.out.print(travelNode.data + "]\n");
        } else {
            System.out.println("null");
        }
    }
}
