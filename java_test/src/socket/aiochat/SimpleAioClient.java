package socket.aiochat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class SimpleAioClient {
    public static void main(String[] args) throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Charset charset = Charset.forName("UTF-8");
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",30000)).get();
        buffer.clear();
        socketChannel.read(buffer).get();
        buffer.flip();
        String content = charset.decode(buffer).toString();
        System.out.println("服务器消息："+content);
    }
}
