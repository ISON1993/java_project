package socket.aiochat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class AIOClient {
    private AsynchronousSocketChannel clientChannel;
    private void connect() throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        ExecutorService executorService = Executors.newFixedThreadPool(80);
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        clientChannel = AsynchronousSocketChannel.open(channelGroup);
        clientChannel.connect(new InetSocketAddress("127.0.0.1",30000)).get();
        System.out.println("连接成功！");

        clientChannel.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buffer.flip();
                String content = StandardCharsets.UTF_8.decode(buffer).toString();
                System.out.println("某人说："+content);
                buffer.clear();
                clientChannel.read(buffer,null,this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败！");
            }
        });

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            clientChannel.write(ByteBuffer.wrap(line.getBytes("UTF-8"))).get();
        }
    }

    public static void main(String[] args) throws Exception{
        AIOClient client = new AIOClient();
        client.connect();
    }
}
