package model;

import java.util.List;

import exception.DataException;

public abstract class Database
{
	/**
	 * list of books
	 */
	protected List<Book> books;
	
	/**
	 * list of borrowed books
	 */
	protected List<BorrowedBook> borrowedBooks;
	
	/**
	 * list of members
	 */
	protected List<Member> members;
	
	/**
	 * @return the members
	 */
	public List<Member> getMembers()
	{
		return members;
	}

	/**
	 * list of the subjects
	 */
	protected String[] subjects;

	/**
	 * @return the subjects
	 */
	public String[] getSubjects()
	{
		return subjects;
	}

	/**
	 * @return the borrowedBooks
	 */
	public List<BorrowedBook> getBorrowedBooks()
	{
		return borrowedBooks;
	}

	/**
	 * initialize
	 */
	public abstract void initialize() throws DataException;
	
	/**
	 * save database
	 */
	public abstract void save();

	/**
	 * @return the books
	 */
	public List<Book> getBooks()
	{
		return books;
	}
	
	
}
