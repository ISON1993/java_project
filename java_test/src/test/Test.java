package test;

/**
 * Created by tuzhenyu on 17-10-12.
 * @author tuzhenyu
 */
public class Test {
   public static void main(String[] args) throws Exception{
      Thread[] threads = new Thread[5];
      for (int i=0;i<5;i++){
         threads[i] = new Thread(new Runnable() {
            @Override
            public void run() {
               System.out.println(Thread.currentThread().getId()+" is run");
            }
         });
      }
      for (int i=0;i<5;i++){
         threads[i].start();
      }
      for (int i=0;i<5;i++){
         threads[i].join();
      }
      System.out.println("finish");
   }
}
