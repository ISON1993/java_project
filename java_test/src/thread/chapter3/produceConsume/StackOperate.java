package thread.chapter3.produceConsume;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-2-26.
 * @author tuzhenyu
 */
class MyStack{
    private List list = new ArrayList();
    synchronized public void push(){
        try{
            if (list.size() == 1){
                this.wait();
            }
            list.add("something="+Math.random());
            this.notifyAll();
            System.out.println("push="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void pop(){
        String value = "";
        try{
            if (list.size() == 0){
                this.wait();
            }
            value = ""+list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class PushService{
    private MyStack myStack;
    public PushService(MyStack myStack){
        this.myStack = myStack;
    }
    public void doPush(){
        myStack.push();
    }
}
class PopService{
    private MyStack myStack;
    public PopService(MyStack myStack){
        this.myStack = myStack;
    }
    public void doPop(){
        myStack.pop();
    }
}
class PushThread extends Thread{
    private PushService pushService;
    public PushThread(PushService pushService){
        this.pushService = pushService;
    }

    @Override
    public void run() {
        while (true){
            pushService.doPush();
        }
    }
}
class PopThread extends Thread{
    private PopService popService;
    public PopThread(PopService popService){
        this.popService = popService;
    }

    @Override
    public void run() {
        while (true){
            popService.doPop();
        }
    }
}
public class StackOperate {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        PushService pushService = new PushService(myStack);
        PushThread pushThread = new PushThread(pushService);
        PopService popService = new PopService(myStack);
        PopThread popThread = new PopThread(popService);
        pushThread.start();
        popThread.start();

    }
}
