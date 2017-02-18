package collectionTest.setTest;

import java.util.HashSet;

/**
 * Created by user on 2016/11/10.
 */
class SetTest{
    public boolean equals(Object obj){
        return true;
    }
    public int hashCode(){
        return 1;
    }
}
public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs = new HashSet    ();
        hs.add(new SetTest());
        hs.add(new SetTest());
        hs.add(new SetTest());
        System.out.println(hs);
        System.out.println("/****************/");
        hs.clear();
        SetTest st = new SetTest();
        hs.add(st);
        hs.add(st);
        hs.add(st);
        System.out.println(hs);
    }
}
