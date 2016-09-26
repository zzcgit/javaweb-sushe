package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/sushe";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	
	//连接数据库
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
