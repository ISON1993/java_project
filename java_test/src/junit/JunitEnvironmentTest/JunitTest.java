package junit.JunitEnvironmentTest;

/**
 * Created by tuzhenyu on 17-2-24.
 * @author tuzhenyu
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JunitTest {
    @Test
    public void test(){
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}
