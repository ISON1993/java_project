package javaBase.toString_test;

/**
 * Created by user on 2016/10/25.
 */
public class FlagClass {
    private  String s;
    public FlagClass(){
        System.out.println("create a FlagClass");
        s = "s is created";
    }
    public String toString(){
        return s;
    }
}
