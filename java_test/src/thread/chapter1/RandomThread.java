package thread.chapter1;

/**
 * Created by tuzhenyu on 16-12-25.
 * tuzhenyu
 */
public class RandomThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(1);
        MyThread t2 = new MyThread(2);
        MyThread t3 = new MyThread(3);
        MyThread t4 = new MyThread(4);
        MyThread t5 = new MyThread(5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class MyThread extends Thread{
    private int i;
    public MyThread(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
