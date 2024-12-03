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
 * Responsibilities of class: This class adds new members to the system while providing fields such as member ID,name, and phone number
 * 
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import model.Member;
import model.FileDatabase;



/**
 * 
 */
public class AddMemberScreen extends JFrame{

	private JTextField txtMemberID;
	private JTextField txtMemberName;
	private JTextField txtMemberPhone;
	
	/*
	 *Reference to main screen
	 */
	private MainScreen screen;
	
	
	/**
	 * Constructor 
	 * @param mainScreen The main screen reference
	 */
	public AddMemberScreen(MainScreen mainScreen)
	{
		
		//intialize the text fields
		this.screen = mainScreen;
		txtMemberID = new JTextField();
		txtMemberName = new JTextField();
		txtMemberPhone = new JTextField();
		
		//buttons
		JButton btnAddMember = new JButton("Add Member");
		JButton btnCancel = new JButton("Cancel");
		
		//add the components to the panel
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10));
		
		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Name: "));
		pnlMain.add(txtMemberName);
		
		pnlMain.add(new JLabel("Phone: "));
		pnlMain.add(txtMemberPhone);
		
		pnlMain.add(btnAddMember);
		pnlMain.add(btnCancel);
		
		
		//add listeners for buttons
		btnAddMember.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addMember();
			}
		});
		
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		add(pnlMain);
		
		setTitle("Member Screen");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	/*
	 * Add a new member to the database
	 * 
	 */
	public void addMember()
	{
		String memberID = txtMemberID.getText().trim();
		String name = txtMemberName.getText().trim();
		String phone = txtMemberPhone.getText().trim();
		
		
		if(name.isEmpty() || phone.isEmpty() || memberID.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please fill in the blanks.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Member newMember = new Member(name, phone, Integer.parseInt(memberID));
		
		JOptionPane.showMessageDialog(this, "Member has been added successfully.");
		
		txtMemberID.setText("");
		txtMemberName.setText("");
		txtMemberPhone.setText("");

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
				new AddMemberScreen(mainScreen).setVisible(true);
			}
		});
	}
}

