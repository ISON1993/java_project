/**********************************************************
String sql = "create table test (name varchar(20),age int);";
String sql = "insert into test values('marry',10);";
String sql = "create table t5 (name varchar(20),age int);";
String sql = "load data local infile 'D:/t1.txt' into table test(name,age);";
*********************************************************/
package jdbc.mysql;
import java.sql.*;

public class Mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String sql = "select * into outfile 'D:\\\\t2.txt' lines terminated by '\r\n' from test;";
		OperateMysql opt = new OperateMysql();
		Connection conn = opt.Login();
		//opt.showTable(conn, "t1");
		//opt.MysqlToTxt(conn, "test", "t1");
		//opt.operate(conn, sql);
		//opt.insert(conn,"test");
		opt.TxtToMysql(conn);
	}
}
