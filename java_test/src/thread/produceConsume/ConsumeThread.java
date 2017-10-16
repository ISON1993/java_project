package thread.produceConsume;

/**
 * Created by tuzhenyu on 17-10-16.
 * @author tuzhenyu
 */
public class ConsumeThread extends Thread{
    private Depot depot;
    public ConsumeThread(Depot depot){
        this.depot = depot;
    }

    @Override
    public void run() {
        while (true){
            depot.consume();
            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
