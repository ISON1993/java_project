package thread.juc;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by tuzhenyu on 17-10-22.
 * @author tuzhenyu
 */
class MyThread extends Thread{
    private CyclicBarrier cb;
    public MyThread(String name,CyclicBarrier cb){
        super(name);
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is going to await");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName()+" is going to continue");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class CyclicBarrierDemo {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("barrier action");
            }
        });
        MyThread t1 = new MyThread("t1",cb);
        MyThread t2 = new MyThread("t2",cb);
        t1.start();
        t2.start();
        System.out.println("main is going to await");
        cb.await();
        System.out.println("main is going to continue");
    }
}
