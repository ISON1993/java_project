package socket.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public class MyClient {
    private BufferedReader keyIn;
    private PrintStream ps;
    private BufferedReader brServer;

    public void init() throws Exception{
        keyIn = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = new Socket("127.0.0.1",30000);
        ps = new PrintStream(socket.getOutputStream());
        brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true){
            System.out.println("请输入用户名：");
            String username = keyIn.readLine();
            ps.println(CrazyitProtocol.USER_ROUND+username+CrazyitProtocol.USER_ROUND);
            String result = brServer.readLine();
            if (result.equals(CrazyitProtocol.NAME_REP)){
                System.out.println("用户名重复，请重新输入！");
                continue;
            }

            if (result.equals(CrazyitProtocol.LOGIN_SUCCESS)){
                System.out.println("登录成功！");
                break;
            }

        }

        new Thread(new ClientThread(brServer)).start();
    }

    public void readAndSend()throws Exception{
        String line;
        while ((line=keyIn.readLine())!=null){
            if (line.indexOf(":")>0&&line.startsWith("//")){
                line = line.substring(CrazyitProtocol.PROTOCOL_LEN);
                ps.println(CrazyitProtocol.PRIVATE_ROUND+line.split(":")[0]+CrazyitProtocol.SPLITE_SIGN
                        +line.split(":")[1]+CrazyitProtocol.PRIVATE_ROUND
                );
            }else {
                ps.println(CrazyitProtocol.MSG_ROUND+line+CrazyitProtocol.MSG_ROUND);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        MyClient client = new MyClient();
        client.init();
        client.readAndSend();
    }
}
