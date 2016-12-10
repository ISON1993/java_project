package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by tuzhenyu on 16-12-10.
 */
public class PrintStreamTest {
    public static void main(String[] args) throws IOException{
        try(
            FileOutputStream fos = new FileOutputStream("/home/tuzhenyu/tmp/newFile.txt");
            PrintStream p = new PrintStream(fos)
        )
        {
            p.println("hello hello hello");
            p.println(new PrintStreamTest());
        }
    }
}
