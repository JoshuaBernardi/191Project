package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JMenu memberMnu = new JMenu("Member");
		JMenuItem listAllMembersMnuItem = new JMenuItem("List all members");
		JMenuItem addMemberMnuItem = new JMenuItem("Add Member");
		JMenuItem editMemberMnuItem = new JMenuItem("Edit Member");
			
		memberMnu.add(listAllMembersMnuItem);
		memberMnu.add(addMemberMnuItem);
		memberMnu.add(editMemberMnuItem);
			
		mnuBar.add(memberMnu);
		
		//search menu
		JMenu searchMnu = new JMenu("Search");
		JMenuItem searchBookMnuItem = new JMenuItem("Search book");
		JMenuItem searchMemberMnuItem = new JMenuItem("Search Member");
			
		searchMnu.add(searchBookMnuItem);
		searchMnu.add(searchMemberMnuItem);
			
		mnuBar.add(searchMnu);
		
		
		//action menu
		JMenu actionMnu = new JMenu("Action");
		JMenuItem borrowBookMnuItem = new JMenuItem("Borrow book");
		JMenuItem returnBookMnuItem = new JMenuItem("Return book");
			
		actionMnu.add(borrowBookMnuItem);
		actionMnu.add(returnBookMnuItem);
			
		mnuBar.add(actionMnu);
		
		
		//help manu
		JMenu helpMnu = new JMenu("Help");
		JMenuItem aboutMnuItem = new JMenuItem("About");
		helpMnu.add(aboutMnuItem);
		mnuBar.add(helpMnu);
		
		
		setJMenuBar(mnuBar);
		
		//set action
		exitMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		listBooksMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new BooksListScreen(MainScreen.this));
				
			}
		});
		
		listBorrowedBooksMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new BorrowedBooksListScreen(MainScreen.this));
				
			}
		});
		
		listAvailableBooksMenuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new AvailableBooksListScreen(MainScreen.this));
				
			}
		});
		
		
		//when user click Add book menu
		addBookMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new AddBookScreen(MainScreen.this));
				
			}
		});
		
		editBookMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new EditBookScreen(MainScreen.this));
			}
		});
		
		addMemberMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new AddMemberScreen(MainScreen.this));
				
			}
		});
		
		//when borrow book item is clicked
		borrowBookMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new BorrowBookScreen(MainScreen.this));
				
			}
		});
		
		listAllMembersMnuItem .addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new MemberListScreen(MainScreen.this));
			}
		});
		
		editMemberMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new EditMemberScreen(MainScreen.this));
			}
		});
		
		searchBookMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new SearchBooksScreen(MainScreen.this));
				
			}
		});
		
		searchMemberMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new SearchMembersScreen(MainScreen.this));
			}
		});
	}
	
	/**
	 * open the screen
	 * close this main screen
	 * @param screen
	 */
	private void openScreen(JFrame screen) {
		setVisible(false);
		screen.setVisible(true);
	}
}
