package nio;

import java.nio.CharBuffer;

/**
 * Created by tuzhenyu on 16-12-15.
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buff  = CharBuffer.allocate(8);
        System.out.println("capacity:"+buff.capacity());
        System.out.println("limit:"+buff.limit());
        System.out.println("position:"+buff.position());

        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("position after put:"+buff.position());

        buff.flip();
        System.out.println("limit after flip:"+buff.limit());
        System.out.println("position after flip:"+buff.position());

        System.out.println(buff.get());
        System.out.println("position after get:"+buff.position());

        buff.clear();
        System.out.println("limit after clear:"+buff.limit());
        System.out.println("position after clear:"+buff.position());

        System.out.println(buff.get());
        System.out.println(buff.get());
        System.out.println("position after get:"+buff.position());


    }
}
