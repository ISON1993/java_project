package super_test;

/**
 * Created by user on 2016/10/27.
 */
public class FatherClass {
    private int x = printInit("in the FatherClass x printInit");
    public FatherClass(String flag){
        System.out.println(flag);
        System.out.println("in the FatherClass constructor");
        System.out.println("hahaha");
        something();
    }
    private static int y = printInit("in the FatherClass y printInit");
    public final void play(){
        System.out.println("int the FatherClass play");
    }
    public static int printInit(String s){
        System.out.println(s);
        return 1;
    }
    public void something(){
        System.out.println("in the FatherClass something");
    }
}
