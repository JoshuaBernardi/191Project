/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Screen to adding member
 * This class is-a JFrame
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Book;
import model.FileDatabase;
import model.Member;

@SuppressWarnings("serial")
public class AddMemberScreen extends JFrame
{
	/**
	 * member id field
	 */
	private JTextField txtMemberID; //has a id field
	
	/**
	 * password field
	 */
	private JPasswordField txtPassword; //has a password field
	
	/**
	 * field to confirm the password
	 */
	private JPasswordField txtConfirmPassword; //has a confirm password field
	
	/**
	 * name field
	 */
	private JTextField txtName; //has a name field
	
	/**
	 * phone number field
	 */
	private JTextField txtPhoneNumber; //has phone number field
	
	/**
	 * address field
	 */
	private JTextField txtAddress; //has a address field
	
	/**
	 * email field
	 */
	private JTextField txtEmail; //has a email field
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen; //has a reference to the main screen
	
	/**
	 * constructor
	 */
	public AddMemberScreen(MainScreen mainScreen) {

		this.mainScreen = mainScreen;
		
		
		//TODO, add more fields
		txtMemberID = new JTextField();
		txtPassword = new JPasswordField();
		txtConfirmPassword = new JPasswordField();
		
		txtName = new JTextField();
		txtPhoneNumber = new JTextField();
		txtAddress = new JTextField();
		txtEmail = new JTextField();
		
		//buttons
		JButton btnAddMember = new JButton("Add Member");
		JButton btnCancel = new JButton("Cancel");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(8, 2, 10, 10)); //TODO: add more columns
		
		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);
		
		pnlMain.add(new JLabel("Password: "));
		pnlMain.add(txtPassword);
		
		pnlMain.add(new JLabel("Confirmed Password: "));
		pnlMain.add(txtConfirmPassword);

		pnlMain.add(new JLabel("Member Name: "));
		pnlMain.add(txtName);
	
		pnlMain.add(new JLabel("Phone Number: "));
		pnlMain.add(txtPhoneNumber);

		pnlMain.add(new JLabel("Address: "));
		pnlMain.add(txtAddress);

		pnlMain.add(new JLabel("Email: "));
		pnlMain.add(txtEmail);
		
		pnlMain.add(btnAddMember);
		pnlMain.add(btnCancel);
	
		//github 5
		
		//add action for button
		btnAddMember.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				addMember();
			}
		});
		//cancel button when user clicks button event cancel action is performed 
		btnCancel.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainScreen.setVisible(true);
				dispose(); //free resource, close this screen
			}
		});
		
		add(pnlMain);		
		
		setTitle("Add Member Screen");
		setSize(600, 600); //width and height of screen
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * add member to the system
	 * The member id is unique
	 * 
	 * test github change 1
	 * add book
	 */
	private void addMember() {
		String memberID = txtMemberID.getText();
		String password = txtPassword.getText();
		String confirmedPass = txtConfirmPassword.getText();
		String name = txtName.getText();
		String phone = txtPhoneNumber.getText();
		String address = txtAddress.getText();
		String email = txtEmail.getText();
		
		int iMemberID = 0;
		try {
			iMemberID = Integer.parseInt(memberID);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Member ID must be an integer number");
			return;
		}
		
		Member member = null;
		for (Member mem : FileDatabase.getDB().getMembers()) {
			if (mem.getMemberID() == iMemberID) {
				member = mem;
				break;
			}
		}
		
		if (member != null) {
			JOptionPane.showMessageDialog(this, "Member ID existing! Please enter different number");
			return;
		}
		
		if (!password.equals(confirmedPass)) {
			JOptionPane.showMessageDialog(this, "Passwords do not match!");
			return;
		}
		
		member = new Member(iMemberID, password, name, phone, address, email);
		
		FileDatabase db = FileDatabase.getDB();
		db.getMembers().add(member);
		db.save();
		
		JOptionPane.showMessageDialog(this, "Member has been added successfully");
		
		//close this screen
		mainScreen.setVisible(true);
		setVisible(false);
		
	}
}
