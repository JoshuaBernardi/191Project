package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Book;

/**
 * this model is used to control the data part of the Jtable
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
