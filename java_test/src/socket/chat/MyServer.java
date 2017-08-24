package socket.chat;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class MyServer {
    public static CrazyitMap<String,PrintStream> clients = new CrazyitMap<>();
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(30000);

        while (true){
            Socket s = server.accept();
            new Thread(new ServerThread(s)).start();
        }
    }
}
