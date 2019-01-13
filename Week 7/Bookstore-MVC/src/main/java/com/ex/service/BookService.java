package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.beans.Author;
import com.ex.beans.Book;

@Service("bookService")
public class BookService {

	static List<Book> books = new ArrayList<Book>();
	
	static int seq = 4;
	
	static {
	    books.add(new Book(1,"Harry Potter and Philosopher's Stone",new Author(4,"J.K. Rowling","Wrote Harry Potter"),"1st Harry Potter"));
	    books.add(new Book(2,"The Book Thief",new Author(5,"Mark Zusak","Is a chill guy"),"Holocaust Book"));
	    books.add(new Book(3,"The Bible",new Author(6,"Saints","Died a long time ago"),"The Roman Catholic Bible"));
	}
	
	public List<Book> getAll(){
		return books;
	}
	
	public Book getById(int id) {
		return books.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}
	
	public Book findByTitle(String title) {
		return books.stream().filter(t -> t.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
	}
	
	public Book addUser(Book b) {
		Book test = findByTitle(b.getTitle());
		if (test==null) {
			b.setId(seq++);
			books.add(b);
			return b;
		}
		else {
			return null;
		}
	}
	
	public Book updateUser(int id, Book b) {
		Book book = getById(id);
		if (book==null) {
			return addUser(book);
		}
		else {
			for (Book bo : books) {
				if (bo.getId()==(b.getId())) {
					b.setTitle(b.getTitle());
					b.setAuthor(b.getAuthor());
					b.setDescription(b.getDescription());
					return bo;
				}
			}
		}
		return null;
	}
	
}
