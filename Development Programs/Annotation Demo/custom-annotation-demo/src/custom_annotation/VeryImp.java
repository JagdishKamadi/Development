package custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ElementType.TYPE means it works only for the class
 * 99 percent we use RetentionPolicy.Runtime
 */
@Target(ElementType.TYPE)

@Retention(RetentionPolicy.RUNTIME)
public @interface VeryImp {
}
