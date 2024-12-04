package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.BorrowedBook;
import model.FileDatabase;

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
				borrow();
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
	
	private void borrow() {
		
		String bookID = txtBookID.getText();
		String memberID = txtMemberID.getText();
		String borrowedDate  = txtBorrowDate.getText();
		String returnDate = txtReturnDate.getText();
		
		//validate input
		if(bookID.isEmpty() || memberID.isEmpty() || borrowedDate.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill it in", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		boolean success = true;
		
		
		int iMemberID = 0;
		try {
			iMemberID = Integer.parseInt(memberID);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Member ID must be an integer number");
			return;
		}
		
		int iBookID = 0;
		try {
			iBookID = Integer.parseInt(bookID);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Book ID must be an integer number");
			return;
		}
		
		Date dBorrowedDate = null;
		try {
			dBorrowedDate = FileDatabase.sdf.parse(borrowedDate);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Borrowed Date must be in MM/DD/YYYY format");
			return;
		}
		
		Date dReturnedDate = null;
		
		FileDatabase.getDB().getBorrowedBooks().add(new BorrowedBook(iMemberID, iBookID, 
				dBorrowedDate, dReturnedDate));
		FileDatabase.getDB().save();
		
		//
		if(success) {
			JOptionPane.showMessageDialog(this, "Book borrowed successfully!\n", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "Failed to borrow the book. Please check the details." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//reset
		txtBookID.setText(" ");
		txtMemberID.setText(" ");
		txtBorrowDate.setText("");
		txtReturnDate.setText(" ");
	}
}
