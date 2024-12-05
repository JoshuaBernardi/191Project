package model;

import java.util.Date;

public class BorrowedBook
{

	private int userID;
	private int bookID;
	
	private String memberName;
	private String bookTitle;	
	
	private Date borrowedDate;
	private Date returnedDate;
	
	private String returned; // Yes or No (if the book has been returned)
	public BorrowedBook(int userID, int bookID, String memberName,
			String bookTitle, Date borrowedDate, Date returnedDate,
			String returned)
	{
		super();
		this.userID = userID;
		this.bookID = bookID;
		this.memberName = memberName;
		this.bookTitle = bookTitle;
		this.borrowedDate = borrowedDate;
		this.returnedDate = returnedDate;
		this.returned = returned;
	}
	/**
	 * @return the userID
	 */
	public int getUserID()
	{
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID)
	{
		this.userID = userID;
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
	 * @return the memberName
	 */
	public String getMemberName()
	{
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName)
	{
		this.memberName = memberName;
	}
	/**
	 * @return the bookTitle
	 */
	public String getBookTitle()
	{
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}
	/**
	 * @return the borrowedDate
	 */
	public Date getBorrowedDate()
	{
		return borrowedDate;
	}
	/**
	 * @param borrowedDate the borrowedDate to set
	 */
	public void setBorrowedDate(Date borrowedDate)
	{
		this.borrowedDate = borrowedDate;
	}
	/**
	 * @return the returnedDate
	 */
	public Date getReturnedDate()
	{
		return returnedDate;
	}
	/**
	 * @param returnedDate the returnedDate to set
	 */
	public void setReturnedDate(Date returnedDate)
	{
		this.returnedDate = returnedDate;
	}
	/**
	 * @return the returned
	 */
	public String getReturned()
	{
		return returned;
	}
	/**
	 * @param returned the returned to set
	 */
	public void setReturned(String returned)
	{
		this.returned = returned;
	}
	
	
	
}
