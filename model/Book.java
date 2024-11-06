/**
 * 
 * @author:
 * Joshua Bernardi
 * Zalma Farah
 * 
 * Purpose: The Book class represents a book in the system
 */
package model;

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

	public Book(int bookID, String subject, String title, String author,
			String publisher, String copyright, int edition, int numPages,
			String isbn, int totalCopies, int availableCopies)
	{
		super();
		this.bookID = bookID;
		this.subject = subject;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.copyright = copyright;
		this.edition = edition;
		this.numPages = numPages;
		this.isbn = isbn;
		this.totalCopies = totalCopies;
		this.availableCopies = availableCopies;
	}

	/**
	 * @return the bookID
	 */
	public int getBookID()
	{
		return bookID;
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(int bookID)
	{
		this.bookID = bookID;
	}

	/**
	 * @return the subject
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor()
	{
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher()
	{
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	/**
	 * @return the copyright
	 */
	public String getCopyright()
	{
		return copyright;
	}

	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright)
	{
		this.copyright = copyright;
	}

	/**
	 * @return the edition
	 */
	public int getEdition()
	{
		return edition;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(int edition)
	{
		this.edition = edition;
	}

	/**
	 * @return the numPages
	 */
	public int getNumPages()
	{
		return numPages;
	}

	/**
	 * @param numPages the numPages to set
	 */
	public void setNumPages(int numPages)
	{
		this.numPages = numPages;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn()
	{
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	/**
	 * @return the totalCopies
	 */
	public int getTotalCopies()
	{
		return totalCopies;
	}

	/**
	 * @param totalCopies the totalCopies to set
	 */
	public void setTotalCopies(int totalCopies)
	{
		this.totalCopies = totalCopies;
	}

	/**
	 * @return the availableCopies
	 */
	public int getAvailableCopies()
	{
		return availableCopies;
	}

	/**
	 * @param availableCopies the availableCopies to set
	 */
	public void setAvailableCopies(int availableCopies)
	{
		this.availableCopies = availableCopies;
	}
	
	
	public boolean checkOut(Date dueDate) {
		
		if(availableCopies > 0) {
			availableCopies--;
			return true;
		}
		
		return false; //returns false when no copies are available
	}
	
	/*
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

