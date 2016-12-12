package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tuzhenyu on 16-12-11.
 */
public class InputReaderTest {
    public static void main(String[] args) {
        try(
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr))
        {
            String line = null;
            while((line = br.readLine()) != null){
                if(line.equals("exit")){
                    System.exit(1);
                }
                System.out.print("输入："+line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
