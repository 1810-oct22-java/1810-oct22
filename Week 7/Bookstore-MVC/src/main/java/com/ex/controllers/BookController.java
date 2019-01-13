package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.Book;
import com.ex.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;
	
	//Get ALL
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		return service.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> findById(@PathVariable int id) {
		Book b = service.getById(id);
		if (b==null) {
			//return not found
			return new ResponseEntity<Book>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			return new ResponseEntity<Book>(b, HttpStatus.OK);
		}
	}
	
	//CREATE
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addUser(@RequestBody Book b) {
		b = service.addUser(b);
		if (b==null) {
			return new ResponseEntity<Book>(HttpStatus.CONFLICT);
		}
		else {
			return new ResponseEntity<Book>(b,HttpStatus.CREATED);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}",
			method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateUser(@PathVariable int id, @RequestBody Book b) {
		Book auth = service.updateUser(id, b);
		if (auth==null) {
			return new ResponseEntity<Book>(HttpStatus.I_AM_A_TEAPOT);
		}
		else {
			return new ResponseEntity<Book>(b,HttpStatus.OK);
		}
	}

}