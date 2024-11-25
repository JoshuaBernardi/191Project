package gui;
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame
{
	private JTextField txtBookID;
	private JTextField txtMemberID;
	private JTextField txtReturnDate;
	private JButton btnReturnBook;
	private JButton btnCancel;
	private MainScreen mainScreen;
	
	/*
	 * 
	 * 
	 */
	public ReturnBook(MainScreen mainScreen) {
		
		this.mainScreen = mainScreen;
		
		txtBookID = new JTextField(20);
		txtMemberID = new JTextField(20);
		txtReturnDate = new JTextField(20);
		
		btnReturnBook = new JButton("Return Book");
		btnCancel = new JButton("Cancel");
		
		//sets up panel and layout
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10));
		
		pnlMain.add(new JLabel("Book ID: "));
		pnlMain.add(txtBookID);
		
		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Return Date: "));
		pnlMain.add(txtReturnDate);
		
		pnlMain.add(btnReturnBook);
		pnlMain.add(btnCancel);
		
		
		//button actions
		btnReturnBook.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				returnBook();
			}
		});
		

		btnCancel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		//frame setup
		add(pnlMain);
		setTitle("Return Book");
		setSize (600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
	
	/*
	 * 
	 * 
	 */
	public void returnBook()
	{
		String bookID = txtBookID.getText();
		String memberID = txtMemberID.getText();
		String returnDate = txtReturnDate.getText();
		
		//
		if(bookID.isEmpty() || memberID.isEmpty() || returnDate.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill it in", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		boolean success = true;
		
		
		if(success) {
			JOptionPane.showMessageDialog(this, "Book returned successfully!\n" + "Book ID: " + bookID + "\n" + "Member ID: " + memberID + "\n" + 
		"Return Date: " + returnDate, "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "Failed to return the book. Please check the details." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//
		txtBookID.setText(" ");
		txtMemberID.setText(" ");
		txtReturnDate.setText(" ");
	
	}
	
	public static void main(String[] args) {
		
		MainScreen mainScreen = new MainScreen();
		ReturnBook returnBookScreen = new ReturnBook(mainScreen);
		returnBookScreen.setVisible(false);
	}
}	
