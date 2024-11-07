package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Book;
import model.FileDatabase;

@SuppressWarnings("serial")
public class AddBookScreen extends JFrame
{
	private JTextField txtSubject;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen;
	
	/**
	 * constructor
	 */
	public AddBookScreen(MainScreen mainScreen) {

		this.mainScreen = mainScreen;
		
		
		//TODO, add more fields
		txtSubject = new JTextField();
		txtTitle = new JTextField();
		txtAuthor = new JTextField();
		txtPublisher = new JTextField();
		
		//buttons
		JButton btnAddBook = new JButton("Add Book");
		JButton btnCancel = new JButton("Cancel");
		// first row subject, 2nd row title, 3rd row author, 4th row publisher, 5th row for add book and cancel
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10)); //TODO: add more columns
		
		pnlMain.add(new JLabel("Subject: "));
		pnlMain.add(txtSubject);
		
		pnlMain.add(new JLabel("Title: "));
		pnlMain.add(txtTitle);
		
		pnlMain.add(new JLabel("Author: "));
		pnlMain.add(txtAuthor);

		pnlMain.add(new JLabel("Publisher: "));
		pnlMain.add(txtPublisher);
		
		pnlMain.add(btnAddBook);
		pnlMain.add(btnCancel);
	
		//github 3
		
		//add action for button
		btnAddBook.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				addBook();
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
		
		setTitle("Add Book Screen");
		setSize(600, 600); //width and height of screen
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//comment
	/**
	 * add book
	 */
	private void addBook() {
		String subject = txtSubject.getText();
		String title = txtTitle.getText();
		String author = txtAuthor.getText();
		String publisher = txtPublisher.getText();
		
		Book book = new Book(200, subject, title, author, publisher, author, 0, 0, 
				"", 10, 10);
		
		FileDatabase db = FileDatabase.getDB();
		db.getBooks().add(book);
		
		db.save();
		
		JOptionPane.showMessageDialog(this, "Book has been added successfully");
		
		//close this screen
		mainScreen.setVisible(true);
		setVisible(false);
		
	}
}
