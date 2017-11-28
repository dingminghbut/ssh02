package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.Configure;

public class BaseDao {
	private Connection connection;
	private PreparedStatement preparedstatements;
	private ResultSet rs;
	
	public boolean getConnection(){
		boolean flag = false;
		
		try {
			Configure configure = Configure.getInstance();
			String driver = configure.getProperties("driver");
			System.out.println(driver);
			Class.forName(driver);
			String url = configure.getProperties("url");
			String user = configure.getProperties("user");
			String password = configure.getProperties("password");
			System.out.println(url+","+user+","+password);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(connection!=null){
			flag = true;
			System.out.println("-----连接成功！！！-----");
		}else{
			System.out.println("-----连接失败！！！-----");
		}
		return flag;
	}
//	//测试连接情况
//	public static void main(String[] args) {
//		BaseDao bd = new BaseDao();
//		bd.getConnection();
//	}
	public ResultSet query(String sql,Object param[]){
		try {
			if(getConnection()){
				preparedstatements = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatements.setObject(i+1, param[i]);
				}
				rs = preparedstatements.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int update(String sql,Object param[]){
		int total = 0;
		try {
			if(getConnection()){
				preparedstatements = connection.prepareStatement(sql);
				for(int i=0;i<param.length;i++){
					preparedstatements.setObject(i+1, param[i]);
				}
				total = preparedstatements.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public void close(){
		try {
			if(rs!=null){
				rs.close();
			}if(preparedstatements!=null){
				preparedstatements.close();
			}if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
