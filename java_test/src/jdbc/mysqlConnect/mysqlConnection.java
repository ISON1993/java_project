package jdbc.mysqlConnect;

import java.sql.*;

/**
 * Created by tuzhenyu on 16-12-6.
 */
public class mysqlConnection {
    public static void main(String[] args) {
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
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user;");
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()){

                for(int i =0; i < rsmd.getColumnCount(); i++)
		    	 {
		    		 System.out.print(rs.getString(i+1) + "\t");
		    	 }
		    	 System.out.print("\n");
            }

        }catch (Exception e){
            System.out.println("execute the sql fail");
            e.printStackTrace();
        }
    }
}
