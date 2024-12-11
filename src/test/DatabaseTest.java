/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Test the database like load, save, get
 */
package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.DataInvalidFormatException;
import exception.DatabaseException;
import model.Book;
import model.BorrowedBook;
import model.Configuration;
import model.FileDatabase;
import model.Member;

/**
 * 
 */
public class DatabaseTest
{
	// This method is run before every method with @Test annotation
	@BeforeEach
	void initialize()
	{
		Configuration.BOOKS_FILENAME = "test_books.txt";
		Configuration.BORROWED_BOOKS_FILENAME = "test_borrowed_books.txt";
		Configuration.MEMBERS_FILENAME = "test_members.txt";
	}

	/**
	 * Test save, load, find member from database
	 */
	@Test
	void testMemberDB()
	{
		// simple member to test
		Member member = new Member(1, "@", "Tome", "123456789", "Main Street",
				"tome@gmail.com");

		try
		{
			FileDatabase.getDB().getMembers().clear();
			FileDatabase.getDB().getMembers().add(member);
			FileDatabase.getDB().save();
		}
		catch (DatabaseException e)
		{
			e.printStackTrace();
			fail();
		}

		try
		{
			FileDatabase.getDB().initialize();

			assertEquals(1, FileDatabase.getDB().getMembers().size());
			member = FileDatabase.getDB().getMemberByID(1);

			assertEquals("Tome", member.getName());
			assertEquals("123456789", member.getPhoneNumber());
			assertEquals("Main Street", member.getAddress());
			assertEquals("tome@gmail.com", member.getEmail());

			File file = new File(Configuration.MEMBERS_FILENAME);
			file.delete();
		}
		catch (DatabaseException e)
		{
			fail();
		}

	}

	/**
	 * Test save, load, find book from database
	 */
	@Test
	void testBookDB()
	{
		// simple book to test
		Book book = new Book(1, "Math", "Basic Math", "Dr Jone", "P", "2024", 0,
				0, "12569845", 0, 0);

		try
		{
			FileDatabase.getDB().getBooks().clear();
			FileDatabase.getDB().getBooks().add(book);
			FileDatabase.getDB().save();
		}
		catch (DatabaseException e)
		{
			fail();
		}

		try
		{
			FileDatabase.getDB().initialize();

			assertEquals(1, FileDatabase.getDB().getBooks().size());
			book = FileDatabase.getDB().getBookByID(1);

			assertEquals("Math", book.getSubject());
			assertEquals(1, book.getBookID());
			assertEquals("Basic Math", book.getTitle());
			assertEquals("Dr Jone", book.getAuthor());

			File file = new File(Configuration.BOOKS_FILENAME);
			file.delete();
		}
		catch (DatabaseException e)
		{
			fail();
		}

	}

	/**
	 * Test save, load borrowed book
	 */
	@Test
	void testBorrowedBookDB()
	{

		Calendar today = Calendar.getInstance();
		Configuration.currentDate = today.getTime();

		Calendar tomorrow = Calendar.getInstance();
		tomorrow.add(Calendar.DATE, 1);

		BorrowedBook borrowedBook = new BorrowedBook(100, 1, "Join", "Sun",
				today.getTime(), tomorrow.getTime(), "No");

		try
		{
			FileDatabase.getDB().getBorrowedBooks().clear();
			FileDatabase.getDB().getBorrowedBooks().add(borrowedBook);
			FileDatabase.getDB().save();
		}
		catch (DatabaseException e)
		{
			fail();
		}

		try
		{
			FileDatabase.getDB().initialize();
		}
		catch (DatabaseException e)
		{
			fail();
		}

		try
		{
			assertEquals(1, FileDatabase.getDB().getBorrowedBooks().size());

			borrowedBook = FileDatabase.getDB().getBorrowedBooks().get(0);
			assertEquals(100, borrowedBook.getUserID());
			assertEquals(1, borrowedBook.getBookID());
			assertEquals("Join", borrowedBook.getMemberName());
			assertEquals("Sun", borrowedBook.getBookTitle());
			assertEquals(Configuration.sdf.format(today.getTime()),
					Configuration.sdf.format(borrowedBook.getBorrowedDate()));
			assertEquals(Configuration.sdf.format(tomorrow.getTime()),
					Configuration.sdf.format(borrowedBook.getReturnedDate()));
			assertEquals("No", borrowedBook.getReturned());

			Path path = Paths.get(Configuration.BORROWED_BOOKS_FILENAME);
			Files.delete(path);
		}
		catch (IOException | DatabaseException e)
		{
			fail();
		}

	}
}
