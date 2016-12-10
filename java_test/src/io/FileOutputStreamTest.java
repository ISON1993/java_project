package io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by tuzhenyu on 16-12-10.
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException{
        try(
            FileOutputStream fos = new FileOutputStream("/home/tuzhenyu/tmp/newFile.txt")) {
            byte[] buf = new byte[]{104, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33, 10, 80, 114, 101, 116, 116, 121, 32, 109, 117, 99, 104, 32, 49};
            fos.write(buf);
            System.out.println("++++++++++++++++++++++");
            fos.write('r');
            fos.write(65);
        }
    }
}
