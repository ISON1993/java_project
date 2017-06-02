package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * Created by tuzhenyu on 17-6-2.
 * @author tuzhenyu
 */
public class Server {
    private int port;

    public Server(int port)
    {
        super();
        this.port = port;
    }
    private void bind() throws InterruptedException
    {
        EventLoopGroup bossGruop=new NioEventLoopGroup();//用于服务器端接受客户端的连接
        EventLoopGroup workGroup=new NioEventLoopGroup();//用于网络事件的处理
        try
        {
            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGruop, workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>()
            {
                @Override
                protected void initChannel(io.netty.channel.socket.SocketChannel arg0) throws Exception
                {
                    arg0.pipeline().addLast(new ServerHandler());

                }
            }).option(ChannelOption.SO_BACKLOG, 1024);//指定此套接口排队的最大连接个数
            ChannelFuture f=b.bind(port).sync();
            f.channel().closeFuture().sync();
        }
        finally
        {
            bossGruop.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws InterruptedException
    {
        new Server(8080).bind();
    }
}
