package thread.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by tuzhenyu on 17-10-23.
 * @author tuzhenyu
 */
class ReadThread extends Thread{
    private ReentrantReadWriteLock lock;
    public ReadThread(String name,ReentrantReadWriteLock lock){
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" try to lock");
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+" lock successfully");
        try {
            sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        lock.readLock().unlock();
        System.out.println(Thread.currentThread().getName()+" unlock successfully");
    }
}

class WriteThread extends Thread{
    private ReentrantReadWriteLock lock;
    public WriteThread(String name,ReentrantReadWriteLock lock){
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" try to lock");
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+" lock successfully");
        try {
            sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        lock.writeLock().unlock();
        System.out.println(Thread.currentThread().getName()+" unlock successfully");
    }
}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReadThread r1 = new ReadThread("r1",lock);
        ReadThread r2 = new ReadThread("r2",lock);
        WriteThread w1 = new WriteThread("w1",lock);
        WriteThread w2 = new WriteThread("w2",lock);
        r1.start();
        r2.start();
        w1.start();
        w2.start();
    }
}
