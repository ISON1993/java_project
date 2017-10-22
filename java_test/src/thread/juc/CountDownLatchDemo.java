package thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tuzhenyu on 17-10-22.
 * @author tuzhenyu
 */
class MyThread2 extends Thread{
    private CountDownLatch cd;
    public MyThread2(String name,CountDownLatch cd){
        super(name);
        this.cd = cd;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is start");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" is countDownLatch");
        cd.countDown();
    }
}
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cd = new CountDownLatch(2);
        MyThread2 t1 = new MyThread2("t1",cd);
        MyThread2 t2 = new MyThread2("t2",cd);
        t1.start();
        t2.start();
        System.out.println("main function is going to await");
        try {
            cd.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("main function is going to continue");
    }
}
