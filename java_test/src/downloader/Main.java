package downloader;

import java.net.HttpURLConnection;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        DownloadUtil downloadUtil = new DownloadUtil();
        long start = System.currentTimeMillis();
        downloadUtil.startDownload("https://www.baidu.com/img/baidu_sylogo1.gif","/home/tuzhenyu/tmp/test2.gif",2);
        System.out.println(System.currentTimeMillis()-start);
    }
}
