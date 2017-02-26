package thread.chapter3;

/**
 * Created by tuzhenyu on 17-2-26.
 * @author tuzhenyu
 */
class Thread1 extends Thread{
    private Object object;

    public Thread1(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        try{
            synchronized (object){
                System.out.println("begin to wait:"+Thread.currentThread().getName());
                object.wait();
                System.out.println("wait end:"+Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Thread2 extends Thread{
    private Object object;

    public Thread2(Object object){
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            System.out.println("begin to notify:"+Thread.currentThread().getName());
            object.notify();
            System.out.println("notify end:"+Thread.currentThread().getName());
        }
    }
}
public class WaitNotifyTest {
    public static void main(String[] args) throws InterruptedException{
        Object o = new Object();
        Thread1 thread1 = new Thread1(o);
        thread1.start();
//        Thread.sleep(2000);
        Thread2 thread2 = new Thread2(o);
        thread2.start();
    }
}
