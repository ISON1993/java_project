package jdbc.mysql;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.*;
import java.util.Scanner;

public class OperateMysql {
	
	public Connection Login()
	{
		
		Scanner input = new Scanner(System.in);
		Connection  connect = null;
	    String ip = null;
	    String databaseName= null;
	    String user= null;
	    String password= null;
	    
	    try
	    {
	    System.out.println("������IP��ַ��");
	    ip = input.next();
	    System.out.println("�������û�����");
	    user = input.next();
	    System.out.println("���������ݿ����ƣ�");
	    databaseName = input.next();
	    System.out.println("�������û����룺");
	    password = input.next();
	    }finally{
	    	
	    	input.close();
	    }
	    
	    String url = "jdbc:mysql://"+ip+":3306/"+databaseName+"?useSSL=false";
		
	    try 
	    {
	    	Class.forName("com.mysql.jdbc.Driver");     
	    	System.out.println("loading Mysql Driver successfully!");
	    }catch (Exception e) 
	    {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
	    }
	    
	    
	    try 
	    {
	    	
		      connect = DriverManager.getConnection(url,user,password);
		      System.out.println("connect Mysql server successfully!");
			  
	    }catch (Exception e)
	    {
		      System.out.print("get data error!");
		      e.printStackTrace();
	    }  

	    return connect;     
	}	
	
	
	public void showTable(Connection conn,String tableName)
	{
		String sql = "select * from "+ tableName;
		
		try
		{
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
//		    stmt.executeUpdate(sql)
		    ResultSetMetaData rsmd = rs.getMetaData();
		 
		    while (rs.next()) 
		    {
		    	 for(int i =0; i < rsmd.getColumnCount(); i++)
		    	 {
		    		 System.out.print(rs.getString(i+1) + "\t");
		    	 }
		    	 System.out.print("\n");
		      
		    }
		
		}catch (Exception e)
	    {
		      System.out.print("show the table error!");
		      e.printStackTrace();
	    }                                                        
	      
	}
	
	public void operate(Connection conn,String sql)
	{
		try
		{
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			//stmt.executeUpdate(sql);
			
			//PreparedStatement pstmt = conn.prepareStatement("insert into test values(?,?);");
			//pstmt.setString(1,"Tim");
			//pstmt.setInt(2,50);
			//pstmt.executeUpdate();
			//pstmt.execute();
			
		}catch (Exception e)
	    {
		      System.out.print("operate error!");
		      e.printStackTrace();
	    }finally
	    {
	    	System.out.println("operate successfully!");
	    }
		
	}
	
	public void insert(Connection conn,String tableName)
	{
		String sql = "insert into " + tableName + " values(?,?);";
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(int i=0;i < 100 ; i++)
			{
				pstmt.setString(1,"Tim"+i);
				pstmt.setInt(2,i*10);
				pstmt.executeUpdate();
			}
			
		}catch (Exception e)
	    {
		      System.out.print("operate error!");
		      e.printStackTrace();
	    }finally
	    {
	    	System.out.println("operate successfully!");
	    }
		
	}
	
	public void MysqlToTxt(Connection conn,String tableName,String fileName)
	{
		String file = "D:\\temp\\"+fileName+".txt";
		String sql = "select * from "+ tableName;
		try
		{
			FileWriter out = new FileWriter(file,true);
			Reader reader = null;
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    ResultSetMetaData rsmd = rs.getMetaData();
		 
		    while (rs.next()) 
		    {
		    	 for(int i =0; i < rsmd.getColumnCount(); i++)
		    	 {
		    		 reader = rs.getCharacterStream(i+1);
		    		 char buffer[] = new char[1024];
		    		 int len = 0;
		    		 while((len=reader.read(buffer))>0)
		    		 {
			    		 out.write(buffer, 0, len);
			    		 out.write("\r\t");
		    		 }
		    		 reader.close();
		    	 }
		    	 out.write("\r\n");
		    }
		    out.close();
   		 	
		
		}catch (Exception e)
	    {
		      System.out.print("export the mysql file to txt error!");
		      e.printStackTrace();
	    }
	  
	}
	
	public void TxtToMysql(Connection conn)
	{
		
		PreparedStatement st = null;
		Reader reader = null;
		
		String path = "D:\\t2.txt";
		try
		{
			String sql = "insert into tt values(?);";
			File file = new File(path);
			reader = new BufferedReader(new FileReader(file));
			st = conn.prepareStatement(sql);
	        st.setCharacterStream(1, reader,(int) file.length());
	        //st.setCharacterStream(2, reader,(int) file.length());
	        
	        
	        int num = st.executeUpdate();
	        if(num>0){
	        	System.out.println("����ɹ�����");
			}
	        reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	    
	}
	
	
	


	
	
	
	
	
	
}
