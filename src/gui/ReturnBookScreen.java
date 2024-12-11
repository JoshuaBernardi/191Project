/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen allows user to return the book
 * 
 * It is a JFrame
 */
package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.JCalendar;

import exception.DatabaseException;
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

@SuppressWarnings("serial")
public class ReturnBookScreen extends JFrame
{
	/**
	 * book id field
	 */
	private JTextField txtBookID; // has a book id field

	/**
	 * member if field
	 */
	private JTextField txtMemberID; // has a member id field

	/**
	 * return date calendar
	 */
	private JCalendar calReturnDate; // has a return date field

	/**
	 * button to return book
	 */
	private JButton btnReturnBook; // has a return book field

	/**
	 * cancel button
	 */
	private JButton btnCancel; // has a cancel button

	/**
	 * reference to the main screen
	 */
	private MainScreen mainScreen; // has a reference to the main screen

	/**
	 * return date label
	 */
	private JLabel lblReturnDate; // has a return date label

	/**
	 * constructor
	 * 
	 * @param mainScreen reference to the main screen
	 */
	public ReturnBookScreen(MainScreen mainScreen)
	{

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
				lblReturnDate.setText(
						Configuration.sdf.format(calReturnDate.getDate()));
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

		btnReturnBook.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				try
				{
					returnBook();
				}
				catch (DatabaseException e1)
				{
					JOptionPane.showMessageDialog(null,
							"Database error! Contact the administration for help");
				}
			}
		});

		//
		btnCancel.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{

				mainScreen.setVisible(true);
				dispose();
			}
		});

		//
		add(pnlMain);
		setTitle("Return Book");
		setSize(600, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * return book
	 * 
	 * @throws DatabaseException
	 */
	public void returnBook() throws DatabaseException
	{
		String bookID = txtBookID.getText();
		String memberID = txtMemberID.getText();

		//
		if (bookID.isEmpty() || memberID.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please fill it in", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// check if book was borrowed
		Book book = null;
		BorrowedBook borrowedBook = null;

		int iBookID = 0;
		try
		{
			iBookID = Integer.parseInt(txtBookID.getText());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,
					"Book ID must be an integer number");
			return;
		}

		for (Book b : FileDatabase.getDB().getBooks())
		{
			if (b.getBookID() == iBookID)
			{
				book = b;
				break;
			}
		}

		if (book == null)
		{
			JOptionPane.showMessageDialog(this, "Book with ID not found!");
			return;
		}

		// search book in borrowed books list
		for (BorrowedBook bBook : FileDatabase.getDB().getBorrowedBooks())
		{
			if (bBook.getBookID() == iBookID
					&& bBook.getReturned().equals("No"))
			{
				borrowedBook = bBook;
				break;
			}
		}

		if (borrowedBook == null)
		{
			JOptionPane.showMessageDialog(this,
					"Book is not in borrowing list");
			return;
		}

		Date dReturnedDate = calReturnDate.getDate();

		// remove borrowed book list
		borrowedBook.setReturnedDate(dReturnedDate);
		borrowedBook.setReturned("Yes");

		FileDatabase.getDB().save();

		boolean success = true;

		//
		if (success)
		{
			JOptionPane.showMessageDialog(this, "Book returned successfully!\n",
					"Success", JOptionPane.INFORMATION_MESSAGE);

		}
		else
		{
			JOptionPane.showMessageDialog(this,
					"Failed to return the book. Please check the details.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		// close this screen
		mainScreen.setVisible(true);
		setVisible(false);

	}
}
