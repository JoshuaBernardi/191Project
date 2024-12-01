/**
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

import gui.MainScreen;
import model.Book;
import model.FileDatabase;
/**
 * 
 */
public class EditBookScreen extends JFrame{

	private JTextField txtSubject;
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPublisher;
	
	private MainScreen mainScreen;
	private Book book;
	
	/**
	 * @param args
	 */
	

	public EditBookScreen(MainScreen mainScreen, Book book)
	{
		this.mainScreen = mainScreen;
		this.book = book;
		
		//text fields with current book details
		txtSubject = new JTextField();
		txtTitle = new JTextField();
		txtAuthor = new JTextField();
		txtPublisher = new JTextField();
		
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
		
		btnSaveChanges.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveChanges();
			}
		});
		
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		add(pnlMain);
		
		setTitle("Edit Book Screen");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void saveChanges()
	{
		book.setSubject(txtSubject.getText());
		book.setTitle(txtTitle.getText());
		book.setAuthor(txtAuthor.getText());
		book.setPublisher(txtPublisher.getText());
		
		
		FileDatabase db = FileDatabase.getDB();
		db.save();
		
		JOptionPane.showMessageDialog(this, "Book details updated successfuly.");
		
		mainScreen.setVisible(true);
		setVisible(false);
	}
}
