package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDatabase extends Database
{
	
	/**
	 * unique database object
	 * 
	 * singleton design pattern
	 * that allows to use ONE instance of FileDatabase in the whole system
	 */
	private static  FileDatabase db;

	@Override
	public void initialize()
	{
		// read files
		books = new ArrayList<Book>();
		
		
		//will load from books.txt
		try
		{
			Scanner scanner = new Scanner(new File("books.txt"));
			
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
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void save()
	{
		// save files
		try
		{
			FileWriter writer = new FileWriter("books.txt");
			
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
			db.initialize();
		}
		
		return db;
	}

}
