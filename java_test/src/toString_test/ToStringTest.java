package toString_test;

/**
 * Created by user on 2016/10/25.
 */
public class ToStringTest {
    private String val1;
    private String val2;
    private String val3;
    private FlagClass flagClass = new FlagClass();

    public String toString(){
        return
                "val1:"+val1+ "val2:"+val2+ "val3:"+val3+"FlagClass"+flagClass;
    }

    public static void main(String[] args) {
        ToStringTest toStringTest = new ToStringTest();
        System.out.println(toStringTest.toString());
//        System.out.println(toStringTest);
    }
}

