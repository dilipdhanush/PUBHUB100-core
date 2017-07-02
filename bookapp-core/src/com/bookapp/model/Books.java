package com.bookapp.model;

public class Books {
		private int bookid;
		private String name;
		private int price;
		private String author;
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		@Override
		public String toString() {
			return "Books [bookid=" + bookid + ", name=" + name + ", price=" + price + ", author=" + author + "]";
		}
		
	
	
}
