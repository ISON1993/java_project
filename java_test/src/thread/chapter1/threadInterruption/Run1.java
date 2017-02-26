package thread.chapter1.threadInterruption;

/**
 * Created by tuzhenyu on 17-1-9.
 */
class MythreadInterrupt extends Thread{
    @Override
    public void run(){
        try{
            for(int i=5000; i>0; i--){
                System.out.println("i:"+i);
                if (i == 2500){
                    System.out.println("sleep-begin");
                    Thread.sleep(2000);
                    System.out.println("sleep-end");
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
public class Run1 {
    public static void main(String[] args) {
        try {
            MythreadInterrupt mythreadInterrupt = new MythreadInterrupt();
            mythreadInterrupt.start();
            mythreadInterrupt.interrupt();
            System.out.println("isInterrupted:"+mythreadInterrupt.isInterrupted());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
