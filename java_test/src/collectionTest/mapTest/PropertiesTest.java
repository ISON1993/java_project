package collectionTest.mapTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by user on 2016/11/10.
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        Properties property = new Properties();
        property.setProperty("username","tuzhenyu");
        property.setProperty("password", "123123");
        property.setProperty("gender", "male");
        property.store(new FileOutputStream("D://a.ini"),"comment line");
        Properties property2 = new Properties();
        property2.load(new FileInputStream("D://config.ini"));
        System.out.println(property2);
    }
}
