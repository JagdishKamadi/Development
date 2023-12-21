package generic_method_demo;

public class GenericMethodClass {
    public <E> void printArray(E[] arr) {
        System.out.println();
        for (E each : arr) {
            System.out.print(each + " ");
        }
    }
}

class GenericMethodClassTest {
    public static void main(String[] args) {
        GenericMethodClass genericMethodClass1 = new GenericMethodClass();
        // below code give error as it doesn't work for primitive
//        int arr[] = {1,2,3};
//        genericMethodClass1.printArray(arr);

        Integer arr[] = {1, 2, 3};
        genericMethodClass1.printArray(arr);

        // no need to create extra object now
        GenericMethodClass genericMethodClass2 = new GenericMethodClass();
        String[] names = {"Jagdish", "Madhur", "Tejas"};
        genericMethodClass1.printArray(names);
    }
}