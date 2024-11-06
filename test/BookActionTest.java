package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import model.Book;

class BookActionTest
{

	@Test
	void testBorrow()
	{
		Book book = new Book(1, null, null, null, null, null, 0, 0, null, 10, 10);
		book.checkOut(Calendar.getInstance().getTime());
		
		assertEquals(9, book.getAvailableCopies());
	}

	//TODO: add more test, return, reserve, edit, add book...
}
