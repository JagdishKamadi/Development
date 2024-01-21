package generic_list;

public class GenericListRunner {
    public static void main(String[] args) {
        // Integer list demonstration
        GenericListService<Integer> integerList = new GenericListService<>();
        integerList.insert(4);
        integerList.insert(-1);
        integerList.insert(67);
        integerList.show();
        System.out.println(integerList.size());

        // String list demonstration
        System.out.println();
        GenericListService<String> stringList = new GenericListService<>();
        stringList.insert("Jagdish");
        stringList.insert("Madhur");
        stringList.insert("Sagar");
        stringList.show();
        System.out.println(stringList.size());

        GenericListService<Character> characterList = null;
        try {
            // Character list demonstration
            System.out.println();
            characterList = new GenericListService<>();
            characterList.insert('c');
            characterList.insert('a');
            characterList.insert('o');
            System.out.println(characterList.size());
            characterList.show();
            characterList.insertAtStart('p');
            characterList.show();
            characterList.insertAt(2, 'x');
            characterList.show();
            characterList.deleteAt(0);
            characterList.show();
            characterList.deleteAt(3);
            characterList.show();
            characterList.deleteAt(9);
        } catch (IndexOutOfBoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(characterList.size());
            characterList.show();
        }
    }
}