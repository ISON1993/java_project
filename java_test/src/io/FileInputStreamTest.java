package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by tuzhenyu on 16-12-10.
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException{
        try(
                FileInputStream fis = new FileInputStream("/home/tuzhenyu/tmp/canal_data/canal.txt"))
        {
//            System.out.println(fis.read());
            byte[] buf = new byte[130];
            int hasRead = 0;
            hasRead = fis.read(buf);
            System.out.println("++++++++++++++");
            System.out.println(hasRead);
            System.out.println("++++++++++++++");
            System.out.println(new String(buf,0,hasRead));
            System.out.println("++++++++++++++");
            System.out.println(Arrays.toString(buf));

//            System.out.println("++++++++++++++");
//            System.out.println(Arrays.toString(buf));
//            while((hasRead = fis.read(buf))>0){
//                System.out.print(new String(buf,0,hasRead));
//            }

        }
    }
}
