package thread.chapter3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tuzhenyu on 17-2-26.
 * @author tuzhenyu
 */
class Tools{
    public static ThreadLocal t1 = new ThreadLocal();
}
class ThreadLocalThread extends Thread
{
    private AtomicInteger ai = new AtomicInteger();

    public ThreadLocalThread(String name)
    {
        super(name);
    }

    public void run()
    {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Tools.t1.set(ai.addAndGet(1) + "");
                System.out.println(this.getName() + " get value--->" + Tools.t1.get());
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocalThread a = new ThreadLocalThread("ThreadA");
        ThreadLocalThread b = new ThreadLocalThread("ThreadB");
        ThreadLocalThread c = new ThreadLocalThread("ThreadC");
        a.start();
        b.start();
        c.start();
    }
}
