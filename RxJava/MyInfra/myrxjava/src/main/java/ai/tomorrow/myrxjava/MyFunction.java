package ai.tomorrow.myrxjava;

public interface MyFunction<T, R> {
    R apply(T t) throws Exception;
}
