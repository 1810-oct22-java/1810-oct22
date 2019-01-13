package com.ex.beans;

public class Book {
	
	private int id;
	private String title;
	private Author author;
	private String description;
	
	public Book () {}
	
	public Book(int id, String title, Author author, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
