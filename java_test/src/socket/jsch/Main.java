package socket.jsch;

/**
 * Created by tuzhenyu on 17-3-16.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        JschCommand jschCommand = new JschCommand();
        System.out.println(jschCommand.executeCommand("date"));
        System.out.println(jschCommand.executeCommand("sh /home/master/tmp/test.sh"));
        System.out.println(jschCommand.executeCommand("sh /home/master/tmp/test.sh"));
    }
}
