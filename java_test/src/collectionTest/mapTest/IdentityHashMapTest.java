package collectionTest.mapTest;

import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * Created by user on 2016/11/10.
 */
public class IdentityHashMapTest {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("java",88);
        hm.put("java",88);
        hm.put(new String("python"), 90);
        hm.put(new String("python"), 90);
        System.out.println(hm);

        IdentityHashMap hm2 = new IdentityHashMap();
        hm2.put("java",88);
        hm2.put("java",88);
        hm2.put(new String("python"), 90);
        hm2.put(new String("python"), 90);
        System.out.println(hm2);

        Object obj =  new Object();
        obj.equals(obj);

        String str = new String("hahah");
        str.equals(str);
    }
}
