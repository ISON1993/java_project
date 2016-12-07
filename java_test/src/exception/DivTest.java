package exception;

/**
 * Created by tuzhenyu on 16-11-25.
 */
public class DivTest {
    public static void main(String[] args) {
        try{
            int a = Integer.parseInt(args[0]);
            System.out.println(a);
        }
        catch(IndexOutOfBoundsException ie){

        }
    }
}
