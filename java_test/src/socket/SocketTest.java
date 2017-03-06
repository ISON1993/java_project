package socket;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-3-6.
 * @author tuzhenyu
 */
public class SocketTest {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(30000);

        while (true){
            Socket s = ss.accept();
            System.out.println("get it");
            System.out.println(s);
        }
    }
}
