package socket.chat;

import databaseTranfer.MyThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class MyClient {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",30000);
        new Thread(new ClientThread(socket)).start();
        PrintStream ps = new PrintStream(socket.getOutputStream());
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line=br.readLine())!=null){
            ps.println(line);
        }
    }
}
