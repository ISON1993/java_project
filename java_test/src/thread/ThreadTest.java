package thread;

/**
 * Created by tuzhenyu on 16-12-25.
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();
//        myThread1.run();
//        myThread2.run();
        System.out.println("运行结束");
//        myThread1.start();
//        myThread2.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("my thread1 is running");
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("my thread2 is running");
    }
}