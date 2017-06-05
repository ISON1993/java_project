package databaseSync;

import java.sql.*;
import java.util.Random;

/**
 * Created by tuzhenyu on 17-6-3.
 * @author tuzhenyu
 */
public class DatabaseSync {
    public static void main(String[] args) {
        Random random = new Random();
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("loading Mysql Driver successfully!");
        }catch (Exception e){
            System.out.println("load the driver file");
        }

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","tuzhenyu");
            System.out.println("connect mysql successfully");
        }catch (Exception e){
            System.out.println("connect mysql fail");
        }
        try{
            int i = 1;
            Statement statement = conn.createStatement();
            while (i<=100){
                String insertSql = "insert into user values("+i+",'user_"+i+"','123123','"+random.nextInt(100)+"')";
                String updateSql = "update user set password = '121212' where id = "+i+";";
                String deleteSql = "delete from user where id = "+i+";";

                statement.execute(insertSql);
                statement.execute(updateSql);
                statement.execute(deleteSql);


                i++;
            }

        }catch (Exception e){
            System.out.println("execute the sql fail");
            e.printStackTrace();
        }
    }
}
