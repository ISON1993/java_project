package thread.chapter1.threadFuntion;

/**
 * Created by tuzhenyu on 17-1-9.
 */
class Mythread extends Thread{
    @Override
    public void run(){
        System.out.println(this.currentThread().getName());
    }
}
public class threadIsAlive {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        System.out.println(mythread.isAlive());
        Thread t1 = new Thread(mythread);
        System.out.println(mythread.isAlive());
        t1.start();
        System.out.println(mythread.isAlive());
        mythread.start();
        System.out.println(mythread.isAlive());
    }
}
