package io.transientTest;

import java.io.*;

/**
 * Created by tuzhenyu on 16-12-12.
 */
public class TransientTest {
    public static void main(String[] args) throws Exception{
        try(
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/tuzhenyu/tmp/newFile.txt"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/tuzhenyu/tmp/newFile.txt")))
        {
            Student s = new Student("jack",20);
            oos.writeObject(s);
            Student stu = (Student)ois.readObject();
            System.out.println("name:"+stu.getName()+" age: "+stu.getAge());
        }
    }
}
