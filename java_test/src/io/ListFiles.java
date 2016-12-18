package io;

import java.io.File;

/**
 * Created by tuzhenyu on 16-12-18.
 */
public class ListFiles {
    public static void main(String[] args) {
        File file = new File("/home/tuzhenyu/tmp");
        printFiles(file);
    }

    public static void printFiles(File f){
        File[] files = f.listFiles();
        for(File file : files) {
            if (file.isDirectory()) {
                printFiles(file);
            } else {
                System.out.println(file.getPath());
            }
        }
    }
}
