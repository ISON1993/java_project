package thread.chapter1.threadStop;

/**
 * Created by tuzhenyu on 17-2-25.
 */
public class MainThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println("end");
    }
}
