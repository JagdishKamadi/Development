package pattern.design.creational.singletone;

// 3) SingletonSynchronizedMethod initialization
public class SingletonSynchronizedMethod {

    public static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){};

    // making method sychronized
    public static synchronized SingletonSynchronizedMethod getInstance()
    {
        if(instance == null)
            instance = new SingletonSynchronizedMethod();

        return instance;
    }
}
