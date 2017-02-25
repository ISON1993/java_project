package thread.chapter1.threadSecurity;

/**
 * Created by tuzhenyu on 16-12-26.
 */
public class ThreadSecurity {
    public static void main(String[] args) {
        MyThreadSecurity myThread = new MyThreadSecurity();
        Thread thread1 = new Thread(myThread,"1");
        Thread thread2 = new Thread(myThread,"2");
        Thread thread3 = new Thread(myThread,"3");
        Thread thread4 = new Thread(myThread,"4");
        Thread thread5 = new Thread(myThread,"5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

class MyThreadSecurity extends Thread{
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由"+this.currentThread().getName()+":"+count);
    }
}
