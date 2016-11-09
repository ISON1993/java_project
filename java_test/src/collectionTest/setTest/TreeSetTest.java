package collectionTest.setTest;

import java.util.TreeSet;

/**
 * Created by user on 2016/11/9.
 */
class Test implements Comparable{
    public int compareTo(Object obj){
        return 0;
//        return 1;
    }
}
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        Test t = new Test();
        ts.add(new Test());
        ts.add(new Test());
        ts.add(new Test());
        ts.add(t);
        ts.add(t);
        ts.stream().forEach(ele -> System.out.println(ele));

        TreeSet ts2 = new TreeSet();
        ts2.add(11);
        ts2.add(3);
        ts2.add(5);
        ts2.add(2);
        ts2.add(2);
        ts2.add(9);
        ts2.stream().forEach(ele -> System.out.println(ele));
    }
}
