package com.revature.pojos;

public class Book {
	
	private int id;
	private String ISBN;
	private String title;
	private double price;
	private int genre;
	private int author;
	
	public Book() {}
	
	public Book(String iSBN, String title, double price, int genre, int author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.price = price;
		this.genre = genre;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", id=" + id + ", ISBN=" + ISBN + ", price=" + price + ", genre=" + genre
				+ ", author=" + author + "]";
	}

}
