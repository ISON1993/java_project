package javaBase.test.super_test;

/**
 * Created by user on 2016/10/27.
 */
public class SonClass extends FatherClass {
    private int x = printInit("in the SonClass x printInit");
    public SonClass(){
        super("hello");
        System.out.println("in the SonClass constructor");
    }
    private static int y = printInit("in the SonClass y printInit");
//    public final void play(){     //overriden method is final
//
//    }
    public static void main(String[] args){
        System.out.println("in the SonClass main");
        SonClass sonClass = new SonClass();
        sonClass.something();
//        FatherClass fatherClass = new FatherClass("create a FatherClass");
//        fatherClass.something();
    }

    public void something(){
        System.out.println("in the SonClass something");
    }
}
