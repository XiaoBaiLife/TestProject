package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//����DAO
public class BaseDAO {
	
	private static final String USERS="sa";
	private static final String PASSWORD="sasa";
	private static final String URL="jdbc:sqlserver://localhost:1433;databasename=Demo";
	
	//����������Ӷ���ķ���
	public Connection getCon(){
		try {
			//1.��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2. ���Ӷ���
			Connection con = DriverManager.getConnection(URL, USERS, PASSWORD);
			return con;
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}
	
	
	//�ر���Դ
	public void closeAll(Connection con,PreparedStatement pst,ResultSet rst){
		
		//�ж��Ƿ���Ҫ�ر�
		if(rst !=null){
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		if(pst !=null){
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
		
	} 
	
	
	
}
