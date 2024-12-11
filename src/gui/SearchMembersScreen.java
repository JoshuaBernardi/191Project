/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen searches all members in the system
 * 
 * It is a JFrame
 */
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import exception.DatabaseException;
import model.Book;
import model.Database;
import model.FileDatabase;
import model.Member;

// LO1: Single responsibility principle
@SuppressWarnings("serial")
public class SearchMembersScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database; // has a reference to database

	/**
	 * key to search like the substring in name, address, phone, email ...
	 */
	private JTextField txtKey; // has a key field

	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; // has a reference to the main screen

	/**
	 * constructor
	 * 
	 * @param mainScreen reference to the main screen
	 * @throws DatabaseException
	 */
	public SearchMembersScreen(MainScreen mainScreen) throws DatabaseException
	{

		this.mainScreen = mainScreen;

		setTitle("Library System - Search members");
		setSize(1000, 800);
		setLocationRelativeTo(null); // center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		database = FileDatabase.getDB();

		setLayout(new BorderLayout());

		// show control
		showControl();
	}

	/**
	 * show control panel
	 */
	private void showControl()
	{

		JPanel topPanel = new JPanel(new GridLayout(1, 3));
		topPanel.add(new JLabel("Key: "));

		txtKey = new JTextField(100);
		topPanel.add(txtKey);

		JButton btnSearch = new JButton("Search");
		topPanel.add(btnSearch);

		add(topPanel, BorderLayout.NORTH);

		btnSearch.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				searchMembers();
			}
		});

		JButton btnBack = new JButton("Back");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(btnBack);

		add(bottomPanel, BorderLayout.SOUTH);

		// set action for button
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
	 * search members on the screen
	 */
	public void searchMembers()
	{

		List<Member> allMembers = database.getMembers();
		List<Member> members = new ArrayList<>();

		String key = txtKey.getText();
		if (key.isEmpty())
		{
			members = allMembers;
		}
		else
		{
			for (Member member : allMembers)
			{
				if (member.getName().contains(key)
						|| member.getPhoneNumber().contains(key)
						|| member.getAddress().contains(key)
						|| member.getEmail().contains(key))
				{
					members.add(member);
				}
			}
		}

		MemberTableModel model = new MemberTableModel(members);
		JTable memberTable = new JTable(model);

		// create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(memberTable);
		;

		// put as the center
		add(centerPanel, BorderLayout.CENTER);

		// refresh screen
		invalidate();
		validate();
	}

}
