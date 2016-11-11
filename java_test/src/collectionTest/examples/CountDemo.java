package collectionTest.examples;

import java.util.TreeMap;

/**
 * Created by user on 2016/11/10.
 */
public class CountDemo {
    public static void main(String[] args) {
        String str="sdfgesdgsdxjahskjsaxkskfdsfcbxbbfhj";
        char[] str2 = str.toCharArray();
        TreeMap<Character,Integer> count = new TreeMap<>();
        for (char c : str2){
            if(!count.containsKey(c)){
                count.put(c,1);
            }
            else{
                count.put(c,count.get(c)+1);
            }
        }
        System.out.println(count);
        System.out.println(count.firstEntry());
    }
}
