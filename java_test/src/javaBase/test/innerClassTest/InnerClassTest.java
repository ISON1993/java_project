package javaBase.test.innerClassTest;

/**
 * Created by user on 2016/11/6.
 */
public class InnerClassTest {
    public class InnerClass{
        public String inner;
    }
    public void test(){
        InnerClass innerClass = new InnerClass();
    }
    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.test();
    }
}
