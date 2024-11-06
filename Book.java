/**
 * 
 * @author:
 * Joshua Bernardi
 * Zalma Farah
 * 
 * Purpose: The Book class represents a book in the system
 */
import java.util.Date;

public class Book {
	
	/*
	 * id of the book
	 */
	private int bookID;
	
	/**
	 * subject of the book
	 */
	private String subject;
	
	/**
	 * title of the book
	 */
	private String title;
	
	/**
	 * author
	 */
	private String author;
	
	/**
	 * publisher
	 */
	private String publisher;
	
	/**
	 * copyright
	 */
	private String copyright;
	
	/**
	 * edition
	 */
	private int edition;
	
	/**
	 * pages
	 */
	private int numPages;
	
	/**
	 * ISBN
	 */
	private String isbn;
	
	/**
	 * total number of copies of the book
	 */
	private int totalCopies; 
	
	/**
	 * number of boo copies available
	 */
	private int availableCopies;
	
	
	/*
	public boolean checkOut(Date dueDate) {
		
		if(availableCopies > 0) {
			availableCopies--;
			this.dueDate = dueDate; //sets the due date when it is checked out
			return true;
		}
		
		return false; //returns false when no copies are available
	}
	
	public boolean returnBook() {
		
		if(dueDate != null) { //checks if the book has a due date
			availableCopies++;
			dueDate = null;
			return true; //returns true if the checkout was successful
		}
		
		return false;
	}
	
	public boolean isOverDue(Date currentDate) {
		
		return dueDate != null && currentDate.after(dueDate); //checks if the due date is set and if the current date is after the due date 
	}
	*/
}

