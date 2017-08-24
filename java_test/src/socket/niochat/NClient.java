package socket.niochat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class NClient {
    private Charset charset = Charset.forName("UTF-8");
    private Selector selector;
    private SocketChannel sc;

    public void init() throws Exception{
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1",30000);
        sc = SocketChannel.open(isa);
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        new ClientThread().start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            sc.write(charset.encode(line));
        }
    }

    private class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                while (selector.select()>0){
                    for (SelectionKey sk : selector.selectedKeys()){
                        selector.selectedKeys().remove(sk);
                        if (sk.isReadable()){
                            SocketChannel sc = (SocketChannel)sk.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            String content = "";
                            while (sc.read(buffer)>0){
                                buffer.flip();
                                content+=charset.decode(buffer);
                            }
                            System.out.println("聊天信息:"+content);
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws Exception{
        new NClient().init();
    }
}


