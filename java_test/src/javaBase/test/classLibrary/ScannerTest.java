package javaBase.test.classLibrary;
import java.io.File;
import java.util.Scanner;
/**
 * Created by user on 2016/10/30.
 */
public class ScannerTest {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("D://temp/GcTest.java"));
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
