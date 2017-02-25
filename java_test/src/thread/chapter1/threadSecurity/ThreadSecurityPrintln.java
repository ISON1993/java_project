package thread.chapter1.threadSecurity;

/**
 * Created by tuzhenyu on 17-1-9.
 * tuzhenyu
 */
class Mythread extends Thread{
    private int i = 5;
    @Override
    public void run(){
       System.out.println("i:"+ (i--) + " by " + this.currentThread().getName());
    }
}
public class ThreadSecurityPrintln {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
        Thread t1 = new Thread(mythread);
        Thread t2 = new Thread(mythread);
        Thread t3 = new Thread(mythread);
        Thread t4 = new Thread(mythread);
        Thread t5 = new Thread(mythread);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
