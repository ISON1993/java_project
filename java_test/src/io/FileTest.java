package io;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by tuzhenyu on 16-12-9.
 */
public class FileTest {
    public static void main(String[] args) throws IOException{
        System.out.println("/*******************file********************/");
        File f = new File("/home/tuzhenyu/tmp/test.txt");
        if(!f.exists()){
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(f.exists());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getAbsolutePath());

        System.out.println("/*******************file2********************/");
        File f2 = new File("/home/tuzhenyu/tmp/test");
        f2.mkdir();
        System.out.println(f2.exists());
        System.out.println(f2.isDirectory());

        System.out.println("/*******************file3********************/");
        File f3 = new File("/home/tuzhenyu/tmp");
        System.out.println(f3.exists());
        System.out.println(Arrays.toString(f3.list()));
        System.out.println(Arrays.toString(f3.listFiles()));


    }
}
