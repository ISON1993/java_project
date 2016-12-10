package jdbc.connectionPool;


import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuzhenyu on 16-12-7.
 * tuzhenyu
 */
@Setter
@Getter
public class Pool {
    public String user;
    public String password;
    public String jdbcUrl;
    public String jdbcDriver;

    public Integer initialPoolSize =10;
    public Integer minPoolSize = 1;
    public Integer maxPoolSize = 20;

    public Map<Connection,Boolean> connections;

    public Pool(){}

    public Pool(String jdbcDriver,String jdbcUrl,String user,String password){
        this.jdbcDriver = jdbcDriver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
    }
    public Connection getConnection(){
        Connection conn = null;
        conn = getFreeConnection();
        while(conn == null){
            try {
               wait(30);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return conn;
    }
    private Connection getFreeConnection(){
        Connection connFlag = null;
        if (this.connections == null){
            createPool();
        }
        for(Connection conn : this.connections.keySet()){
            if(connections.get(conn)){
                connFlag = conn;
                break;
            }
        }
        return connFlag;
    }
    private void createPool(){
        try{
            Driver driver = (Driver)(Class.forName(this.jdbcDriver).newInstance());
            DriverManager.registerDriver(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.connections = new HashMap<>();
        createConnections(initialPoolSize);
    }

    private void createConnections(Integer num){
        for (int i=0;i<num;i++){
            if(this.connections.size()>this.maxPoolSize){
                return;
            }
            connections.put(newConnection(),true);
        }
    }
    private Connection newConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.jdbcUrl,this.user,this.password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
