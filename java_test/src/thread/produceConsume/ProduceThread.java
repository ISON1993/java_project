package thread.produceConsume;

/**
 * Created by tuzhenyu on 17-10-16.
 * @author tuzhenyu
 */
public class ProduceThread extends Thread{
    private Depot depot;
    public ProduceThread(Depot depot){
        this.depot = depot;
    }

    @Override
    public void run() {
        while (true){
            depot.produce();
            try {
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
