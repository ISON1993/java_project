package junit.Junit;

/**
 * Created by tuzhenyu on 17-2-24.
 */
public class MessageUnit {

    private String message;

    public MessageUnit(String message){
        this.message = message;
    }

    public String printMessage(){
        System.out.println(message);
        return message;
    }

    public void testTimeout(){
        System.out.println(message);
        while (true);
    }

    public void testException(){
        System.out.println(message);
        int a = 1;
        int b = 1/0;
    }
}
