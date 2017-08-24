package socket.chat;

import com.mchange.v1.io.OutputStreamUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintStream ps;

    public ServerThread(Socket socket)throws IOException{
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());

            ps.println("开始聊天");

            String line ;
            while ((line=bufferedReader.readLine())!=null){
                if (line.startsWith(CrazyitProtocol.USER_ROUND)&&
                        line.endsWith(CrazyitProtocol.USER_ROUND)){
                    String username = getRealMsg(line);
                    if (MyServer.clients.map.containsKey(username)){
                        System.out.println("用户名重复！");
                        ps.println(CrazyitProtocol.NAME_REP);
                    }else {
                        System.out.println("登录成功！");
                        ps.println(CrazyitProtocol.LOGIN_SUCCESS);
                        MyServer.clients.put(username,ps);
                    }
                }else if(line.startsWith(CrazyitProtocol.PRIVATE_ROUND)&&
                        line.endsWith(CrazyitProtocol.PRIVATE_ROUND)){
                    String content = getRealMsg(line);
                    String username = content.split(CrazyitProtocol.SPLITE_SIGN)[0];
                    String msg = content.split(CrazyitProtocol.SPLITE_SIGN)[1];
                    MyServer.clients.map.get(username).println(MyServer.clients.getKeyByValue(ps)
                            +"悄悄地对你说："+msg);
                }else {
                    String msg = getRealMsg(line);
                    for (PrintStream clientPs : MyServer.clients.valueSet()){
                        clientPs.println(MyServer.clients.getKeyByValue(ps)+"说："+msg);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private String getRealMsg(String line){
        return line.substring(CrazyitProtocol.PROTOCOL_LEN,
                line.length()-CrazyitProtocol.PROTOCOL_LEN);
    }

}
