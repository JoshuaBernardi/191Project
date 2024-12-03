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
 * Responsibilities of class: 
 *                            
 * 
 */
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
import javax.swing.SwingUtilities;
import model.Book;
import model.FileDatabase;


public class EditBookScreen extends JFrame 
{

	private JTextField txtSubject;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	

	 //Reference to main screen
	 
	private MainScreen mainScreen;
	
	//Reference to the book being edited
	
	private Book book;
	
	/**
	 * Constructor 
	 * @param mainScreen The main screen 
	 * @param book The book being edited
	 */
	
	public EditBookScreen(MainScreen mainScreen, Book book)
	{
		this.mainScreen = mainScreen;
		this.book = book;
		
		txtSubject = new JTextField(book.getSubject());
		txtTitle = new JTextField(book.getTitle());
		txtAuthor = new JTextField(book.getAuthor());
		txtPublisher = new JTextField(book.getPublisher());
		
		//buttons
		JButton btnSaveChanges = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10));
		
		pnlMain.add(new JLabel("Subject: "));
		pnlMain.add(txtSubject);
		
		pnlMain.add(new JLabel("Title: "));
		pnlMain.add(txtTitle);
		
		pnlMain.add(new JLabel("Author: "));
		pnlMain.add(txtAuthor);

		pnlMain.add(new JLabel("Publisher: "));
		pnlMain.add(txtPublisher);
		
		pnlMain.add(btnSaveChanges);
		pnlMain.add(btnCancel);
		
		//add action listeners for buttons
		btnSaveChanges.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				saveChanges();
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
		
		setTitle("Edit Book Screen");
		setSize(600, 600); //width and height of screen
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*
		 * Save changes to the book 
		 * 
		 */
		private void saveChanges()
		{
			String subject = txtSubject.getText();
			String title = txtTitle.getText();
			String author = txtAuthor.getText();
			String publisher = txtPublisher.getText();
			
			//updates the books fields with new data 
			book.setSubject(subject);
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublisher(publisher);
			
			//save the updated book to the data base
			FileDatabase db = FileDatabase.getDB();
			db.save();
			
			JOptionPane.showMessageDialog(this, "Book details updated successfully.");
			
			
			//close the screen and returns it to the main screen
			mainScreen.setVisible(true);
			dispose();
		}
}
	
}
