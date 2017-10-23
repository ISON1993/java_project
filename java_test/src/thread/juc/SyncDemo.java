package thread.juc;

import java.util.EventListener;

/**
 * Created by tuzhenyu on 17-10-23.
 * @author tuzhenyu
 */
class AlternatePrint{
    private volatile int count = 0;

    public synchronized void alternatePrint(){
        while (count<30){
            if (count%3==0) {
                System.out.print("A ");
                count++;
            }
            else if (count%3==1) {
                System.out.print("B ");
                count++;
            }
            else {
                System.out.print("C ");
                count++;
            }
        }
    }
}
class Thread2 extends Thread{
    private AlternatePrint alternatePrint;
    public Thread2(AlternatePrint alternatePrint){
        this.alternatePrint = alternatePrint;
    }

    @Override
    public void run() {
        alternatePrint.alternatePrint();
    }
}
public class SyncDemo {

    public static void main(String[] args) {
        AlternatePrint alternatePrint = new AlternatePrint();
        Thread2 t1 = new Thread2(alternatePrint);
        Thread2 t2 = new Thread2(alternatePrint);
        Thread2 t3 = new Thread2(alternatePrint);

        t1.start();
        t2.start();
        t3.start();
    }
}
