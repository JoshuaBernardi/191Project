package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ReserveBookScreen extends JFrame
{
	private JTextField txtBookID;
	private JTextField txtMemberID;
	private JTextField txtReserveDate;
	private JButton btnReserveBook;
	private JButton btnCancel;
	private MainScreen mainScreen;
	
	
	/*
	 * 
	 * 
	 */
	public ReserveBookScreen(MainScreen mainScreen)
	{
		//
		txtBookID = new JTextField(20);
		txtMemberID = new JTextField(20);
		txtReserveDate = new JTextField(20);
		
		btnReserveBook = new JButton("Reserve Book");
		btnCancel = new JButton("Cancel");
		
		//
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(4, 2, 10, 10));
		
		pnlMain.add(new JLabel("Book ID: "));
		pnlMain.add(txtBookID);
		
		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Reserve Date: "));
		pnlMain.add(txtReserveDate);
		
		pnlMain.add(btnReserveBook);
		pnlMain.add(btnCancel);
		
		btnReserveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				reserveBook();
			}
		});
		
		//
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		//
		add(pnlMain);
		setTitle("Reserve Book");
		setSize (600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * 
	 * 
	 */
	public void reserveBook() {
		
		String bookID = txtBookID.getText();
		String memberID = txtMemberID.getText();
		String reserveDate = txtReserveDate.getText();
		
		//
		if(bookID.isEmpty() || memberID.isEmpty() || reserveDate.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill it in", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		boolean success = true;
		
		if(success) {
			JOptionPane.showMessageDialog(this, "Book reserved successfully!\n" + "Book ID: " + bookID + "\n" + "Member ID: " + memberID + "\n" + 
		"Reserve Date: " + reserveDate, "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "Failed to reserve the book. Please check the details." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//
		txtBookID.setText(" ");
		txtMemberID.setText(" ");
		txtReserveDate.setText(" ");
	}
	
	/*
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		MainScreen mainScreen = new MainScreen();
		ReserveBookScreen reserveBookScreen = new ReserveBookScreen(mainScreen);
		reserveBookScreen.setVisible(false);
	}
}
