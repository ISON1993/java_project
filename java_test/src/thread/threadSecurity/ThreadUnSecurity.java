package thread.threadSecurity;

/**
 * Created by tuzhenyu on 16-12-26.
 */
public class ThreadUnSecurity {
    public static void main(String[] args) {
        MyThreadUnSecurity thread1 = new MyThreadUnSecurity("1");
        MyThreadUnSecurity thread2 = new MyThreadUnSecurity("2");
        MyThreadUnSecurity thread3 = new MyThreadUnSecurity("3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThreadUnSecurity extends Thread{
    private int count = 5;
    public MyThreadUnSecurity(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while(count > 0){
            count--;
            System.out.println("由"+this.currentThread().getName()+":"+count);
        }
    }
}
