package junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tuzhenyu on 17-2-24.
 * @author tuzhenyu
 */
class MessageUnit{
    private String message;
    public MessageUnit(String message){
        this.message = message;
    }
    public String printMessage(){
        System.out.println(message);
        return message;
    }
}
public class TestJunit {
    private String message = "hello world";
    private MessageUnit messageUnit = new MessageUnit(message);
    @Test
    public void testPrintMessage(){
        assertEquals("lalala",messageUnit.printMessage());
    }
}
