package internet;

import java.net.InetAddress;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class RemoteNetAdress {
    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getByName("119.29.65.221");
        System.out.println("is reached?"+address.isReachable(2000));
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
