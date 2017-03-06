package socket.socketConnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by tuzhenyu on 17-3-6.
 * @author tuzhenyu
 */
public class ClientSocket {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1",30000);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = br.readLine();
        System.out.println(line);
        br.close();
        s.close();
    }
}
