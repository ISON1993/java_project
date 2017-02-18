package thread.javaPython;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by tuzhenyu on 17-2-16.
 */
public class JavaPython{
    public static void main(String[] args) {
        System.out.println("in the main method");
        callPython();
    }

    private static void callPython(){
        System.out.println("in the callPython");
        String cmd ="python /home/tuzhenyu/tmp/python.py fuck";
        Process process = null;
        try{
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            System.out.println("get the result");
            process.waitFor();
            System.out.println("finish the execution");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                process.destroy();
                System.out.println("destroy the process");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
