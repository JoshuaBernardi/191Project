package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import exception.DataInvalidFormatException;

/**
 * Author: Joshua Bernardi, Zalma Farah
 * The FileDatabase manages the data for the program.
 * It stores data in text file
 * 
 * FileDatabase is-a Database
 */
public class FileDatabase extends Database
{
	
	/**
	 * unique database object
	 * 
	 * singleton design pattern
	 * that allows to use ONE instance of FileDatabase in the whole system
	 */
	private static  FileDatabase db;  //has a static object

	@Override
	public void initialize() throws DataInvalidFormatException
	{
		// read files
		books = new ArrayList<Book>();
		
		
		//will load from books.txt
		try
		{
			Scanner scanner = new Scanner(new File(Configuration.BOOKS_FILENAME));
			
			while (scanner.hasNext()) {
				
				String line = scanner.nextLine();
				String[] data = line.split(";");
				
				Book book = new Book(Integer.parseInt(data[0]), 
						data[1], data[2], data[3], data[4], data[5],
						Integer.parseInt(data[6]), 
						Integer.parseInt(data[7]), 
						data[8], 
						Integer.parseInt(data[9]), 
						Integer.parseInt(data[10]));
				
				books.add(book);
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		
		
		borrowedBooks = new ArrayList<>();
		
		
		//will load from borrowed books.txt
		try
		{
			Scanner scanner = new Scanner(new File(Configuration.BORROWED_BOOKS_FILENAME));
			
			while (scanner.hasNext()) {
				
				String line = scanner.nextLine();
				String[] data = line.split(";");
				
				//user id, book id, borrowed date, return date
				try
				{
					BorrowedBook bb = new BorrowedBook(Integer.parseInt(data[0]), 
							Integer.parseInt(data[1]), data[2], data[3],
							Configuration.sdf.parse(data[4]), Configuration.sdf.parse(data[5]), data[6]);
					
					borrowedBooks.add(bb);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		
		subjects = new String[]{"Math", "Science", "History", "Art", "Cooking", "Language", "Cars"};
		
		members = new ArrayList<Member>();
		
		//will load from members.txt
		try
		{
			Scanner scanner = new Scanner(new File(Configuration.MEMBERS_FILENAME));
			
			while (scanner.hasNext()) {
				
				String line = scanner.nextLine();
				String[] data = line.split(";");
				
				//member id, pass, name, phone, address, email
				try
				{
					Member member = new Member(Integer.parseInt(data[0])
										, data[1], data[2], data[3], data[4], data[5]);
					members.add(member);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		
		users = new ArrayList<User>();
		
		//will load from members.txt
		try
		{
			Scanner scanner = new Scanner(new File(Configuration.USERS_FILENAME));
			
			while (scanner.hasNext()) {
				
				String line = scanner.nextLine();
				String[] data = line.split(";");
				
				//user id, pass
				try
				{
					User user = new User(data[0], data[1]);
					users.add(user);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}
			
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			//e.printStackTrace();
		}
		
	}

	@Override
	public void save()
	{
		// save files
		try
		{
			FileWriter writer = new FileWriter(Configuration.BOOKS_FILENAME);
			
			for (Book book: books) {
				writer.write(String.valueOf(book.getBookID()));
				writer.write(";");
				writer.write(book.getSubject());
				writer.write(";");
				writer.write(book.getTitle());
				writer.write(";");
				writer.write(book.getAuthor());
				writer.write(";");
				writer.write(book.getPublisher());
				writer.write(";");
				writer.write(book.getCopyright());
				writer.write(";");
				writer.write(String.valueOf(book.getEdition()));
				writer.write(";");
				writer.write(String.valueOf(book.getNumPages()));
				writer.write(";");
				writer.write(book.getIsbn());
				writer.write(";");
				writer.write(String.valueOf(book.getTotalCopies()));
				writer.write(";");
				writer.write(String.valueOf(book.getAvailableCopies()));
				
				writer.write(System.lineSeparator());
				
			}
			writer.close();
			
			
			writer = new FileWriter(Configuration.BORROWED_BOOKS_FILENAME);
			
			for (BorrowedBook borrowedBook: borrowedBooks) {
				writer.write(String.valueOf(borrowedBook.getUserID()));
				writer.write(";");
				writer.write(String.valueOf(borrowedBook.getBookID()));
				writer.write(";");
				writer.write(borrowedBook.getMemberName());
				writer.write(";");
				writer.write(borrowedBook.getBookTitle());
				writer.write(";");
				writer.write(Configuration.sdf.format(borrowedBook.getBorrowedDate()));
				writer.write(";");
				writer.write(Configuration.sdf.format(borrowedBook.getReturnedDate()));
				writer.write(";");
				writer.write(borrowedBook.getReturned());
				
				writer.write(System.lineSeparator());
				
			}
			writer.close();
			
			writer = new FileWriter(Configuration.MEMBERS_FILENAME);
			
			for (Member member: members) {
				writer.write(String.valueOf(member.getMemberID()));
				writer.write(";");
				writer.write(member.getPassword());
				writer.write(";");
				writer.write(member.getName());
				writer.write(";");
				writer.write(member.getPhoneNumber());
				writer.write(";");
				writer.write(member.getAddress());
				writer.write(";");
				writer.write(member.getEmail());
				
				writer.write(System.lineSeparator());
				
			}
			writer.close();
		
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * get unique instance of the database
	 * @return database
	 */
	public static FileDatabase getDB() {
		if (db == null) {
			db = new FileDatabase();
			try
			{
				db.initialize();
			}
			catch (DataInvalidFormatException e)
			{
				e.printStackTrace();
			}
		}
		
		return db;
	}

}
