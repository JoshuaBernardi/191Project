package gui;
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
 * Responsibilities of class: This class provides a screen for borrowing a book and allows users to input books and member details
 * 
 */
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


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BorrowBookScreen extends JFrame
{
	private JTextField txtBookID;
	private JTextField txtMemberID;
	private JTextField txtBorrowDate;
	private JTextField txtReturnDate;
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen;
	
	/**
	 * constructor
	 */
	public BorrowBookScreen(MainScreen mainScreen) {

		this.mainScreen = mainScreen;
		
		
		//TODO, add more fields
		txtBookID = new JTextField();
		txtMemberID = new JTextField();
		txtBorrowDate = new JTextField();
		txtReturnDate = new JTextField();
		
		//buttons
		JButton btnBorrowBook = new JButton("Borrow Book");
		JButton btnCancel = new JButton("Cancel");

		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10)); //TODO: add more columns
		
		pnlMain.add(new JLabel("Book ID: "));
		pnlMain.add(txtBookID);
		
		pnlMain.add(new JLabel("Member ID"));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Borrow Date: "));
		pnlMain.add(txtBorrowDate);

		pnlMain.add(new JLabel("Return Date: "));
		pnlMain.add(txtReturnDate);
		
		pnlMain.add(btnBorrowBook);
		pnlMain.add(btnCancel);
		
		
		//add action for button
		btnBorrowBook.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		//cancel button when user clicks button event cancel action is performed 
		btnCancel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainScreen.setVisible(true);
				dispose(); //free resource, close this screen
			}
		});
		
		add(pnlMain);		
		
		setTitle("Borrow Book Screen");
		setSize(600, 600); //width and height of screen
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
