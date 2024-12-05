package model;
import java.util.Date;

/**
 * 
 * Class stores the book copy,
 * borrow date, due date...
 */
public class Borrow
{
	/**
	 * who borrows the copy (book)
	 */
	private Member member;
	
	/**
	 * due date
	 */
	private Date dueDate;
	
	/**
	 * borrowed book
	 */
	private Book book;
	
	
}
