/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen list all members
 * 
 * It is JFrame 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Book;
import model.Database;
import model.FileDatabase;
import model.Member;

/**
 * This screen shows all members in the system
 */
@SuppressWarnings("serial")
public class MemberListScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database; //has a database
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; //has a reference to the main screen
	
	/**
	 * constructor
	 * @param mainScreen main screen
	 */
	public MemberListScreen(MainScreen mainScreen) {
		
		this.mainScreen = mainScreen;
		
		setTitle("Library System - List all members");
		setSize(1000, 800);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		database = FileDatabase.getDB();
		
		//show members
		showMembers();
		
		//show control
		showControl();
	}
	
	/**
	 * show control panel
	 */
	private void showControl() {
		
		JButton btnBack = new JButton("Back");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(btnBack);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		//set action for button
		btnBack.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				mainScreen.setVisible(true);
			}
		});
	}
	
	/**
	 * show books on the screen
	 */
	public void showMembers() {
		
		setLayout(new BorderLayout());
		
		List<Member> members = database.getMembers();
		
		MemberTableModel model = new MemberTableModel(members);
		JTable memberTable = new JTable(model);
		
		//create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(memberTable);;
		
		//put as the center
		add(centerPanel, BorderLayout.CENTER);
	}

}
