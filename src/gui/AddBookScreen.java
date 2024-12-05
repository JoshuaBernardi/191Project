package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	private JComboBox<String> cboSubject;
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
		cboSubject = new JComboBox<>(FileDatabase.getDB().getSubjects());
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
		pnlMain.add(cboSubject);
		
		pnlMain.add(new JLabel("Title: "));
		pnlMain.add(txtTitle);
		
		pnlMain.add(new JLabel("Author: "));
		pnlMain.add(txtAuthor);

		pnlMain.add(new JLabel("Publisher: "));
		pnlMain.add(txtPublisher);
		
		pnlMain.add(btnAddBook);
		pnlMain.add(btnCancel);
	
		//github 5
		
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
	/**test github change 1
	 * add book
	 */
	private void addBook() {
		String subject = (String)cboSubject.getSelectedItem();
		String title = txtTitle.getText();
		String author = txtAuthor.getText();
		String publisher = txtPublisher.getText();
		
		int bookID = 0;
		for (Book book : FileDatabase.getDB().getBooks()) {
			if (book.getBookID() > bookID) {
				bookID = book.getBookID();
			}
		}
		bookID += 1;
		
		Book book = new Book(bookID, subject, title, author, publisher, author, 0, 0, 
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
