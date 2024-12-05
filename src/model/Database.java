package model;

import java.util.List;

import exception.DataInvalidFormatException;

public abstract class Database
{
	/**
	 * list of books
	 */
	protected List<Book> books;
	
	/**
	 * list of users
	 */
	protected List<User> users;
	
	/**
	 * list of borrowed books
	 */
	protected List<BorrowedBook> borrowedBooks;
	
	/**
	 * list of members
	 */
	protected List<Member> members;
	
	/**
	 * @return the users
	 */
	public List<User> getUsers()
	{
		return users;
	}
	
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
	public abstract void initialize() throws DataInvalidFormatException;
	
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
	
	/**
	 * get book by id
	 * @param id book id
	 * @return Book or null if not found
	 */
	public Book getBookByID(int id) {
		
		for (Book book: books) {
			if (book.getBookID() == id) {
				return book;
			}
		}
		return null;
	}
	
	/**
	 * get member by id
	 * @param id member id
	 * @return Member or null if not found
	 */
	public Member getMemberByID(int id) {
		
		for (Member member: members) {
			if (member.getMemberID() == id) {
				return member;
			}
		}
		return null;
	}
}
