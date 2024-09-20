package org.management.lms.controller;

import org.management.lms.model.Lending;
import org.management.lms.service.LendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lent")
public class LendingController {
	
	@Autowired
	LendingService lendingService;

	boolean b;
	
	@PostMapping("/lents")
	public String lentBook(@RequestBody Lending lending)
	{
		 b=lendingService.lentBook(lending);
		 if(b) {
			 return "book lent with bookid\t" + lending.getBook().getId() + "\t to userid\t" + lending.getUser().getId();
		 }
		 else {
			 return "book is not available to lent";
		 }
	}

	@PostMapping("/return")
	public String returnBook(@RequestParam("userId") int userId,@RequestParam("bookId") int bookId)
	{
		b=lendingService.returnBook(userId,bookId) ;
		if(b)
		{
			return "book with id: "+bookId+" is returned by user(id) "+userId;
		}
		else
		{
			return "please enter valid userId and bookId";
		}
	}

	@GetMapping("/user/{user_id}")
	public List<Lending> getLendingDetailsOfUser(@PathVariable int user_id)
	{
		System.out.println(user_id);
		return lendingService.getLendingDetailsOfUser(user_id);
	}

}
