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
 * Responsibilities of class: This class provides a GUI for searching books in a library system and allows users to 
 *                            input the book in the search bar and checks if the book exists in the list
 * 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SearchBookScreen extends JFrame
{
	private JTextField txtSearchBook;
	private JButton btnSearch;
	private JButton btnCancel;
	private MainScreen mainScreen;
	private ArrayList<String> bookList;
	
	/*
	 * 
	 * 
	 */
	public SearchBookScreen(MainScreen mainScreen)
	{
		this.mainScreen = mainScreen;
		bookList = new ArrayList<>();
		
		//sets up panel and layout
		txtSearchBook = new JTextField(20);
		btnSearch = new JButton("Search");
		btnCancel = new JButton("Cancel");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(2,2,10,10));
		
		pnlMain.add(new JLabel("Search Term: "));
		pnlMain.add(txtSearchBook);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		pnlButtons.add(btnSearch);
		pnlButtons.add(btnCancel);
		
		setLayout(new BorderLayout(10, 10));
		add(pnlMain, BorderLayout.CENTER);
		add(pnlButtons, BorderLayout.SOUTH);
		
	
		//button actions
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				searchBook();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		//frame setup
		setTitle("Search Book");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * 
	 * 
	 */
	public void searchBook()
	{
		String searchBook = txtSearchBook.getText().trim();
		
		if(searchBook.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter a book to search" , "Error" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		boolean found = false;
		
		//search through the book list
		for(String book: bookList)
		{
			if(book.equalsIgnoreCase(searchBook))
			{
				found = true;
				break;
			}
		}
		
		//displays message based on search result
		if (found)
		{
			JOptionPane.showMessageDialog(this, "Book Found: " + searchBook);
			
		} else {
			JOptionPane.showMessageDialog(this, "No book found with that title");
		}
	   
	}
	
	/*
	 * 
	 * 
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			
			public void run()
			{
				MainScreen mainScreen = new MainScreen();
				new SearchBookScreen(mainScreen).setVisible(false);
			}
		});
	}
	
}	
	

