package thread.javaShell;

/**
 * Created by tuzhenyu on 17-2-15.
 */
public class JavaShellTest {
    public static void main(String[] args) {
        System.out.println("in the main method");
        callShell();
    }

    private static void callShell(){
        System.out.println("in the callShell");
        String cmd ="sh /home/tuzhenyu/tmp/shell.sh";
        Process process = null;
        try{
            process = Runtime.getRuntime().exec(cmd);
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
