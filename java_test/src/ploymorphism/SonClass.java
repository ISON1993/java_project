package ploymorphism;

/**
 * Created by user on 2016/10/29.
 */
public class SonClass extends FatherClass{
    public String name = "son";
    public void son(){
        System.out.println("sonClass ordinary method");
    }
    public String play(){
        System.out.println("sonClass test method");
        return "sonClass test method";
    }

    public static void main(String[] args) {
        FatherClass fatherSon = new SonClass();
        System.out.println(fatherSon.name);
       SonClass sonClass = (SonClass)fatherSon;
        sonClass.son();
    }
}
