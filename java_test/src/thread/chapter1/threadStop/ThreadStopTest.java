package thread.chapter1.threadStop;

/**
 * Created by tuzhenyu on 17-2-25.
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run:"+ System.currentTimeMillis());
        super.run();
        for (int i=0;i<200;i++){
            if(i == 100){
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().interrupt();
                System.out.println(Thread.interrupted());
            }
            System.out.println("i:"+i);
        }

    }
}
public class ThreadStopTest {
    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("start:"+System.currentTimeMillis());
        Thread.sleep(2000);
        System.out.println("sleep:"+System.currentTimeMillis());
        myThread.interrupt();
        System.out.println("interrupt:"+System.currentTimeMillis());

    }
}
