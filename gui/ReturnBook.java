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
 * Responsibilities of class: This class provides a GUI for returning a book, including fields such as book ID, member ID, and
 *                            the return date
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
	 * @param
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
	 * @param
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
	
	/*
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		MainScreen mainScreen = new MainScreen();
		ReturnBook returnBookScreen = new ReturnBook(mainScreen);
		returnBookScreen.setVisible(false);
	}
}	
