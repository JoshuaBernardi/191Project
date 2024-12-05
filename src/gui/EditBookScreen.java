/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen allows user to edit book
 * The book must be existing.
 * 
 * User enters the id, the click search button,
 * The current book information will be filled
 * 
 * It is a JFrame
 */
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
public class EditBookScreen extends JFrame
{
	/**
	 * book is field
	 */
	private JTextField txtBookID; //has a book id field
	
	/**
	 * subject combo box
	 */
	private JComboBox<String> cboSubject; //has a subject field
	
	/**
	 * title field
	 */
	private JTextField txtTitle; //has a title field
	
	/**
	 * author field
	 */
	private JTextField txtAuthor; //has a author field
	
	/**
	 * publisher field
	 */
	private JTextField txtPublisher; //has a publisher field
	
	/**
	 * current book to edit
	 */
	private Book book = null; //has a book to edit
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; //has a reference to the main screen
	
	/**
	 * constructor
	 * @param mainScreen reference to the main screen
	 */
	public EditBookScreen(MainScreen mainScreen) {

		this.mainScreen = mainScreen;
		
		
		//TODO, add more fields
		cboSubject = new JComboBox<>(FileDatabase.getDB().getSubjects());
		txtTitle = new JTextField();
		txtAuthor = new JTextField();
		txtPublisher = new JTextField();
		
		txtBookID = new JTextField();
		
		JButton btnSearch = new JButton("Search");
		
		//buttons
		JButton btnAddBook = new JButton("Edit Book");
		JButton btnCancel = new JButton("Cancel");
		// first row subject, 2nd row title, 3rd row author, 4th row publisher, 5th row for add book and cancel
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(7, 2, 10, 10)); //TODO: add more columns
		
		//book id
		pnlMain.add(new JLabel("Book ID"));
		pnlMain.add(txtBookID);
		
		pnlMain.add(new JLabel());
		pnlMain.add(btnSearch);
		
		
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
				editBook();
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
		
		btnSearch.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchBook();
			}
		});
		
		add(pnlMain);		
		
		setTitle("Edit Book Screen");
		setSize(600, 600); //width and height of screen
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * search book
	 */
	private void searchBook() {
		
		int iBookID = 0;
		try {
			iBookID = Integer.parseInt(txtBookID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Book ID must be an integer number");
			return;
		}
		
		book = FileDatabase.getDB().getBookByID(iBookID);
		
		if (book == null) {
			JOptionPane.showMessageDialog(this, "Book with ID not found!");
		}else {
			txtAuthor.setText(book.getAuthor());
			txtPublisher.setText(book.getPublisher());
			txtTitle.setText(book.getTitle());
			
			for (int i = 0; i < FileDatabase.getDB().getSubjects().length; i++) {
				if (FileDatabase.getDB().getSubjects()[i].equals(book.getSubject())) {
					cboSubject.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	
	/**
	 * test github change 1
	 * edit book
	 */
	private void editBook() {
		
		if (book == null) {
			JOptionPane.showMessageDialog(this, "Please enter book ID to search");
			return;
		}
		
		String subject = (String)cboSubject.getSelectedItem();
		String title = txtTitle.getText();
		String author = txtAuthor.getText();
		String publisher = txtPublisher.getText();
		
		book.setSubject(subject);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		
		FileDatabase db = FileDatabase.getDB();
		db.save();
		
		JOptionPane.showMessageDialog(this, "Book has been edited successfully");
		
		//close this screen
		mainScreen.setVisible(true);
		setVisible(false);
		
	}
}
