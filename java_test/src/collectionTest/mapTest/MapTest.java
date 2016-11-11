package collectionTest.mapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2016/11/10.
 */
public class MapTest {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("java",100);
        map.put("java",90);
        map.put("python",10);
        map.put("javaScript",50);
        map.put("nodeJs", 40);
        System.out.println(map);
        System.out.println(map.get("python"));
        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        for (Object obj : map.entrySet()){
            Map.Entry obj2 = (Map.Entry)obj;
            System.out.println(obj2.getValue());
        }
        for(Object key : map.keySet()){
            System.out.println(map.get(key));
        }
        Object o = new Object();
        o.equals(o);
    }
}
