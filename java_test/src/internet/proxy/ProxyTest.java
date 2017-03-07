package internet.proxy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-7.
 * @author tuzhenyu
 */
public class ProxyTest {
    public static void main(String[] args) throws IOException{
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("60.169.78.218", 808));

        HttpURLConnection connection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection(proxy);
        connection.setConnectTimeout(6000); // 6s
        connection.setReadTimeout(6000);
        connection.setUseCaches(false);

        if(connection.getResponseCode() == 200){
            System.out.println("使用代理IP连接网络成功");
        }
    }
}
