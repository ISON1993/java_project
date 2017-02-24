package junit.JunitEnvironmentTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by tuzhenyu on 17-2-24.
 * @author tuzhenyu
 */
public class JunitTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTest.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
