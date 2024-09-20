package org.management.lms.service;



import java.util.List;
import java.util.Optional;

import org.management.lms.dao.BookRepository;
import org.management.lms.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

	BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void save(Book book)
	{
		Object obj=bookRepository.findById(book.getId());
		book.setAvailableCopies(book.getTotalCopies());
		System.out.println(book.getAvailableCopies());
		book.setNoOfBooksLent(0);
		bookRepository.save(book);
	}

	public List<Book> getAll()
	{
		return bookRepository.findAll();
	}

	public void delete(int id)
	{
		bookRepository.deleteById(id);
	}

	public void update(int id,Book updatedBook)
	{
		Book existingBook=bookRepository.findById(id).orElseThrow();
		existingBook.setTotalCopies(updatedBook.getTotalCopies());
		existingBook.setAvailableCopies(existingBook.getTotalCopies()-existingBook.getNoOfBooksLent());
		bookRepository.save(existingBook);
		updatedBook.setId(existingBook.getId());
	}
}
