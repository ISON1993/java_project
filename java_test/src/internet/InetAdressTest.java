package internet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by user on 2016/11/7.
 * @author tuzhenyu
 */
public class InetAdressTest {
    public static void main (String[] args) throws UnknownHostException{

        InetAddress adress = InetAddress.getLocalHost();
        System.out.println("host adress name:"+adress.getHostName());
        System.out.println("IP adress:"+ adress.getHostAddress());
        byte[] bytes = adress.getAddress();
        System.out.println(Arrays.toString(bytes));
        System.out.println(adress);
    }
}
