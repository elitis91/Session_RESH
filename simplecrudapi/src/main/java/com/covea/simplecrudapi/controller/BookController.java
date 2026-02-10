package com.covea.simplecrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covea.simplecrudapi.models.Book;
import com.covea.simplecrudapi.service.BookService;


import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = "/api/v1/books")
@CrossOrigin()
public class BookController {
	
	@Autowired
	BookService bookService;
	

	
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", 
	        			 description = "Default error sample response", 
	        			 content = @Content(mediaType = "application/json")) ,
	        @ApiResponse(responseCode = "500", 
	        			 description = "Default error sample response" )
	})
	@GetMapping(path = "", produces = "application/json")
	public ResponseEntity<?> getBooks(
			
			){

		
		try {
			return new ResponseEntity<List<Book>>(bookService.getBooks(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "200", 
	        			 description = "Default error sample response", 
	        			 content = @Content(mediaType = "application/json")) ,
	        @ApiResponse(responseCode = "500", 
	        			 description = "Default error sample response" ),
	        @ApiResponse(responseCode = "404", 
			 description = "Default error sample response" )
	})
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getBookByID(@PathVariable Long id){
		try {
			return new ResponseEntity<Book>(bookService.getBookByID(id),HttpStatus.OK);
		} catch (RuntimeException r) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(path = "", produces = "application/json")
	public ResponseEntity<?> addBook(@RequestBody Book book) {
		try {
			return new ResponseEntity<Book>(bookService.addBook(book),HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return  ResponseEntity.internalServerError().body("Erreur lors de la creation");
		}
	}
	
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> updateBookInfo(@RequestBody Book book, @PathVariable Long id){
		try {
			Book _book = bookService.updateBookInfo(book, id);
			return new ResponseEntity<Book>(_book,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return  ResponseEntity.internalServerError().body("Erreur lors de la creation");
		}
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteBookByID(@PathVariable Long id){
		try {
			bookService.deleteBookByID(id);
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
