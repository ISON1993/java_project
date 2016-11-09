package collectionTest.setTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/11/9.
 */
public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(11);
        list.add(3);
        list.add(5);
        list.add(1);
        list.stream().forEach(ele -> System.out.println(ele));
        System.out.println(list);
//        System.out.println(list.sort(...));
    }
}
