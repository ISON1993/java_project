package thread.chapter3;

import java.io.Serializable;

/**
 * Created by tuzhenyu on 17-2-26.
 * @author tuzhenyu
 */
class Service{
    volatile private boolean preIsA = false;
    synchronized public void backupA(){
        try{
            while (preIsA == true){
                System.out.println("A"+Thread.currentThread().getName()+":wait");
                wait();
            }
            System.out.println("+++++++++++++");
            System.out.println("A"+Thread.currentThread().getName()+":run");
            preIsA = true;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try{
            while (preIsA == false){
                System.out.println("B"+Thread.currentThread().getName()+":wait");
                wait();
            }
            System.out.println("---------------");
            System.out.println("B"+Thread.currentThread().getName()+":run");
            preIsA = false;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.backupA();
        }
    }
}
class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.backupB();
        }

    }
}
public class CrossOperate {
    public static void main(String[] args) {
        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}
