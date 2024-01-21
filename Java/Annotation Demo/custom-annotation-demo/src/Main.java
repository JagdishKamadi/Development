import custom_annotation.RunImmediately;
import custom_annotation.VeryImp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat();

        // checking the Cat class has @VeryImp annotation or not
        if (cat.getClass().isAnnotationPresent(VeryImp.class)) {
            System.out.println("Cat class has @VeryImp annotation");
        }

        // checking for each method

        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately runImmediately = method.getAnnotation(RunImmediately.class);

                for (int i = 0; i < runImmediately.times(); i++) {
                    method.invoke(cat);
                }
            }
        }
    }
}