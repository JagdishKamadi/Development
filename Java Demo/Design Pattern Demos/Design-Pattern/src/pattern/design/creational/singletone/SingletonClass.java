package pattern.design.creational.singletone;

// 2)  lazy initialization
public class SingletonClass {

    // 1st step
    public static SingletonClass singletonClassInstance;

    // 2nd step
    private SingletonClass(){}

    // 3rd step

    public static SingletonClass getInstance()
    {
        if(singletonClassInstance == null)
            singletonClassInstance = new SingletonClass();

        return singletonClassInstance;
    }

}
