package gui;
/*
 * Lead Author(s):
 * @author Zalma Farah
 * @author Joshua Bernardi
 * * <<add additional lead authors here, with a full first and last name>>
 * 
 *  Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 * 
 * Version/date: 12/2/2024
 * Responsibilities of class: This class provides a table for displaying books in the data in a JTable including the 
 *                            Book ID, Subject, Title, and Publisher
 * 
 */
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Book;

/**
 * this model is used to control the data part of the JTable
 * to show books
 */
public class BookTableModel extends AbstractTableModel
{
	/**
	 * column names
	 * 
	 * TODO: add more columns
	 * 
	 */
	private String[] columnNames = {"Book ID", "Subject", "Title", "Publisher"};
	
	/**
	 * reference to list of books
	 */
	private List<Book> books;
	
	/**
	 * constructor
	 * @param books
	 */
	public BookTableModel(List<Book> books)
	{
		this.books = books;
	}

	@Override
	/**
	 * return the number of columns
	 */
	public int getColumnCount()
	{
		return columnNames.length;
	}
	
	@Override
	/**
	 * get the name of the column [column]
	 */
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	@Override
	/**
	 * get the number of rows in table
	 */
	public int getRowCount()
	{
		return books.size();
	}

	@Override
	/**
	 * show the value at row and column of the table
	 */
	public Object getValueAt(int row, int col)
	{
		Object val = null;
		
		switch (col)
		{
			case 0:
				
				val = books.get(row).getBookID();
				break;
			case 1:
				val = books.get(row).getSubject();
				break;
			case 2:
				val = books.get(row).getTitle();
				break;
			case 3:
				val = books.get(row).getPublisher();
				break;
			//TODO: ADD more case
			default:
				break;
		}
		return val;
	}

}
