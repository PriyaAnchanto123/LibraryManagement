package org.management.lms.model;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class Lending {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="book_id",referencedColumnName = "id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;

	private LocalDate lentDate;

	private LocalDate returnDate;

	private LocalDate dueDate;

	private String status;

	public Lending()
	{

	}

	public Lending(Book book, User user) {
		this.book = book;
		this.user = user;
//		this.lentDate = lentDate;
//		this.returnDate = returnDate;
	//	this.status=status;
	}

//	public enum statuses{
//		LENT,
//		RETURNED
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getLentDate() {
		return lentDate;
	}

	public void setLentDate(LocalDate localDate) {
		this.lentDate = localDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String lent) {
		this.status = lent;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Lending [id=" + id + ", book=" + book + ", user=" + user + ", issueDate=" + lentDate + ", returnDate="
				+ returnDate  + "]";
	}
	
	
	
}
