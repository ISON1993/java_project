package downloader;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class DownloadUtil {
    public HttpURLConnection getConnection(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(5*1000);

        return conn;
    }
}
