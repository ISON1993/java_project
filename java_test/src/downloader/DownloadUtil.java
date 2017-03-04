package downloader;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class DownloadUtil {

    public static HttpURLConnection getConnection(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5*1000);
        return conn;
    }

    public void startDownload(String url,String filePath,int threadNum){
        try {
            HttpURLConnection conn = getConnection(url);
            int fileSize = conn.getContentLength();
            conn.disconnect();
            RandomAccessFile outFile = new RandomAccessFile(filePath,"rw");
            outFile.setLength(fileSize);
            outFile.close();
            int partSize = fileSize/threadNum + 1;

            for (int i=0;i<threadNum;i++){
                int startPos = i* partSize;
                RandomAccessFile outPartFile = new RandomAccessFile(filePath,"rw");
                outPartFile.seek(startPos);
                Thread thread = new DownloadThread(url,startPos,partSize,outPartFile);
                thread.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
