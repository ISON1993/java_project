package javaBase.test.regexTest;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2016/10/31.
 */
public class RegexTest {
    public static void main(String[] args) {
        String[] mails = {"kongyeeyu@163.com","tuzhenyu@gmail.com","wawawayu@abc.xx","liangliamgyu.org"};
        String reg = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = null;

        for(String mail : mails){
            if(matcher == null){
                matcher = pattern.matcher(mail);
            }
            else{
                matcher.reset(mail);
            }
            System.out.println(mail + (matcher.matches()?" is ":" is not ")+"a vaild mail adress");
        }

        for(String mail : mails){
            System.out.println(Arrays.toString(mail.split("yu\\w*")));
        }
    }
}
