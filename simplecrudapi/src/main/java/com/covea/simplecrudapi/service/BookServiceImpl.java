package com.covea.simplecrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covea.simplecrudapi.dao.BookDAO;
import com.covea.simplecrudapi.models.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;

	@Override
	public List<Book> getBooks() {
		return bookDAO.findAll();
	}

	@Override
	public Book addBook(Book book) {
		System.out.println("Titre : "+ book.getTitle());
		System.out.println("Description : "+ book.getDescription());
		
		return bookDAO.save( new Book(book.getTitle(),book.getDescription(),book.isPublish()) );
	}

	@Override
	public Book getBookByID(Long id) {
		return bookDAO.findById(id).orElseThrow(
				() -> new RuntimeException("Aucun livre trouvé")
				);
	}

	@Override
	public Book updateBookInfo(Book book, Long id) {
		Book _book = bookDAO.findById(id).orElseThrow(
				() -> new RuntimeException("Aucun livre trouvé")
				);
		_book.setTitle(book.getTitle());
		_book.setDescription(book.getDescription());
		_book.setPublish(book.isPublish());
		
		return bookDAO.save(_book);
		
	}

	@Override
	public void deleteBookByID(Long id) {
		bookDAO.deleteById(id);
	}

}
