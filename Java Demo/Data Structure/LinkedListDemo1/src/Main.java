public class Main {
    public static void main(String[] args) {
        LinkedListService lst = null;
        try {
            lst = new LinkedListService();
            lst.insert(12);
            lst.insert(14);
            lst.insert(-1);
            lst.insert(-4);
            lst.insert(99);

            lst.insertAtFirst(56);
            lst.insertAtFirst(-67);

            lst.insertAt(2, 58);
            lst.insertAt(0, 6);
            lst.insertAt(20, 9);

        } catch (IndexOutOfBoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Size : " + lst.size());
            lst.show();
            lst.deleteAt(3);
            System.out.println("Size : " + lst.size());
            lst.show();
            lst.deleteAt(0);
            lst.deleteAt(45);
            lst.show();
            lst.show();
        } catch (IndexOutOfBoundException e) {
            System.out.println(e.getMessage());
        } finally {
            lst.show();
            System.out.println("Size : " + lst.size());
        }
    }
}