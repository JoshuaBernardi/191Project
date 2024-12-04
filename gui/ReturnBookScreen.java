package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JCalendar;

import model.Book;
import model.BorrowedBook;
import model.Configuration;
import model.FileDatabase;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReturnBookScreen extends JFrame
{
	private JTextField txtBookID;
	private JTextField txtMemberID;
	private JCalendar calReturnDate;
	private JButton btnReturnBook;
	private JButton btnCancel;
	private MainScreen mainScreen;
	private JLabel lblReturnDate;
	
	/*
	 * 
	 * 
	 */
	public ReturnBookScreen(MainScreen mainScreen) {
		
		this.mainScreen = mainScreen;
		
		txtBookID = new JTextField(20);
		txtMemberID = new JTextField(20);
		calReturnDate = new JCalendar();
		
		calReturnDate.setDate(Configuration.currentDate);
		
		calReturnDate.addPropertyChangeListener(new PropertyChangeListener()
		{
			
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				lblReturnDate.setText(FileDatabase.sdf.format(calReturnDate.getDate()));
			}
		});
		
		btnReturnBook = new JButton("Return Book");
		btnCancel = new JButton("Cancel");
		lblReturnDate = new JLabel();
		
		//
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(6, 2, 10, 10));
		
		pnlMain.add(new JLabel("Book ID: "));
		pnlMain.add(txtBookID);
		
		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Return Date: "));
		pnlMain.add(calReturnDate);
		
		pnlMain.add(new JLabel());
		pnlMain.add(lblReturnDate);
		
		pnlMain.add(btnReturnBook);
		pnlMain.add(btnCancel);
		
		btnReturnBook.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				returnBook();
			}
		});
		
		//
		btnCancel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		//
		add(pnlMain);
		setTitle("Return Book");
		setSize (600,800);
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
		
		//
		if(bookID.isEmpty() || memberID.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill it in", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//check if book was borrowed
		Book book = null;
		BorrowedBook borrowedBook = null;
		
		int iBookID = 0;
		try {
			iBookID = Integer.parseInt(txtBookID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Book ID must be an integer number");
			return;
		}
		
		
		for (Book b: FileDatabase.getDB().getBooks()) {
			if (b.getBookID() == iBookID) {
				book = b;
				break;
			}
		}
		
		if (book == null) {
			JOptionPane.showMessageDialog(this, "Book with ID not found!");
			return;
		}
		
		//search book in borrowed books list
		for (BorrowedBook bBook: FileDatabase.getDB().getBorrowedBooks()) {
			if (bBook.getBookID() == iBookID) {
				borrowedBook = bBook;
				break;
			}
		}
		
		if (borrowedBook == null) {
			JOptionPane.showMessageDialog(this, "Book has not yet been borrowed!");
			return;
		}
		
		Date dReturnedDate = calReturnDate.getDate();
		
		//remove borrowed book list
		borrowedBook.setReturnedDate(dReturnedDate);
		FileDatabase.getDB().save();
		
		boolean success = true;
		
		//
		if(success) {
			JOptionPane.showMessageDialog(this, "Book returned successfully!\n", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "Failed to return the book. Please check the details." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//close this screen
		mainScreen.setVisible(true);
		setVisible(false);
	
	}
}	
