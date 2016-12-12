package io.objectOutputStreamTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by tuzhenyu on 16-12-12.
 */
public class ReaderObject {
    public static void main(String[] args) throws Exception{
        try(
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/tuzhenyu/tmp/newFile.txt")))
        {
            Person p = (Person)ois.readObject();
            System.out.println("name:"+p.getName()+"age:"+p.getAge());
        }
    }
}
