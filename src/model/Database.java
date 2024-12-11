package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exception.DataInvalidFormatException;
import exception.DatabaseException;

/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Database is the super class.
 * The derived class can be FileDatabase, MySQLDatabase, OracleDatabase,...
 * 
 */
// LO1: abstract design
public abstract class Database // LO4: use abstract class
{
	/**
	 * list of books
	 * LO3: aggregation
	 * 
	 * LO5: data structure is List
	 */
	private List<Book> books; // has many books

	/**
	 * list of users
	 * LO3: aggregation
	 * 
	 * LO5: data structure is List
	 */
	private List<User> users; // has many users

	/**
	 * list of borrowed books
	 * LO3: aggregation
	 * 
	 * LO5: data structure is List
	 */
	private List<BorrowedBook> borrowedBooks; // has many borrowed books

	/**
	 * list of members
	 * LO3: aggregation
	 * 
	 * LO5: data structure is List
	 */
	private List<Member> members; // has many members

	/**
	 * default constructor
	 */
	public Database()
	{
		// LO5: books can be ArrayList, or LinkedList
		// example: users = new LinkedList<User>();

		users = new ArrayList<User>();
		books = new ArrayList<Book>();
		borrowedBooks = new ArrayList<BorrowedBook>();
		members = new ArrayList<Member>();

		// LO2: single array
		subjects = new String[] { "Math", "Science", "History", "Art",
				"Cooking", "Language", "Cars" };
	}

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
	private String[] subjects;

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
	public abstract void save() throws DatabaseException;

	/**
	 * @return the books
	 */
	public List<Book> getBooks()
	{
		return books;
	}

	/**
	 * get book by id
	 * 
	 * @param id book id
	 * @return Book or null if not found
	 */
	public Book getBookByID(int id)
	{

		for (Book book : books)
		{
			if (book.getBookID() == id)
			{
				return book;
			}
		}
		return null;
	}

	/**
	 * get member by id
	 * 
	 * @param id member id
	 * @return Member or null if not found
	 */
	public Member getMemberByID(int id)
	{

		for (Member member : members)
		{
			if (member.getMemberID() == id)
			{
				return member;
			}
		}
		return null;
	}
}
