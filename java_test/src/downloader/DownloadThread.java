package downloader;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class DownloadThread extends Thread{
    private String url;
    private int startPos;
    private int partSize;
    private RandomAccessFile outPartFile;
    private int length = 0;

    public DownloadThread(String url,int startPos,int partSize,RandomAccessFile outPartFile){
        this.url = url;
        this.startPos = startPos;
        this.partSize = partSize;
        this.outPartFile = outPartFile;
    }

    @Override
    public void run() {
        try {
            HttpURLConnection conn = DownloadUtil.getConnection(url);
            InputStream inStream = conn.getInputStream();
            inStream.skip(this.startPos);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while (length < partSize && (hasRead = inStream.read(buffer))!=-1){
                outPartFile.write(buffer,0,hasRead);
                length = length + hasRead;
            }
            outPartFile.close();
            inStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
