package databaseTranfer;

import jdbc.mysql.Mysql;

import java.sql.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tuzhenyu on 17-3-25.
 * @author tuzhenyu
 */
public class SearchQueue {
    private Deque<Integer> tableQueue = new ArrayDeque<>();
    private AtomicLong currentSynCount = new AtomicLong(0L);

    public SearchQueue(){
        Connection conn = OracleConnectionManager.getInstance().getConnection();
        try {
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery("SELECT DISTINCT \"UnitID\" FROM \"Result\"" +
                    "WHERE \"ResultDateTime\" BETWEEN  to_date('2016-08-01 00:00:00','yyyy-MM-dd HH24:mi:ss')" +
                    "AND to_date('2016-09-01 23:00:00','yyyy-MM-dd HH24:mi:ss') ORDER BY \"UnitID\" ASC");
            while (rs.next()) {
                tableQueue.add(rs.getInt(1));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private synchronized Integer getTableName(){
        Integer tableName = tableQueue.poll();
        return tableName;
    }

    public boolean tranfer(){
        boolean flag = true;
        if (!tableQueue.isEmpty()){
            Integer tableName = getTableName();
            System.out.println(Thread.currentThread().getName()+" is fetching "+tableName);
//            String selectSql = "SELECT \"ID\",\"ResultDateTime\",\"ProgramID\",\"UnitID\",\"PositionID\" FROM \"Result\"" +
//                    "WHERE \"ResultDateTime\" BETWEEN  to_date('2016-08-01 00:00:00','yyyy-MM-dd HH24:mi:ss')" +
//                    "AND to_date('2016-09-01 23:00:00','yyyy-MM-dd HH24:mi:ss') AND \"UnitID\"="+tableName;
//            String selectSql = "SELECT r.ID,rt.\"FinalAngle\",rt.\"FinalTorque\" FROM \"Result\" r LEFT JOIN \"ResultTightening\" rt ON r.ID = rt.\"ResultID\"\n" +
//                    "WHERE \"ResultDateTime\" BETWEEN  to_date('2016-08-01 00:00:00','yyyy-MM-dd HH24:mi:ss')\n" +
//                    "AND to_date('2016-09-01 23:00:00','yyyy-MM-dd HH24:mi:ss') AND \"UnitID\"="+tableName;
            String selectSql ="SELECT DISTINCT p.ID,p.\"Name\",a.\"ItemValue\",b.\"ItemValue\" FROM \"Result\" r " +
                    "LEFT JOIN \"Program\" p ON r.\"ProgramID\" = p.ID " +
                    "LEFT JOIN (SELECT \"ResultID\",\"ItemValue\" FROM \"ResultValueFloat\" rvf WHERE rvf.\"ResultValueTypeID\"=73) a ON r.ID = a.\"ResultID\"" +
                    "LEFT JOIN (SELECT \"ResultID\",\"ItemValue\" FROM \"ResultValueFloat\" rvf WHERE rvf.\"ResultValueTypeID\"=74) b ON r.ID = b.\"ResultID\"" +
                    "WHERE r.\"ResultDateTime\" BETWEEN  to_date('2016-08-01 00:00:00','yyyy-MM-dd HH24:mi:ss')" +
                    "AND to_date('2016-09-01 23:00:00','yyyy-MM-dd HH24:mi:ss') AND \"UnitID\"=" +tableName;

            Connection oracleConn = OracleConnectionManager.getInstance().getConnection();
            Connection mysqlConn = MysqlConnectionManager.getInstance().getConnection();
            try {
                mysqlConn.setAutoCommit(false);
                PreparedStatement mysqlPstmt = mysqlConn.prepareStatement("INSERT INTO Program VALUES (?,?,?,?)");
                Statement sm = oracleConn.createStatement();
                ResultSet rs = sm.executeQuery(selectSql);
                int batchCounter = 0;
                while (rs.next()) {
                    mysqlPstmt.setLong(1, rs.getLong(1));
                    mysqlPstmt.setNCharacterStream(2, rs.getNCharacterStream(2));
                    mysqlPstmt.setFloat(3, rs.getFloat(3));
                    mysqlPstmt.setFloat(4, rs.getFloat(4));

                    mysqlPstmt.addBatch();
                    batchCounter++;
                    currentSynCount.incrementAndGet();
                    if (batchCounter%10000 == 0){
                        mysqlPstmt.executeBatch();
                        mysqlPstmt.clearBatch();
                        mysqlConn.commit();
                    }
                }
                mysqlPstmt.executeBatch();
                mysqlPstmt.clearBatch();
                mysqlConn.commit();

                oracleConn.close();
                mysqlConn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":table-"+tableName+" is finished,the count is "+ currentSynCount);
        }else {
            flag=false;
        }

        return flag;
    }


}
