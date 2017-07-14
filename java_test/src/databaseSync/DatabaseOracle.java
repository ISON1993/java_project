package databaseSync;

import java.io.*;
import java.sql.*;
import java.util.Random;

/**
 * Created by tuzhenyu on 17-6-3.
 * @author tuzhenyu
 */
public class DatabaseOracle {
    public static void main(String[] args) {
        Random random = new Random();
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("loading Oracle Driver successfully!");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.0.215:1521/toolsnet","atlascopco_toolsnet","T00lsNetPwd");
            System.out.println("connect mysql successfully");
        }catch (Exception e){
            System.out.println("load the driver file");
        }

        try{
            File file = new File("/home/tuzhenyu/tmp/weichai/unitId2.txt");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                String[] units = line.split("\\t");
                countUnitID(conn,Long.parseLong(units[0]),Long.parseLong(units[1]));
            }
        }catch (Exception e){
            System.out.println("execute the sql fail");
            e.printStackTrace();
        }
    }

    public static void countUnitID(Connection conn,long unit1,long unit2)throws Exception{
        long count=0;
        Statement statement = conn.createStatement();
        String countSql ="SELECT COUNT(*) FROM \"Result\" r " +
                "WHERE r.\"ResultDateTime\" BETWEEN  to_date('2014-01-01 00:00:00','yyyy-MM-dd HH24:mi:ss')" +
                "AND to_date('2017-04-01 23:00:00','yyyy-MM-dd HH24:mi:ss') AND r.\"UnitID\"=" +unit1;
        ResultSet rs = statement.executeQuery(countSql);
        if (rs.next())
        {
            count = rs.getLong(1);
        }
        if (count<10000)
            System.out.println(unit1+"\t"+unit1);
        else
            System.out.println(unit1+"\t"+unit1+"\t"+"###");
    }
}
