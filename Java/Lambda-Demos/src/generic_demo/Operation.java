package generic_demo;

@FunctionalInterface
public interface Operation<T> {
    T process(T t1, T t2);
}
