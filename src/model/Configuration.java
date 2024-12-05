/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This class stores the file names that store books, members...
 * 
 * It also stores the system date
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Configuration
{
	/**
	 * books file name
	 */
	public static String BOOKS_FILENAME = "books.txt";
	
	/**
	 * borrowed books file name
	 */
	public static String BORROWED_BOOKS_FILENAME = "borrowed_books.txt";
	
	/**
	 * members file name
	 */
	public static String MEMBERS_FILENAME = "members.txt";
	
	/**
	 * users file name
	 */
	public static String USERS_FILENAME = "users.txt";
	
	/**
	 * current date of the system
	 */
	public static Date currentDate;
	
	//set as current date
	static {
		currentDate = Calendar.getInstance().getTime();
	}

	/**
	 * Simple formatter to parse format date in MM/DD/YYYY
	 * where M is month, D is day and Y is year
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
}
