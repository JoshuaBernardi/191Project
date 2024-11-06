package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainScreen extends JFrame
{
	
	public MainScreen() {
		
		createMenu();
		
		setTitle("Library System");
		setSize(1000, 800);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private void createMenu() {
		
		JMenuBar mnuBar = new JMenuBar();
		
		//file menu
		JMenu fileMnu = new JMenu("File");
		JMenuItem exitMnuItem = new JMenuItem("Exit");
		fileMnu.add(exitMnuItem);
		
		mnuBar.add(fileMnu);
		
		//book menu
		JMenu bookMnu = new JMenu("Book");
		JMenuItem listBooksMnuItem = new JMenuItem("List all books");
		JMenuItem listBorrowedBooksMnuItem = new JMenuItem("List borrowed books");
		JMenuItem listAvailableBooksMenuItem = new JMenuItem("List available books");
		JMenuItem addBookMnuItem = new JMenuItem("Add Book");
		JMenuItem editBookMnuItem = new JMenuItem("Edit Book");
		
		bookMnu.add(listBooksMnuItem);
		bookMnu.add(listBorrowedBooksMnuItem);
		bookMnu.add(listAvailableBooksMenuItem);
		bookMnu.add(addBookMnuItem);
		bookMnu.add(editBookMnuItem);
		
		mnuBar.add(bookMnu);
		
		//member menu
		JMenu searchMnu = new JMenu("Search");
		JMenuItem searchBookMnuItem = new JMenuItem("Search book");
		JMenuItem searchMemberMnuItem = new JMenuItem("Search Member");
			
		searchMnu.add(searchBookMnuItem);
		searchMnu.add(searchMemberMnuItem);
			
		mnuBar.add(searchMnu);
		
		//search menu
		
		//action menu
		
		//help manu
		
		setJMenuBar(mnuBar);
	}
}
