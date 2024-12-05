package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import model.Configuration;

public class MainScreen extends JFrame
{
	private JLabel lblSystemDate = new JLabel();
	
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
		
		
		//set date
		JMenu configMnu = new JMenu("Configuration");

		
		JMenuItem setDateMnuItem = new JMenuItem("Set System Date");
		configMnu.add(setDateMnuItem);
			
		mnuBar.add(configMnu);	
			
		mnuBar.add(new JLabel(" "));
		mnuBar.add(lblSystemDate);
		
		lblSystemDate.setText("Current Date: " + 
				Configuration.sdf.format(Configuration.currentDate));
		
		setJMenuBar(mnuBar);
		
		//allow user to set date
		setDateMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setDate();
			}
		});
		
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
		
		aboutMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(MainScreen.this, "Author: Joshua Bernardi, "
						+ "Zalma Farah. Copyright @2024");
			}
		});
		
		returnBookMnuItem.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openScreen(new ReturnBookScreen(MainScreen.this));
			}
		});
	}
	
	private void setDate() {
		
		JFrame frame = new JFrame("Set up system date");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(40, 40);
		frame.setLayout(new FlowLayout());
		
		JDialog dialog = new JDialog(frame, "Set Date", true);
		dialog.setSize(300, 300);
		dialog.setLayout(new BorderLayout());
		
		JCalendar calendar = new JCalendar();
		calendar.setDate(Configuration.currentDate);
		
		JButton btnSelect = new JButton("Select Date");
		btnSelect.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Configuration.currentDate = calendar.getDate();
				lblSystemDate.setText("Current Date: " + 
						Configuration.sdf.format(Configuration.currentDate));
				dialog.dispose();
			}
		});
		dialog.add(calendar, BorderLayout.CENTER);
		dialog.add(btnSelect, BorderLayout.SOUTH);
		
		dialog.setVisible(true);
		frame.setVisible(true);
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
