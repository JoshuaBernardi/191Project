package model;

import java.util.List;

public abstract class Database
{
	/**
	 * list of books
	 */
	protected List<Book> books;

	/**
	 * initialize
	 */
	public abstract void initialize();
	
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
