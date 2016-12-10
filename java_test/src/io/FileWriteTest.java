package io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by tuzhenyu on 16-12-10.
 */
public class FileWriteTest {
    public static void main(String[] args) throws IOException {
        try (
                FileWriter fw = new FileWriter("/home/tuzhenyu/tmp/newFile.txt"))
        {
            fw.write("hello hello hello");
        }
    }
}
