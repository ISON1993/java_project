package thread.produceConsume;

/**
 * Created by tuzhenyu on 17-10-16.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot(10);
        ProduceThread produceThread = new ProduceThread(depot);
        ProduceThread produceThread2 = new ProduceThread(depot);
        ConsumeThread consumeThread = new ConsumeThread(depot);
        ConsumeThread consumeThread2 = new ConsumeThread(depot);

        produceThread.start();
        produceThread2.start();
        consumeThread.start();
        consumeThread2.start();
    }
}
