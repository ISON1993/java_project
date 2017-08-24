package socket.niochat;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class NServer {
    private Selector selector = null;
    private Charset charset = Charset.forName("UTF-8");

    public void init() throws Exception{
        selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1",30000);
        server.bind(isa);
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select()>0){
            for (SelectionKey sk : selector.selectedKeys()){
                selector.selectedKeys().remove(sk);
                if (sk.isAcceptable()){
                    SocketChannel sc = server.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                }

                if (sk.isReadable()){
                    SocketChannel sc = (SocketChannel)sk.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    String content = "";
                    while (sc.read(buffer)>0){
                        buffer.flip();
                        content+=charset.decode(buffer);
                    }
                    System.out.println("读取数据为:"+content);
                    sk.interestOps(SelectionKey.OP_READ);

                    if (content.length()>0){
                        for (SelectionKey key : selector.selectedKeys()){
                            Channel targetChannel = key.channel();
                            if (targetChannel instanceof SocketChannel){
                                SocketChannel dest = (SocketChannel)targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new NServer().init();
    }
}
