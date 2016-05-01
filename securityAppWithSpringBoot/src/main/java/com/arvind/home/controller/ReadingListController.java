package com.arvind.home.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arvind.home.repository.Book;
import com.arvind.home.repository.Reader;
import com.arvind.home.repository.ReaderRepository;
import com.arvind.home.repository.ReadingListRepository;

@RestController
@RequestMapping(value="/")
public class ReadingListController {

	@Autowired
	private ReadingListRepository readingListRepository;

	@Autowired
	private ReaderRepository readerRepo;
	
	
		@CrossOrigin(origins="*")
		@RequestMapping(value="/api/books",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Book> loadAllBooks() {
			return readingListRepository.findAll();
		}
		
		@RequestMapping(value="/secure/api/books",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Book> loadAllBooksSecurly() {
			List<Book> books = readingListRepository.findAll();
			for(Book book: books) {
				book.setSecure(true);
			}
			return books;
		}
		
		@RequestMapping(value="/api/books", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Book> saveBook(@RequestBody Book book) {
			readingListRepository.save(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		
		
		
		
		
		
		@PostConstruct
		public void setupUsers() {
			
			Book book = new Book();
			book.setAuthor("Arvinda adiga");
			book.setDescription("this is just a book description");
			book.setId(123L);
			book.setIsbn("someUniqueValue");
			book.setReader("many people read this book");
			book.setTitle("The White Tiger");
			
			readingListRepository.save(book);
			
			
			String[] usernames = new String[]{"arvind","admin"};
			for(String user: usernames) {
				Reader reader = new Reader();
				reader.setUserName(user);
				reader.setPassword("test");
				reader.setFullName("ARvind upadhyay");
				readerRepo.save(reader);
			}

}



}
