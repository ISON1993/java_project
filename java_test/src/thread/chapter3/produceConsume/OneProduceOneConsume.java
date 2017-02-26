package thread.chapter3.produceConsume;

import thread.chapter2.SyncThreadBlockTest;

/**
 * Created by tuzhenyu on 17-2-26.
 * @author tuzhenyu
 */
class ValueObject{
    public static String value = "";
}
class P{
    private String lock;
    public P(String lock){
        this.lock = lock;
    }
    public void produce(){
        try {
            synchronized (lock){
                if (!("".equals(ValueObject.value))){
                    System.out.println("生产者"+Thread.currentThread().getName()+"正在等待！");
                    lock.wait();
                }
                System.out.println("生产者"+Thread.currentThread().getName()+"正在生产！");
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                ValueObject.value = value;
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class C{
    private String lock;
    public C(String lock){
        this.lock = lock;
    }
    public void consume(){
        try {
            synchronized (lock){
                if ("".equals(ValueObject.value)){
                    System.out.println("消费者"+Thread.currentThread().getName()+"正在等待！");
                    lock.wait();
                }

                System.out.println("消费者"+Thread.currentThread().getName()+"正在消费！");
                ValueObject.value = "";
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadP extends Thread{
    private P p;
    public ThreadP(P p){
        this.p = p;
    }

    @Override
    public void run() {
        while (true){
            p.produce();
        }
    }
}
class ThreadC extends Thread{
    private C c;
    public ThreadC(C c){
        this.c = c;
    }

    @Override
    public void run() {
        while (true){
            c.consume();
        }
    }
}
public class OneProduceOneConsume {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
