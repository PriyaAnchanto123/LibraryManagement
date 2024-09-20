package org.management.lms.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
public class Book {
   

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String title;
    private String author;
    private int totalCopies;
	private int availableCopies;
    private int noOfBooksLent;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lending> lendings;

    public Book(String title, String author, int totalCopies, int availableCopies, int noOfBooksLent) {
	
		this.title = title;
		this.author = author;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
		this.noOfBooksLent = noOfBooksLent;
	}
  


    public Book() {
    }

    public int getTotalCopies() {
  		return totalCopies;
  	}

  	public void setTotalCopies(int totalCopies) {
  		this.totalCopies = totalCopies;
  	}

  	public int getAvailableCopies() {
  		return availableCopies;
  	}

  	public void setAvailableCopies(int availableCopies) {
  		this.availableCopies = availableCopies;
  	}

  	public int getNoOfBooksLent() {
  		return noOfBooksLent;
  	}

  	public void setNoOfBooksLent(int noOfBooksLent) {
  		this.noOfBooksLent = noOfBooksLent;
  	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void decrementAvailableCopies() {
        if (availableCopies > 0) {
            this.availableCopies--;
        }
    }

    public void incrementAvailableCopies() {
        if (availableCopies < totalCopies) {
            this.availableCopies++;
        }
    }


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", TotalCopies=" + totalCopies
				+ ", availableCopies=" + availableCopies + ", noOfBooksLent=" + noOfBooksLent + "]";
	}

   
}
