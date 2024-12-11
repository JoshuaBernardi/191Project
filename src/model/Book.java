/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Book represents a book in the system
 */
package model;

// LO1 - encapsulation
public class Book
{

	/*
	 * id of the book
	 */
	private int bookID; // has a id

	/**
	 * subject of the book
	 */
	private String subject; // has a subject

	/**
	 * title of the book
	 */
	private String title; // has a title

	/**
	 * author
	 */
	private String author; // has a author

	/**
	 * publisher
	 */
	private String publisher;// has a publisher

	/**
	 * copyright
	 */
	private String copyright; // has a copyright

	/**
	 * edition
	 */
	private int edition; // has a edition

	/**
	 * pages
	 */
	private int numPages; // has a number

	/**
	 * ISBN
	 */
	private String isbn; // has a ISBN

	/**
	 * total number of copies of the book
	 */
	private int totalCopies; // has a number of copies

	/**
	 * number of boo copies available
	 */
	private int availableCopies; // has a available of copies

	/**
	 * constructor
	 * 
	 * @param bookID
	 * @param subject
	 * @param title
	 * @param author
	 * @param publisher
	 * @param copyright
	 * @param edition
	 * @param numPages
	 * @param isbn
	 * @param totalCopies
	 * @param availableCopies
	 */
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
}
