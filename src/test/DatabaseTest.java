package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.DataException;
import model.BorrowedBook;
import model.Configuration;
import model.FileDatabase;

/**
 * Test the database like load, save, get, set
 */
public class DatabaseTest
{
	/**
	 * Test save, load borrowed book
	 */
	@Test
	void testValidBorrowedBook()
	{
		
		Calendar today = Calendar.getInstance();
		Configuration.currentDate = today.getTime();
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);
		
		BorrowedBook borrowedBook = new BorrowedBook(100, 1, "Join", "Sun", today.getTime(), 
				tomorrow.getTime(), "No");
		
		Configuration.BORROWED_BOOKS_FILENAME = "test_borrowed_books.txt";
		
		FileDatabase.getDB().getBorrowedBooks().add(borrowedBook);
		FileDatabase.getDB().save();
		
		
		try
		{
			FileDatabase.getDB().initialize();
		}
		catch (DataException e)
		{
			fail();
		} 

		assertEquals(1, FileDatabase.getDB().getBorrowedBooks().size());
		
		borrowedBook = FileDatabase.getDB().getBorrowedBooks().get(0);
		assertEquals(100, borrowedBook.getUserID());
		assertEquals(1, borrowedBook.getBookID());
		assertEquals("Join", borrowedBook.getMemberName());
		assertEquals("Sun", borrowedBook.getBookTitle());
		assertEquals(FileDatabase.sdf.format(today.getTime()), 
				FileDatabase.sdf.format(borrowedBook.getBorrowedDate()));
		assertEquals(FileDatabase.sdf.format(tomorrow.getTime()), 
				FileDatabase.sdf.format(borrowedBook.getReturnedDate()));
		assertEquals("No", borrowedBook.getReturned());
		
		File file = new File("test_books.txt");
		file.delete();
		
	}
}
