package databaseTranfer;

/**
 * Created by tuzhenyu on 17-3-25.
 * @author tuzhenyu
 */
public class MyThread extends Thread{
    private SearchQueue searchQueue;
    public MyThread(SearchQueue searchQueue){
        this.searchQueue = searchQueue;
    }

    @Override
    public void run() {
        while (true){
            boolean flag = searchQueue.tranfer();
            if (!flag){
                System.out.println(Thread.currentThread().getName()+" is finished");
                break;
            }
        }
    }
}
