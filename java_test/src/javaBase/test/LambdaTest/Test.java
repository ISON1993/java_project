package javaBase.test.LambdaTest;

/**
 * Created by user on 2016/11/6.
 */
@FunctionalInterface
public interface Test<T> {
    void accept(T t);
    default void test(){

    }
}
