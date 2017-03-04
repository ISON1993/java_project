package internet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-4.
 * @author tuzhenyu
 */
public class Downloader {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        download();
        System.out.println(System.currentTimeMillis()-start);
    }

    private static void download(){
        URL url = null;
        HttpURLConnection conn = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file = new File("/home/tuzhenyu/tmp/test.gif");
        try{
            url = new URL("https://www.baidu.com/img/baidu_sylogo1.gif");
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            bis = new BufferedInputStream(conn.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(file));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
            {
                bos.write(b, 0, len);
            }
            System.out.println("上传成功");
            bos.flush();
            bis.close();
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                bis.close();
                bos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
