package org.management.lms.controller;



import java.util.List;

import org.management.lms.model.Book;
import org.management.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	
	@PostMapping("/books")
	public String add(@RequestBody Book book)
	{
		bookService.save(book);
		return "book added successfully with id"+book.getId();
	}
	
	@GetMapping("/books")
	public List<Book> getAll()
	{
		return bookService.getAll();
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		bookService.delete(id);
		return "book is deleted";
	}

	@PatchMapping("/{id}")
	public String update(@PathVariable int id,@RequestBody Book book)
	{
		bookService.update(id,book);
		return "book with id: "+book.getId()+" is updated";
	}
}
