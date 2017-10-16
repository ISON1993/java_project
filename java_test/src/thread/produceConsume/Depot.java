package thread.produceConsume;


/**
 * Created by tuzhenyu on 17-10-16.
 * @author tuzhenyu
 */
public class Depot {
    private int capacity;
    private int size;

    public Depot(int capacity){
        this.capacity = capacity;
        size = 0;
    }

    public synchronized void produce(){
        try {
            while (size>=capacity)
                wait();
            size++;
            System.out.println("生产者生产一个，当前数量为："+size);
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public synchronized void consume(){
        try {
            while (size<=0)
                wait();
            size--;
            System.out.println("消费者消费一个，当前数量为："+size);
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
