package databaseTranfer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by tuzhenyu on 17-3-24.
 * @author tuzhenyu
 */
public class Main {
    public static void main(String[] args) {
        Connection conn = OracleConnectionManager.getInstance().getConnection();
        try {
            Statement sm = conn.createStatement();
            ResultSet rs = sm.executeQuery("SELECT * FROM \"Position\" WHERE ID BETWEEN 680 AND 730");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
