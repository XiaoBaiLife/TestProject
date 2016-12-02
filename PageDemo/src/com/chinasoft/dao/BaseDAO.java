package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//公共DAO
public class BaseDAO {
	
	private static final String USERS="sa";
	private static final String PASSWORD="sasa";
	private static final String URL="jdbc:sqlserver://localhost:1433;databasename=Demo";
	
	//创建获得连接对象的方法
	public Connection getCon(){
		try {
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. 连接对象
			Connection con = DriverManager.getConnection(URL, USERS, PASSWORD);
			return con;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	
	//关闭资源
	public void closeAll(Connection con,PreparedStatement pst,ResultSet rst){
		
		//判断是否需要关闭
		if(rst !=null){
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		if(pst !=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		
	} 
	
	
	
}
