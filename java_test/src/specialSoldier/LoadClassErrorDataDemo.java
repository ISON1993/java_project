package specialSoldier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-9-20.
 * @author tuzhenyu
 */
public class LoadClassErrorDataDemo {
    private final static LoadClassErrorDataDemo INIT_OBJECT = new LoadClassErrorDataDemo();

    private static List<String> LIST;

    static {
        LIST = new ArrayList<String>();
        LIST.add("1");
    }

    private LoadClassErrorDataDemo() {
        if(LIST == null) {
            LIST = new ArrayList<String>();
        }
        LIST.add("2");
        LIST.add("3");
    }

    public void displayCacheSize() {
        for(String str : LIST) {
            System.out.println(str);
        }
    }

    public static LoadClassErrorDataDemo getInstance() {
        return INIT_OBJECT;
    }

    public static void main(String []args) {
        LoadClassErrorDataDemo forInit = LoadClassErrorDataDemo.getInstance();
        forInit.displayCacheSize();
    }
}
