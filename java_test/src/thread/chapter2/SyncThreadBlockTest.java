package thread.chapter2;

import java.security.PrivateKey;

/**
 * Created by tuzhenyu on 17-2-25.
 */
class Task{
    public void getTimeTask(){
        for (int i=0;i<100;i++){
            System.out.println("async threadName:"+Thread.currentThread().getName()+" i:"+i);
        }
        synchronized (this){
            for (int i=0;i<100;i++){
                System.out.println("sync threadName:"+Thread.currentThread().getName()+" i:"+i);
            }
        }
    }
}
class Thread1 extends Thread{
    private Task task;
    public Thread1(Task task){
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        task.getTimeTask();
    }
}
class Thread2 extends Thread{
    private Task task;
    public Thread2(Task task){
        this.task = task;
    }
    @Override
    public void run() {
        super.run();
        task.getTimeTask();
    }
}
public class SyncThreadBlockTest {
    public static void main(String[] args) {
        Task task = new Task();
        System.out.println("thead1");
        Thread1 thread1 = new Thread1(task);
        thread1.start();
        System.out.println("thead2");
        Thread2 thread2 = new Thread2(task);
        thread2.start();
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
    }
}
