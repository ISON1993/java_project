package ploymorphism;

/**
 * Created by user on 2016/10/29.
 */
public class FatherClass {
    public String name = "father";
    public void father(){
        System.out.println("fatherClass ordinary method");
    }
    public String play(){
        System.out.println("fatherClass test method");
        return "fatherClass test method";
    }
}
