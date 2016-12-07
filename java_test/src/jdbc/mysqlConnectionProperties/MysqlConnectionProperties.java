package jdbc.mysqlConnectionProperties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by tuzhenyu on 16-12-7.
 */
public class MysqlConnectionProperties {
    public static void main(String[] args) {
        Connection conn = null;
        Properties prop = new Properties();
        try{
            FileInputStream in = new FileInputStream("src/jdbc/connectionPool/prop.properties");
            prop.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            String driver = prop.getProperty("jdbc.driver");
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }

        String url = prop.getProperty("jdbc.url");
        String user= prop.getProperty("jdbc.user");
        String password = prop.getProperty("jdbc.password");

        try{
            conn = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
