package pattern.design.creational.singletone;
/**
 * There are following type of singletone  initialization
 * 1) Eager initialization
 * 2) Lazy initialization
 * 3) Thread safe method initialization
 * 4) Thread safe block initialization
 */


public record SingletonFactoryTest() {
    public static void main(String[] args) {

       // Eager initialization example
        System.out.println("==========+ Example of Eager Initialization +==========");
        SingletonEagerClass singletonEagerClass1 = SingletonEagerClass.getInstance();
        SingletonEagerClass singletonEagerClass2 = SingletonEagerClass.getInstance();
        // both object should be same
        System.out.println(singletonEagerClass1);
        System.out.println(singletonEagerClass2);
        singletonEagerClass1.show();


        System.out.println("\n==========+ Example of Lazy Initialization +==========");
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        SingletonClass singletonClass2 = SingletonClass.getInstance();
        System.out.println(singletonClass1);
        System.out.println(singletonClass2);

        System.out.println("\n==========+ Example of SingletonSynchronizedMethod Initialization +==========");
        SingletonSynchronizedMethod singletonSynchronizedMethod1 = SingletonSynchronizedMethod.getInstance();
        SingletonSynchronizedMethod singletonSynchronizedMethod2 = SingletonSynchronizedMethod.getInstance();
        System.out.println(singletonSynchronizedMethod1);
        System.out.println(singletonSynchronizedMethod2);

        System.out.println("\n==========+ Example of SingletonSynchronizedBlock Initialization +==========");
        SingletonSynchronizedBlock singletonSynchronizedBlock1 =SingletonSynchronizedBlock.getInstance();
        SingletonSynchronizedBlock singletonSynchronizedBlock2 =SingletonSynchronizedBlock.getInstance();
        System.out.println(singletonSynchronizedBlock1);
        System.out.println(singletonSynchronizedBlock2);


    }
}
