/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen shows the list of borrowed books
 * 
 * It is a JFrame
 */
package gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import exception.DatabaseException;
import model.Book;
import model.BorrowedBook;
import model.Database;
import model.FileDatabase;

/**
 * This screen shows all books in the system
 */
@SuppressWarnings("serial")
public class BorrowedBooksListScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database; // has a database

	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; // has a reference to main screen

	/**
	 * constructor
	 * 
	 * @throws DatabaseException
	 */
	public BorrowedBooksListScreen(MainScreen mainScreen)
			throws DatabaseException
	{

		this.mainScreen = mainScreen;

		setTitle("Library System - List of all borrowed books");
		setSize(1000, 800);
		setLocationRelativeTo(null); // center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		database = FileDatabase.getDB();

		// show books
		showBooks();

		// show control
		showControl();
	}

	/**
	 * show control panel
	 */
	private void showControl()
	{

		JButton btnBack = new JButton("Back");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(btnBack);

		add(bottomPanel, BorderLayout.SOUTH);

		// set action for button
		btnBack.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				mainScreen.setVisible(true);
			}
		});
	}

	/**
	 * show books on the screen
	 */
	public void showBooks()
	{

		setLayout(new BorderLayout());

		List<BorrowedBook> allBorrowedBooks = database.getBorrowedBooks();
		List<BorrowedBook> borrowedBooks = new ArrayList<BorrowedBook>();

		for (BorrowedBook b : allBorrowedBooks)
		{
			if (b.getReturned().equals("No"))
			{
				borrowedBooks.add(b);
			}
		}

		BorrowedBookTableModel model = new BorrowedBookTableModel(
				borrowedBooks);
		JTable bookTable = new JTable(model);

		// create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(bookTable);
		;

		// put as the center
		add(centerPanel, BorderLayout.CENTER);
	}

}
