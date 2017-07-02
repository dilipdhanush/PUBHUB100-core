package com.bookapp.model;

public class TestUser {

	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("dilip");
		user.setEmail("dilipcse97@gmail.com");
		user.setPassword("pass123");
		user.setStatus(1);
		System.out.println(user.getName());
		System.out.println(user);
	}

}
