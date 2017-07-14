package databaseSync;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by tuzhenyu on 17-7-1.
 * @author tuzhenyu
 */
public class DataResolve {
    public static void main(String[] args) {
        try{
            File file = new File("/home/tuzhenyu/tmp/weichai/unitId2.txt");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                String[] units = line.split("\\t");
            }
        }catch (Exception e){
            System.out.println("execute the sql fail");
            e.printStackTrace();
        }
    }
}
