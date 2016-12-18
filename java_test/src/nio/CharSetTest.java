package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by tuzhenyu on 16-12-15.
 * tuzhenyu
 */
public class CharSetTest {
    public static void main(String[] args) throws Exception{
        CharBuffer buffer = CharBuffer.allocate(1024);
        Charset cs = Charset.forName("GBK");
        CharsetEncoder ce = cs.newEncoder();
        CharsetDecoder cd = cs.newDecoder();

        buffer.put('孙');
        buffer.put('悟');
        buffer.put('空');

        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }

        buffer.flip();
        ByteBuffer buffer2 = ce.encode(buffer);
        while(buffer2.hasRemaining()){
            System.out.println(buffer2.get());
        }

        buffer2.flip();
        buffer = cd.decode(buffer2);
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
