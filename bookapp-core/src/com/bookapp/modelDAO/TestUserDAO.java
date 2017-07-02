package com.bookapp.modelDAO;

import com.bookapp.model.User;

public class TestUserDAO {

	public static void main(String[] args) throws Exception {
		User user=new User();
		user.setName("guru");
		user.setEmail("abc@gmail.com");
		user.setPassword("pass12345");
		UserDAO userDAO=new UserDAO();
		userDAO.register(user);
 }
}

