package com.ex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.beans.Author;

@Service("authorService")
public class AuthorService {

	static List<Author> authors = new ArrayList<Author>();
	
	static int seq = 7;
	
	static {
		authors.add(new Author(4,"J.K. Rowling","Wrote Harry Potter"));
		authors.add(new Author(5,"Mark Zusak","Chill guy"));
		authors.add(new Author(6,"Saints","Died a long time ago"));
	}
	
	public List<Author> getAll(){
		return authors;
	}
	
	public Author getById(int id) {
		return authors.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}
	
	public Author findByName(String name) {
		return authors.stream().filter(t -> t.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}
	
	public Author addUser(Author a) {
		Author test = findByName(a.getName());
		if (test==null) {
			a.setId(seq++);
			authors.add(a);
			return a;
		}
		else {
			return null;
		}
	}
	
	public Author updateUser(int id, Author a) {
		Author auth = getById(id);
		if (auth==null) {
			return addUser(auth);
		}
		else {
			for (Author at : authors) {
				if (at.getId()==(a.getId())) {
					at.setName(a.getName());
					at.setBio(a.getBio());
					return at;
				}
			}
		}
		return null;
	}
	
}
