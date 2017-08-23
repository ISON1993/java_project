package socket.simpleChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class MyServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(30000);

        while (true){
            Socket s = server.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
