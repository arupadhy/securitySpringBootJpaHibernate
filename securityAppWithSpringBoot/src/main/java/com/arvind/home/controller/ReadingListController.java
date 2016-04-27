package com.arvind.home.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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

		@RequestMapping(value="/loadBooks",method=RequestMethod.GET)
		public List<Book> loadAllBooks() {
			return readingListRepository.findAll();
		}
		
		@RequestMapping(value="/addBook", method=RequestMethod.POST)
		public String saveBook(Book book) {
			readingListRepository.save(book);
			return "saved";
		}
		
		@PostConstruct
		public void setupUsers() {
			
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
