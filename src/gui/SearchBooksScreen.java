/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen allows user to search book by
 * title, author, publisher base the key (substring)
 * 
 * This is a JFrame
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Book;
import model.Database;
import model.FileDatabase;

/**
 * This screen shows all books in the system
 */
@SuppressWarnings("serial")
public class SearchBooksScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database; //has a reference to the database
	
	/**
	 * key to search like the substring in author, title, publisher...
	 */
	private JTextField txtKey; //has a key field to search
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; //has a reference to the main screen
	
	/**
	 * constructor
	 * @param mainScreen reference to the main screen
	 */
	public SearchBooksScreen(MainScreen mainScreen) {
		
		this.mainScreen = mainScreen;
		
		setTitle("Library System - Search books");
		setSize(1000, 800);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		database = FileDatabase.getDB();
		
		setLayout(new BorderLayout());
		
		//show control
		showControl();
	}
	
	/**
	 * show control panel
	 */
	private void showControl() {
		
		JPanel topPanel = new JPanel(new GridLayout(1, 3));
		topPanel.add(new JLabel("Key: "));
		
		txtKey = new JTextField(100);
		topPanel.add(txtKey);
		
		JButton btnSearch = new JButton("Search");
		topPanel.add(btnSearch);
		
		add(topPanel, BorderLayout.NORTH);
		
		
		btnSearch.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchBooks();
			}
		});
		
		
		JButton btnBack = new JButton("Back");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(btnBack);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		//set action for button
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
	 * search show books on the screen
	 */
	public void searchBooks() {
		
				
		List<Book> allBooks = database.getBooks();
		List<Book> books = new ArrayList<Book>();
		
		String key = txtKey.getText();
		if (key.isEmpty()) {
			books = allBooks;
		}else {
			for (Book book: allBooks) {
				if (book.getAuthor().contains(key) || book.getTitle().contains(key) ||
						book.getPublisher().contains(key)) {
					books.add(book);
				}
			}
		}
		
		BookTableModel model = new BookTableModel(books);
		JTable bookTable = new JTable(model);
		
		//create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(bookTable);;
		
		//put as the center
		add(centerPanel, BorderLayout.CENTER);
		
		//to refresh the screen
		invalidate();
		validate();
	}

}
