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
        SearchQueue searchQueue = new SearchQueue();
        MyThread t1 = new MyThread(searchQueue);
        MyThread t2 = new MyThread(searchQueue);
        MyThread t3 = new MyThread(searchQueue);
        MyThread t4 = new MyThread(searchQueue);
        MyThread t5 = new MyThread(searchQueue);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
