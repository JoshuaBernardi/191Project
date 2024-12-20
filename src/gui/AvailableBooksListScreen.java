/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This GUI show the available books
 * It is a JFrame object
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
public class AvailableBooksListScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database; // has a reference to the database

	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen;// has a reference to the main screen

	/**
	 * constructor
	 * 
	 * @param mainScreen reference to the main screen
	 * @throws DatabaseException
	 */
	public AvailableBooksListScreen(MainScreen mainScreen)
			throws DatabaseException
	{

		this.mainScreen = mainScreen;

		setTitle("Library System - List of all available books");
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

		List<Book> allBooks = database.getBooks();
		List<BorrowedBook> borrowedBooks = database.getBorrowedBooks();

		List<Book> books = new ArrayList<Book>();

		for (Book b : allBooks)
		{

			boolean available = true;

			for (BorrowedBook bb : borrowedBooks)
			{
				if (bb.getBookID() == b.getBookID()
						&& bb.getReturned().equals("No"))
				{
					available = false;
				}
			}

			if (available)
			{
				books.add(b);
			}
		}

		BookTableModel model = new BookTableModel(books);
		JTable bookTable = new JTable(model);

		// create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(bookTable);
		;

		// put as the center
		add(centerPanel, BorderLayout.CENTER);
	}

}
