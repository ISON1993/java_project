package thread.threadSuspend;

/**
 * Created by tuzhenyu on 17-2-25.
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("in the run");
        super.run();
        long start = System.currentTimeMillis();
        for (int i=0;i<200;i++){
//            if (i == 100){
//                Thread.yield();
//            }
            System.out.println("i:"+i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start));
    }
}

public class ThreadSuspendTest{
    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        System.out.println("come back to main");
    }
}
