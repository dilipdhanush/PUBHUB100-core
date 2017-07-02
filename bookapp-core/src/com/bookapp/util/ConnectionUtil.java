package com.bookapp.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    
	public static Connection getConnection() throws Exception{
		        Class.forName("com.mysql.jdbc.Driver");
		        String url = "jdbc:mysql://localhost:3306/bookapp_db";
		        Connection con = DriverManager.getConnection(url,"root" ,"dilipan");
	           // con.close();
	            return con;
		    }
/*	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}*/
}
