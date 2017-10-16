package thread.produceConsume;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by tuzhenyu on 17-10-16.
 * @author tuzhenyu
 */
public class Depot {
    private int capacity;
    private int size;

    private final Lock lock = new ReentrantLock();
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public Depot(int capacity){
        this.capacity = capacity;
        size = 0;
    }

    public void produce(){
        lock.lock();
        try {
            while (size>=capacity)
                notFull.await();
            size++;
            System.out.println("生产者生产一个，当前数量为："+size);
            notEmpty.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void consume(){
        lock.lock();
        try {
            while (size<=0)
                notEmpty.await();
            size--;
            System.out.println("消费者消费一个，当前数量为："+size);
            notFull.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
