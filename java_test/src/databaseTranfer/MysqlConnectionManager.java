package databaseTranfer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;

/**
 * Created by tuzhenyu on 16-12-7.
 * @author tuzhenyu
 */
public class MysqlConnectionManager {
    private static MysqlConnectionManager instance = null;
    private static ComboPooledDataSource dataSource = null;

    private MysqlConnectionManager() throws PropertyVetoException{
        dataSource = new ComboPooledDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("tuzhenyu");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bigdataPlatform?useSSL=false");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");

        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
    }

    public static MysqlConnectionManager getInstance(){
        try {
            if (instance == null){
                instance = new MysqlConnectionManager();
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
