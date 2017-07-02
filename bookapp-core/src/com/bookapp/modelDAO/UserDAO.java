package com.bookapp.modelDAO;

import java.sql.Connection;

import com.bookapp.model.User;
import com.bookapp.util.ConnectionUtil;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class UserDAO  {
	public void register(User user) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="insert into users(name,email,password) values (?,?,?)";
		PreparedStatement ps=(PreparedStatement) connection.prepareStatement(sql);
		
		ps.setString(1,user.getName() );
		ps.setString(2, user.getEmail());
		ps.setString(3,user.getPassword());
		
		ps.executeUpdate();
		System.out.println("Inserted successfully");
		
	}
	
	public void login(User user) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		int c=0;
		String sql="select name from users where email=? and password=?";
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		
		ResultSet rs=(ResultSet) preparedStatement.executeQuery();
		while(rs.next()){
			c+=1;
		}
		if(c>0){
			System.out.println("Logged in");
		}
		
		
		
	}
}
