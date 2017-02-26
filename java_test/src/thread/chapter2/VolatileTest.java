package thread.chapter2;

/**
 * Created by tuzhenyu on 17-2-25.
 */
class MyThread extends Thread{
    volatile private static int race;
    private static void add(){
        for (int i=0;i<100;i++){
            race++;
        }
        System.out.println(Thread.currentThread().getName()+":"+race);
    }

    @Override
    public void run() {
        add();
    }
}
public class VolatileTest {

    public static void main(String[] args) {
        Thread[] threads = new MyThread[20];
        for (int i=0;i<20;i++){
            threads[i] = new MyThread();
        }
        for (int i=0;i<20;i++){
            threads[i].start();
        }
    }
}
