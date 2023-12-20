package custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * ElementType.METHOD means it works only for the class
 * 99 percent we use RetentionPolicy.Runtime
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately {

    // for the field we have to create the create method like structure
    int times() default 1;
}
