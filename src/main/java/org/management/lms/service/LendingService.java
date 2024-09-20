package org.management.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.management.lms.dao.BookRepository;
import org.management.lms.dao.LendingRepository;
import org.management.lms.dao.UserRepository;
import org.management.lms.dto.UserDTO;
import org.management.lms.model.Book;
import org.management.lms.model.Lending;
import org.management.lms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LendingService {

	LendingRepository lendingRepo;
	BookRepository bookRepo;
	UserRepository userRepo;
	@Autowired
	public LendingService(LendingRepository lendingRepository,BookRepository bookRepo,UserRepository userRepo) {
		this.lendingRepo = lendingRepository;
		this.bookRepo = bookRepo;
		this.userRepo=userRepo;
	}

	@Transactional
	public boolean lentBook(Lending lending)
	{
		Book book=bookRepo.findById(lending.getBook().getId()).orElseThrow(RuntimeException::new);
		User user=userRepo.findById(lending.getUser().getId()).orElseThrow(RuntimeException::new);

		lending.setBook(book);
		lending.setUser(user);
		lending.setLentDate(LocalDate.now());
		lending.setDueDate(LocalDate.now().plusDays(7));
		lending.setReturnDate(LocalDate.now().plusDays(7));
		lending.setStatus("LENT");
		if(book.getAvailableCopies()>0 && book.getNoOfBooksLent()<book.getTotalCopies()) {
			book.decrementAvailableCopies();
			book.setNoOfBooksLent(lending.getBook().getNoOfBooksLent() + 1);
			bookRepo.save(book);
			lendingRepo.save(lending);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean returnBook(int userId,int bookId)
	{
		Book book=bookRepo.findById(bookId).orElseThrow(RuntimeException::new);
		User user=userRepo.findById(userId).orElseThrow(RuntimeException::new);

		if(book!=null&&user!=null) {
			Lending lending = lendingRepo.findByUserIdAndBookId(userId, bookId);
			if (book.getNoOfBooksLent() > 0 && book.getNoOfBooksLent() <= book.getTotalCopies()) {
				book.setAvailableCopies(book.getAvailableCopies() + 1);
				book.setNoOfBooksLent(book.getNoOfBooksLent() - 1);
				bookRepo.save(book);
				lending.setStatus("RETURNED");
				lending.setReturnDate(LocalDate.now());
				lendingRepo.save(lending);

			}
			return true;
		}
		else {
			return false;
		}
	}

	public List<Lending> getLendingDetailsOfUser(int user_id)
	{
		return lendingRepo.findByUserId(user_id);
	}

}
