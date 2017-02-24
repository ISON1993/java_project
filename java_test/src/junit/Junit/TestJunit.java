package junit.Junit;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

/**
 * Created by tuzhenyu on 17-2-24.
 * @author tuzhenyu
 */

public class TestJunit{
    private String message = "hello world";
    private MessageUnit messageUnit = new MessageUnit(message);
    @Test(timeout = 100)
    public void testPrintMessage1(){
        System.out.println("in the test1");
        assertEquals("hello world",messageUnit.printMessage());
        messageUnit.testTimeout();
    }
    @Test
    public void testPrintMessage2(){
        System.out.println("in the test2");
        assertEquals("hello world",messageUnit.printMessage());
    }
    @Test(expected = ArithmeticException.class)
    public void testPrinMessage3(){
        System.out.println("in the test3");
        messageUnit.testException();
    }
}

