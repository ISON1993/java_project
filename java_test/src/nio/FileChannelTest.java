package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tuzhenyu on 16-12-15.
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception{
        File f = new File("/home/tuzhenyu/tmp/newFile.txt");
        try(
                FileChannel fc = new FileInputStream(f).getChannel())
        {
//            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            fc.read(buffer);
//            buffer.flip();
//            System.out.println(buffer.get());
//            buffer.clear();

            ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY,0,f.length());
            while(buffer.hasRemaining()){
                System.out.println(buffer.get());
            }
        }
    }
}
