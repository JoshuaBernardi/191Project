package gui;

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
