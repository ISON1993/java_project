package io.objectOutputStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tuzhenyu on 16-12-12.
 */
public class WriteObject {
    public static void main(String[] args) throws IOException{
        try(
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/tuzhenyu/tmp/newFile.txt")))
        {
            Person p = new Person("jack",20);
            oos.writeObject(p);
//            oos.write(100);
        }
    }
}
