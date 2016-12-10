package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by tuzhenyu on 16-12-10.
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException{
        try(
                FileReader fr = new FileReader("/home/tuzhenyu/tmp/2.java"))
        {
//            System.out.println((char) fr.read());
            char[] buf = new char[1024];
            System.out.println("=============");
            int hasRead = fr.read(buf);
            System.out.println(hasRead);
            System.out.println("=============");
            System.out.println(new String(buf,0,hasRead));
        }
    }
}
