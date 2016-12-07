package genericity;

import java.util.Collection;
import java.util.List;

/**
 * Created by tuzhenyu on 16-11-23.
 */
public class Tongpeifu {
    public static void main(String[] args) {

    }
    static void fromArrayToCollectionTest1(Object[] a, Collection<Object> c){
        for (Object o : a){
            c.add(o);
        }
    }
    static void fromArrayToCollectionTest11(Object[] a, Collection<? extends Object> c){
        for (Object o : a){
//            c.add(o);
        }
    }
    static <T> void fromArrayToCollectionTest2(T[] a, Collection<T> c){
        for (T o : a){
            c.add(o);
        }
    }
    static <T> void fromArrayToCollectionTest3(List<T> a, List<? extends T> c){
        for (T o : c){
            a.add(o);
        }
    }
    static <T,S extends T> void fromArrayToCollectionTest4(List<T> a, List<S> c){
        for (T o : c){
            a.add(o);
        }
    }
}
