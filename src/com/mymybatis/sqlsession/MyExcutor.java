package com.mymybatis.sqlsession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mymybatis.pojo.User;



public class MyExcutor implements Excutor{

	private MyConfiguration xmlConfiguration = new MyConfiguration();
	
	@Override
	public <T> T query(String sql, Object parameter) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		ResultSet set = null;
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			System.out.println(">>>>>>>> pre" + pre);
			//设置参数
			pre.setString(1,parameter.toString());
			System.out.println(">>>>>>>> pre" + pre);
			
			set = pre.executeQuery();
			System.out.println("set :" + set.toString());
			User u = new User();
			//遍历结果集
			while(set.next()){
				u.setId(set.getString(1));
                u.setUsername(set.getString(2)); 
                u.setPassword(set.getString(3));
			}
			return (T) u;
		} catch (SQLException e) {
			// TODO: handle exception
			 e.printStackTrace(); 
		} finally{
			try {
				if(set != null){
					set.close();
				}if(pre != null){
					pre.close();
				}if(connection != null){
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();  
			}
		}
		return null;
	}
	
	

	private Connection getConnection(){
		try {
			Connection connection = xmlConfiguration.build("resources/config.xml");
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
				
	}
	

}
