package thread;

/**
 * Created by tuzhenyu on 16-12-26.
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("in the main");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("in the runnable");
    }
}
