package internet.proxy;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuzhenyu on 17-3-7.
 * @author tuzhenyu
 */
public class ProxySelectorTest {
    public static void main(String[] args) throws IOException{
        final String PROXY_ADDR = "119.29.126.115";
        final int PROXY_PORT = 80;

        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                List<Proxy> list = new ArrayList<>();
                list.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
                        PROXY_ADDR, PROXY_PORT)));
                return list;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("连接代理失败！");
            }
        });

//        URL url = new URL("https://www.google.com.hk/?gws_rd=ssl");
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(6000); // 6s
        conn.setReadTimeout(6000);
        conn.setUseCaches(false);

        if(conn.getResponseCode() == 200){
            System.out.println("使用代理IP连接网络成功");
        }
    }
}
