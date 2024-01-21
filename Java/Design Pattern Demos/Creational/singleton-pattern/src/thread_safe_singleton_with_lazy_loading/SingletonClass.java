package thread_safe_singleton_with_lazy_loading;

public class SingletonClass {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile SingletonClass instance;
    private String value;

    private SingletonClass(String value) {
        this.value = value;
    }

    public static SingletonClass getInstance(String value) {

        if (instance != null) {
            return instance;
        }

        synchronized (SingletonClass.class) {
            if (instance == null) {
                instance = new SingletonClass(value);
            }
            return instance;
        }
    }

    public String getValue() {
        return this.value;
    }
}
