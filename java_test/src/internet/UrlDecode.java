package internet;

import sun.nio.cs.ext.GBK;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by tuzhenyu on 17-3-3.
 * @author tuzhenyu
 */
public class UrlDecode {
    public static void main(String[] args) throws Exception{
        String str = URLEncoder.encode("你好","utf-8");
        System.out.println(str);
        String str2 = URLDecoder.decode(str,"utf-8");
        System.out.println(str2);

        String str3 = URLEncoder.encode("你好","gbk");
        System.out.println(str3);
        String str4 = URLDecoder.decode(str,"utf-8");
        System.out.println(str4);

    }
}
