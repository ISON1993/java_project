package netty;

/**
 * Created by tuzhenyu on 17-6-2.
 * @author tuzhenyu
 */
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
public class ClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf message;

    public ClientHandler()
    {
        byte[] req="hello Netty".getBytes();
        message=Unpooled.buffer(req.length);
        message.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        ctx.writeAndFlush(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
    {
        ctx.close();
    }
}
