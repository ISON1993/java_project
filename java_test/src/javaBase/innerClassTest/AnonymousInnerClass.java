package javaBase.innerClassTest;

/**
 * Created by user on 2016/11/7.
 */
abstract class Person{
    public abstract void eat();
}
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Person man = new Person() {
            @Override
            public void eat() {
                System.out.println("a man is eating");
            }
        };
        man.eat();
    }
}
