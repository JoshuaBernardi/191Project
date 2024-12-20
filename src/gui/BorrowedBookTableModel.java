/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This class supports the table component
 * to manage the list of the items in the table
 * such as the columns (can add, edit row...)
 * 
 * This GUI is a AbstractTableModel
 */
package gui;

import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Book;
import model.BorrowedBook;
import model.Configuration;

/**
 * this model is used to control the data part of the Jtable
 * to show books
 */
public class BorrowedBookTableModel extends AbstractTableModel
{
	/**
	 * column names
	 * 
	 * has a column names
	 * 
	 */
	private String[] columnNames = { "Member Name", "Book Title",
			"Borrowed Date", "Return Date", "Over Due" };

	/**
	 * reference to list of books
	 */
	private List<BorrowedBook> borrowedBooks; // has many borrowed books

	/**
	 * constructor
	 * 
	 * @param books list of borrowed books
	 */
	public BorrowedBookTableModel(List<BorrowedBook> borrowedBooks)
	{
		this.borrowedBooks = borrowedBooks;
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
		return borrowedBooks.size();
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

				val = borrowedBooks.get(row).getMemberName();
				break;
			case 1:
				val = borrowedBooks.get(row).getBookTitle();
				break;
			case 2:
				val = Configuration.sdf
						.format(borrowedBooks.get(row).getBorrowedDate());
				break;
			case 3:
				val = Configuration.sdf
						.format(borrowedBooks.get(row).getReturnedDate());
				break;
			case 4:
				if (borrowedBooks.get(row).isOverDue())
				{
					val = "Yes";
				}
				else
				{
					val = "No";
				}
				break;
			// TODO: ADD more case
			default:
				break;
		}
		return val;
	}

}
