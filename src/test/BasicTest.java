package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import model.BorrowedBook;
import model.Configuration;

/**
 * Test the constructor, methods in the the model package
 */
public class BasicTest
{
	/**
	 * Test if the borrowed book is created successfully
	 */
	@Test
	void testValidBorrowedBook()
	{
		try {
			Calendar today = Calendar.getInstance();
			Configuration.currentDate = today.getTime();
			
			Calendar tomorrow = Calendar.getInstance();
			tomorrow.add(Calendar.DATE, 1);
			
			new BorrowedBook(100, 1, "Join", "Sun", today.getTime(), 
					tomorrow.getTime(), "No");
		}catch(Exception e) {
			fail();
		}
	}
	
	/**
	 * Test if the borrowed book is not created successfully
	 */
	@Test
	void testInvalidBorroweddBook()
	{
		IllegalArgumentException thrown = assertThrows(
				IllegalArgumentException.class,
				
				() ->{
					Calendar today = Calendar.getInstance();
					Configuration.currentDate = today.getTime();
					
					Calendar tomorrow = Calendar.getInstance();
					tomorrow.add(Calendar.DATE, 1);
					
					//the returned date is before the borrowed date
					new BorrowedBook(100, 1, "Join", "Sun", tomorrow.getTime(), 
							today.getTime(), "No");
				}
		);
		
		assertTrue(thrown.getMessage().contains("Error"));
		
		
	}
}
