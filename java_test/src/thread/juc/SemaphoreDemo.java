package thread.juc;

import java.util.concurrent.Semaphore;

/**
 * Created by tuzhenyu on 17-10-23.
 * @author tuzhenyu
 */
class ThreadA extends Thread{
    private Semaphore semaphoreA;
    private Semaphore semaphoreB;

    public ThreadA(String name,Semaphore semaphoreA,Semaphore semaphoreB){
        super(name);
        this.semaphoreA = semaphoreA;
        this.semaphoreB = semaphoreB;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                semaphoreA.acquire();
                System.out.println(Thread.currentThread().getName());
                semaphoreB.release();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class ThreadB extends Thread{
    private Semaphore semaphoreB;
    private Semaphore semaphoreC;

    public ThreadB(String name,Semaphore semaphoreB,Semaphore semaphoreC){
        super(name);
        this.semaphoreB = semaphoreB;
        this.semaphoreC = semaphoreC;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName());
                semaphoreC.release();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

class ThreadC extends Thread{
    private Semaphore semaphoreC;
    private Semaphore semaphoreA;

    public ThreadC(String name,Semaphore semaphoreC,Semaphore semaphoreA){
        super(name);
        this.semaphoreC = semaphoreC;
        this.semaphoreA = semaphoreA;
    }

    @Override
    public void run() {
        try {
            for (int i=0;i<10;i++){
                semaphoreC.acquire();
                System.out.println(Thread.currentThread().getName());
                semaphoreA.release();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        ThreadA threadA = new ThreadA("A",semaphoreA,semaphoreB);
        ThreadB threadB = new ThreadB("B",semaphoreB,semaphoreC);
        ThreadC threadC = new ThreadC("C",semaphoreC,semaphoreA);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
