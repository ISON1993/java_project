package socket.aiochat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class AIOServer {
    public static List<AsynchronousSocketChannel> channelList = new ArrayList<>();

    private void startListen() throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(channelGroup)
                .bind(new InetSocketAddress(30000));
        serverChannel.accept(null,new AcceptHandle(serverChannel));
    }

    public static void main(String[] args) throws Exception{
        AIOServer server = new AIOServer();
        server.startListen();
        while (true){}
    }
}

class AcceptHandle implements CompletionHandler<AsynchronousSocketChannel,Object>{

    private AsynchronousServerSocketChannel serverSocketChannel;
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    public AcceptHandle(AsynchronousServerSocketChannel serverSocketChannel){
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel sc, Object attachment) {
        AIOServer.channelList.add(sc);
        serverSocketChannel.accept(null,this);
        sc.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buffer.flip();
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                for (AsynchronousSocketChannel c : AIOServer.channelList){
                    try {
                        c.write(ByteBuffer.wrap(content.getBytes("UTF-8"))).get();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                buffer.clear();
                sc.read(buffer,null,this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败！");
                AIOServer.channelList.remove(sc);
            }
        });
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败！");
    }
}
