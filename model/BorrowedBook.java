package model;

import java.util.Date;

public class BorrowedBook
{

	private int userID;
	private int bookID;
	private Date borrowedDate;
	private Date returnedDate;
	
	public BorrowedBook(int userID, int bookID, Date borrowedDate,
			Date returnedDate)
	{
		this.userID = userID;
		this.bookID = bookID;
		this.borrowedDate = borrowedDate;
		this.returnedDate = returnedDate;
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
	
	
}
