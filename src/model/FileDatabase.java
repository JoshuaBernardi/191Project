package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import exception.DataInvalidFormatException;
import exception.DatabaseException;

/**
 * Author: Joshua Bernardi, Zalma Farah
 * The FileDatabase manages the data for the program.
 * It stores data in text file
 * 
 * FileDatabase is-a Database
 */
// LO1: inheritance
public class FileDatabase extends Database
// LO4, this class inherits the books, users from super class Database

{

	/**
	 * unique database object
	 * 
	 * singleton design pattern
	 * that allows to use ONE instance of FileDatabase in the whole system
	 */
	private static FileDatabase db; // has a static object
	// LO8: read from file text I/O

	@Override
	public void initialize() throws DataInvalidFormatException
	{
		// reset
		getMembers().clear();
		getUsers().clear();
		getBooks().clear();
		getBorrowedBooks().clear();

		// read files

		// will load from books.txt
		Scanner bookScanner = null;
		try
		{
			bookScanner = new Scanner(new File(Configuration.BOOKS_FILENAME));

			while (bookScanner.hasNext())
			{

				String line = bookScanner.nextLine();
				String[] data = line.split(";");

				Book book = new Book(Integer.parseInt(data[0]), data[1],
						data[2], data[3], data[4], data[5],
						Integer.parseInt(data[6]), Integer.parseInt(data[7]),
						data[8], Integer.parseInt(data[9]),
						Integer.parseInt(data[10]));

				getBooks().add(book);
			}

		}
		catch (FileNotFoundException e)
		{
			// ignore
		}
		finally
		{
			if (bookScanner != null)
			{
				bookScanner.close();
			}
		}

		// will load from borrowed books.txt
		Scanner borrowedBookScanner = null;
		try
		{
			borrowedBookScanner = new Scanner(
					new File(Configuration.BORROWED_BOOKS_FILENAME));

			while (borrowedBookScanner.hasNext())
			{

				String line = borrowedBookScanner.nextLine();
				String[] data = line.split(";");

				// user id, book id, borrowed date, return date
				try
				{
					BorrowedBook bb = new BorrowedBook(
							Integer.parseInt(data[0]),
							Integer.parseInt(data[1]), data[2], data[3],
							Configuration.sdf.parse(data[4]),
							Configuration.sdf.parse(data[5]), data[6]);

					getBorrowedBooks().add(bb);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}
		}
		catch (FileNotFoundException e)
		{
			// ignore it
		}
		finally
		{
			if (borrowedBookScanner != null)
			{
				borrowedBookScanner.close();
			}
		}

		// will load from members.txt
		Scanner memberScanner = null;
		try
		{
			memberScanner = new Scanner(
					new File(Configuration.MEMBERS_FILENAME));

			while (memberScanner.hasNext())
			{

				String line = memberScanner.nextLine();
				String[] data = line.split(";");

				// member id, pass, name, phone, address, email
				try
				{
					Member member = new Member(Integer.parseInt(data[0]),
							data[1], data[2], data[3], data[4], data[5]);
					getMembers().add(member);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}

		}
		catch (FileNotFoundException e)
		{
			// ignore
		}
		finally
		{
			if (memberScanner != null)
			{
				memberScanner.close();
			}
		}

		// will load from members.txt
		Scanner userScanner = null;
		try
		{
			userScanner = new Scanner(new File(Configuration.USERS_FILENAME));

			while (userScanner.hasNext())
			{

				String line = userScanner.nextLine();
				String[] data = line.split(";");

				// user id, pass
				try
				{
					User user = new User(data[0], data[1]);
					getUsers().add(user);
				}
				catch (Exception e)
				{
					throw new DataInvalidFormatException();
				}
			}

			userScanner.close();
		}
		catch (FileNotFoundException e)
		{
			// ignore
		}
		finally
		{
			if (userScanner != null)
			{
				userScanner.close();
			}
		}

	}
	// LO8: read from file text I/O

	@Override
	public void save() throws DatabaseException
	{
		// save files
		FileWriter bookWriter = null;
		try
		{
			bookWriter = new FileWriter(Configuration.BOOKS_FILENAME);

			for (Book book : getBooks())
			{
				bookWriter.write(String.valueOf(book.getBookID()));
				bookWriter.write(";");
				bookWriter.write(book.getSubject());
				bookWriter.write(";");
				bookWriter.write(book.getTitle());
				bookWriter.write(";");
				bookWriter.write(book.getAuthor());
				bookWriter.write(";");
				bookWriter.write(book.getPublisher());
				bookWriter.write(";");
				bookWriter.write(book.getCopyright());
				bookWriter.write(";");
				bookWriter.write(String.valueOf(book.getEdition()));
				bookWriter.write(";");
				bookWriter.write(String.valueOf(book.getNumPages()));
				bookWriter.write(";");
				bookWriter.write(book.getIsbn());
				bookWriter.write(";");
				bookWriter.write(String.valueOf(book.getTotalCopies()));
				bookWriter.write(";");
				bookWriter.write(String.valueOf(book.getAvailableCopies()));

				bookWriter.write(System.lineSeparator());

			}
		}
		catch (IOException e)
		{
			throw new DatabaseException();
		}
		finally
		{
			if (bookWriter != null)
			{
				try
				{
					bookWriter.close();
				}
				catch (IOException e)
				{
					throw new DatabaseException();
				}
			}
		}

		FileWriter borrowedBookWriter = null;
		try
		{
			borrowedBookWriter = new FileWriter(
					Configuration.BORROWED_BOOKS_FILENAME);

			for (BorrowedBook borrowedBook : getBorrowedBooks())
			{
				borrowedBookWriter
						.write(String.valueOf(borrowedBook.getUserID()));
				borrowedBookWriter.write(";");
				borrowedBookWriter
						.write(String.valueOf(borrowedBook.getBookID()));
				borrowedBookWriter.write(";");
				borrowedBookWriter.write(borrowedBook.getMemberName());
				borrowedBookWriter.write(";");
				borrowedBookWriter.write(borrowedBook.getBookTitle());
				borrowedBookWriter.write(";");
				borrowedBookWriter.write(Configuration.sdf
						.format(borrowedBook.getBorrowedDate()));
				borrowedBookWriter.write(";");
				borrowedBookWriter.write(Configuration.sdf
						.format(borrowedBook.getReturnedDate()));
				borrowedBookWriter.write(";");
				borrowedBookWriter.write(borrowedBook.getReturned());

				borrowedBookWriter.write(System.lineSeparator());

			}
		}
		catch (IOException e)
		{
			throw new DatabaseException();
		}
		finally
		{
			if (borrowedBookWriter != null)
			{
				try
				{
					borrowedBookWriter.close();
				}
				catch (IOException e)
				{
					throw new DatabaseException();
				}
			}
		}

		FileWriter memberWriter = null;
		try
		{
			memberWriter = new FileWriter(Configuration.MEMBERS_FILENAME);

			for (Member member : getMembers())
			{
				memberWriter.write(String.valueOf(member.getMemberID()));
				memberWriter.write(";");
				memberWriter.write(member.getPassword());
				memberWriter.write(";");
				memberWriter.write(member.getName());
				memberWriter.write(";");
				memberWriter.write(member.getPhoneNumber());
				memberWriter.write(";");
				memberWriter.write(member.getAddress());
				memberWriter.write(";");
				memberWriter.write(member.getEmail());

				memberWriter.write(System.lineSeparator());

			}

		}
		catch (IOException e)
		{
			throw new DatabaseException();
		}
		finally
		{
			if (memberWriter != null)
			{
				try
				{
					memberWriter.close();
				}
				catch (IOException e)
				{
					throw new DatabaseException();
				}
			}
		}
	}

	/**
	 * get unique instance of the database
	 * 
	 * @return database
	 */
	public static FileDatabase getDB() throws DatabaseException
	{
		if (db == null)
		{
			db = new FileDatabase();
			db.initialize();
		}

		return db;
	}

}
