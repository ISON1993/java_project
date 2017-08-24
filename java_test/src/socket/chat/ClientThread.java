package socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class ClientThread implements Runnable{
    private BufferedReader bufferedReader;

    public ClientThread(BufferedReader bufferedReader) throws IOException{
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {
        try{
            String content;
            while ((content=bufferedReader.readLine())!=null){
                System.out.println(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
