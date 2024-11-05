/**
 * 
 */
/**
 * 
 */
import java.util.Date;

public class Book {
	
	private String title;
	private String author;
	private int totalCopies; //total num of copies of the book
	private int availableCopies; //num books available
	private Date dueDate;
	
	/**
	 * 
	 * 
	 * @param title
	 * @param author
	 * @param totalCopies
	 */
	public Book(String title, String author, int totalCopies) {
		
		this.title = title;
		this.author = author;
		this.totalCopies = totalCopies;
		this.availableCopies = totalCopies;
		this.dueDate = null; //no due date if it is not checked out
	}

	
	public String getTitle() {
		
		return title;
	}
	
	
	public String getAuthor() {
		
		return author;
	}
	
	public int getTotalCopies() {
		
		return totalCopies;
	}
	
	public int getAvailableCopies() {
		
		return availableCopies;
	}
	
	public Date dueDate() {
		
		return dueDate;
	}
	
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
}

