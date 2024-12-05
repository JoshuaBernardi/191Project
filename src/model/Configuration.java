package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Configuration
{
	public static String BOOKS_FILENAME = "books.txt";
	public static String BORROWED_BOOKS_FILENAME = "borrowed_books.txt";
	public static String MEMBERS_FILENAME = "members.txt";
	public static String USERS_FILENAME = "users.txt";
	
	public static Date currentDate;
	
	static {
		currentDate = Calendar.getInstance().getTime();
	}

	/**
	 * Simple formatter to parse format date in MM/DD/YYYY
	 * where M is month, D is day and Y is year
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
}
