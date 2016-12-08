package jdbc.c3p0Test;

import java.sql.*;

/**
 * Created by tuzhenyu on 16-12-7.
 */
public class C3p0Test {
    public static void main (String[] args) throws SQLException{
        System.out.println("*********××××××*连接池××××××××××××××");
        for (int i=0;i<20;i++){
            long startTime = System.currentTimeMillis();

            Connection conn = ConnectionManager.getInstance().getConnection();
            try{
                PreparedStatement ps=conn.prepareStatement("select * from user");
                ResultSet rs = ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                conn.close();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("["+(i+1)+"] : " + (endTime-startTime));
        }

        System.out.println("*********××××××*普通链接××××××××××××××");
        for(int i=0;i<20;i++){
            long startTime = System.currentTimeMillis();
            Connection conn = getConnection();
            try{
                PreparedStatement ps=conn.prepareStatement("select * from user");
                ResultSet rs = ps.executeQuery();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                conn.close();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("["+(i+1)+"] : " + (endTime-startTime));


        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false","root","tuzhenyu");
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
