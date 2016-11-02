package classLibrary;

import java.util.Map;

/**
 * Created by user on 2016/10/30.
 */
public class SystemTest {
    public static void main(String[] args) {
        Map<String,String> env = System.getenv();
        for(String name : env.keySet()){
            System.out.println(name + "--->" + env.get(name));
        }
    }
}
