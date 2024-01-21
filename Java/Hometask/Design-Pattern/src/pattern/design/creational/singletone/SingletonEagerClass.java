package pattern.design.creational.singletone;

// 1) Eager initialization
public class SingletonEagerClass {

    // 1st step
    public static SingletonEagerClass singletonEagerClass = new SingletonEagerClass();

    // 2nd step
    private SingletonEagerClass(){}

    public static SingletonEagerClass getInstance()
    {
        return singletonEagerClass;
    }

    public void show()
    {
        System.out.println("I am from SingletonEagerClass");
    }
}
