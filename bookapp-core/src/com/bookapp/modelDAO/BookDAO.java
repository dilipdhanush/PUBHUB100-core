package com.bookapp.modelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Books;
import com.bookapp.util.ConnectionUtil;


public class BookDAO {
	public List<Books> allBook() throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		List<Books> list1=new ArrayList<Books>();

		String sql="select name,author,price from books";
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			Books b1=new Books();
			b1.setName(rs.getString(1));
            b1.setAuthor(rs.getString(2));
			b1.setPrice(rs.getInt(3));
			list1.add(b1);
			
		}
		return list1;
	}
	public void add(Books book) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="insert into books(name,price,author) values (?,?,?)";
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setString(1,book.getName());
		ps.setInt(2, book.getPrice());
		ps.setString(3, book.getAuthor());
		
		ps.executeUpdate();
		System.out.println(" BOOK Inserted successfully");
	}
	public void remove(String name) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="delete from books where name=?";
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1,name);
		
		ps.executeUpdate();
		System.out.println("Book deleted Successfully");
	}
	
	public void changePrice(Books book) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		
		Books b3=new Books();
		String sql="update books set price=? where name=?";
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setInt(1,b3.getPrice());
		ps.setString(2, b3.getName());
		
		ps.executeUpdate();
		System.out.println("Price Updated Successfully");
	}
	
	public void rename(String oldName,String newName) throws Exception{
		Connection connection=ConnectionUtil.getConnection();
		
		String sql="update books set name=? where name=?";
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setString(1, newName);
		ps.setString(2, oldName);
		
		ps.executeUpdate();
		System.out.println("Name updated succesfully");
		
	}
	
	public List<Books> viewByPrice(int min,int max) throws Exception{

		List<Books> list1=new ArrayList<Books>();
		
		Connection connection=ConnectionUtil.getConnection();
		String sql="select name from books where price>=? and price<=? ";
		PreparedStatement ps=connection.prepareStatement(sql);
		
		ps.setInt(1,min);
		ps.setInt(2, max);
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			Books b1=new Books();
			b1.setName(rs.getString(1));
			list1.add(b1);
			
		}
	/*	Iterator itr=list1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		return list1;
		
	}
	public List<Books> viewByName(String bname) throws Exception{
		
		List<Books> list1=new ArrayList<Books>();
		
		Connection connection=ConnectionUtil.getConnection();
		String sql="select name,price,author from books where name like ? ";
		
		PreparedStatement ps= connection.prepareStatement(sql);
		ps.setString(1,"%" +bname + "%");
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			Books b2=new Books();
			b2.setName(rs.getString(1));
			b2.setPrice(rs.getInt(2));
			b2.setAuthor(rs.getString(3));
			list1.add(b2);
		}
		/*Iterator<Books> itr=list1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		return list1;
	}
}
