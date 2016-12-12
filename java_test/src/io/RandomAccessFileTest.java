package io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by tuzhenyu on 16-12-11.
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try(
                RandomAccessFile raf = new RandomAccessFile("/home/tuzhenyu/tmp/test.txt","rw"))
        {
            System.out.println("起始位置："+raf.getFilePointer());
            System.out.println(raf.length());
            raf.seek(raf.length());
            System.out.println("起始位置："+raf.getFilePointer());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
