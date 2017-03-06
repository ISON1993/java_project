package socket.socketConnect;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-3-6.
 * @author tuzhenyu
 */
public class ServerSoclket {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(30000);
        while (true){
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("this is server,do you get it?");
            ps.close();
            s.close();
        }
    }
}
