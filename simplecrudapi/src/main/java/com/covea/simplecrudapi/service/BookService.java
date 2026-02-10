package com.covea.simplecrudapi.service;

import java.util.List;

import com.covea.simplecrudapi.models.Book;

public interface BookService {
	
	List<Book> getBooks();
	
	Book addBook(Book book);
	
	Book getBookByID(Long id);
	
	Book updateBookInfo(Book book,Long id);
	
	void deleteBookByID(Long id);

}
