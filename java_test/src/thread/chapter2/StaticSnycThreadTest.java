package thread.chapter2;

/**
 * Created by tuzhenyu on 17-2-25.
 */
class StaticService{
    synchronized public void printA(){
        try{
            System.out.println(Thread.currentThread().getName()+"come in");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"come out");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void printB(){
        System.out.println(Thread.currentThread().getName()+"come in");
        System.out.println(Thread.currentThread().getName()+"come out");
    }
}
class Thread3 extends Thread{
    private StaticService staticService;
    public Thread3(StaticService staticService){
        this.staticService = staticService;
    }

    @Override
    public void run() {
        super.run();
        staticService.printA();
    }
}
class Thread4 extends Thread{
    private StaticService staticService;
    public Thread4(StaticService staticService){
        this.staticService = staticService;
    }

    @Override
    public void run() {
        super.run();
        staticService.printB();
    }
}
public class StaticSnycThreadTest {
    public static void main(String[] args) {
        StaticService staticService = new StaticService();
        Thread3 thread3 = new Thread3(staticService);
        thread3.start();
        Thread4 thread4 = new Thread4(staticService);
        thread4.start();
    }

}
