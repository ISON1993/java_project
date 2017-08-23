package socket.simpleChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private BufferedReader bufferedReader;

    public ServerThread(Socket socket)throws IOException{
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run(){
        try{
            String content ;
            while ((content=readFromClient())!=null){
                for (Socket socket : MyServer.socketList){
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println(content);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private String readFromClient(){
        try {
            return bufferedReader.readLine();
        }catch (IOException e){
            MyServer.socketList.remove(socket);
        }

        return null;
    }
}
