package model;

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
}
