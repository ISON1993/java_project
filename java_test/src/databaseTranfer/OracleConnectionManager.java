package databaseTranfer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

/**
 * Created by tuzhenyu on 16-12-7.
 * @author tuzhenyu
 */
public class OracleConnectionManager {
    private static OracleConnectionManager instance = null;
    private static ComboPooledDataSource dataSource = null;

    private OracleConnectionManager() throws PropertyVetoException{
        dataSource = new ComboPooledDataSource();

        dataSource.setUser("atlascopco_toolsnet");
        dataSource.setPassword("T00lsNetPwd");
        dataSource.setJdbcUrl("jdbc:oracle:thin:@//192.168.0.215:1521/toolsnet");
        dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
    }

    public static OracleConnectionManager getInstance(){
        try {
            if (instance == null){
                instance = new OracleConnectionManager();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
