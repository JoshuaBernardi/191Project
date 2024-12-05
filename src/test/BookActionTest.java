/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Test the action on the book like overdue
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import model.BorrowedBook;
import model.Configuration;

class BookActionTest
{

	/**
	 * Test if the borrowed book is overdue
	 */
	@Test
	void testOverDue()
	{
		Calendar today = Calendar.getInstance();
		Configuration.currentDate = today.getTime();
		
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		
		BorrowedBook borrowedBook = new BorrowedBook(100, 1, "Join", "Sun", yesterday.getTime(), 
				yesterday.getTime(), "No");
		
		assertTrue(borrowedBook.isOverDue());
	}

	
	/**
	 * Test if the borrowed book is not overdue
	 */
	@Test
	void testNotYetOverDue()
	{
		Calendar today = Calendar.getInstance();
		Configuration.currentDate = today.getTime();
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		BorrowedBook borrowedBook = new BorrowedBook(100, 1, "Join", "Sun", today.getTime(), 
				tomorrow.getTime(), "No");
		
		assertFalse(borrowedBook.isOverDue());
	}

	
	/**
	 * Test if the returned date is equals the system date, borrowed book is not overdue
	 */
	@Test
	void testSameDateOverDue()
	{
		Calendar today = Calendar.getInstance();
		Configuration.currentDate = today.getTime();
		
		BorrowedBook borrowedBook = new BorrowedBook(100, 1, "Join", "Sun", today.getTime(), 
				today.getTime(), "No");
		
		assertFalse(borrowedBook.isOverDue());
	}
}
