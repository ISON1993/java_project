package thread.chapter1.threadFuntion;

/**
 * Created by tuzhenyu on 17-1-9.
 * tuzhenyu
 */
class MythreadSleep extends Thread{
    @Override
    public void run(){
        try {
            System.out.println(this.currentThread().getName() + '-' + this.currentThread().getId()+":begin");
            Thread.sleep(2000);
            System.out.println(this.currentThread().getName() + '-' + this.currentThread().getId()+":end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
public class ThreadSleep {
    public static void main(String[] args) {
        MythreadSleep mythreadSleep = new MythreadSleep();
        mythreadSleep.run();
        Thread t1 = new Thread(mythreadSleep);
        Thread t2 = new Thread(mythreadSleep);
        Thread t3 = new Thread(mythreadSleep);

        t1.start();
        t2.start();
        t3.start();
    }
}
