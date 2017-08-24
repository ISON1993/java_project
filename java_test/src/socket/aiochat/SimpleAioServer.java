package socket.aiochat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class SimpleAioServer {
    public static void main(String[] args) throws Exception{
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(30000));
        while (true){
            Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
            AsynchronousSocketChannel socketChannel = future.get();
            socketChannel.write(ByteBuffer.wrap("哈哈哈".getBytes("UTF-8"))).get();
        }
    }
}
