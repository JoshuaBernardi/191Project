/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This screen allows user to edit the member
 * The member must be existing
 * The member id is inputed, then the screen will fill
 * the current member information
 * 
 * It is a JFrame
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

import exception.DatabaseException;
import model.Book;
import model.FileDatabase;
import model.Member;

@SuppressWarnings("serial")
public class EditMemberScreen extends JFrame
{
	/**
	 * member id field
	 */
	private JTextField txtMemberID; // has a member id field

	/**
	 * password field
	 */
	private JPasswordField txtPassword; // has a password field

	/**
	 * confirm password field
	 */
	private JPasswordField txtConfirmPassword; // has a confirm password field

	/**
	 * name field
	 */
	private JTextField txtName; // has a name field

	/**
	 * phone number field
	 */
	private JTextField txtPhoneNumber; // has a phone number field

	/**
	 * address field
	 */
	private JTextField txtAddress; // has a address field

	/**
	 * email field
	 */
	private JTextField txtEmail; // has a email address field

	/**
	 * member to edit
	 */
	private Member member; // has a member to edit

	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen;

	/**
	 * constructor
	 * 
	 * @param mainScreen reference to main screen
	 */
	public EditMemberScreen(MainScreen mainScreen)
	{

		this.mainScreen = mainScreen;

		JButton btnSearch = new JButton("Search");

		// TODO, add more fields
		txtMemberID = new JTextField();
		txtPassword = new JPasswordField();
		txtConfirmPassword = new JPasswordField();

		txtName = new JTextField();
		txtPhoneNumber = new JTextField();
		txtAddress = new JTextField();
		txtEmail = new JTextField();

		// buttons
		JButton btnEditMember = new JButton("Edit Member");
		JButton btnCancel = new JButton("Cancel");

		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(9, 2, 10, 10)); // TODO: add more
															// columns

		pnlMain.add(new JLabel("Member ID: "));
		pnlMain.add(txtMemberID);

		pnlMain.add(new JLabel());
		pnlMain.add(btnSearch);

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

		pnlMain.add(btnEditMember);
		pnlMain.add(btnCancel);

		// github 5

		// add action for button
		btnEditMember.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					editMember();
				}
				catch (DatabaseException e1)
				{
					JOptionPane.showMessageDialog(null,
							"Database error! Contact the administration for help");
				}
			}
		});
		// cancel button when user clicks button event cancel action is
		// performed
		btnCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainScreen.setVisible(true);
				dispose(); // free resource, close this screen
			}
		});

		btnSearch.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					searchMember();
				}
				catch (DatabaseException e1)
				{
					JOptionPane.showMessageDialog(null,
							"Database error! Contact the administration for help");
				}

			}
		});

		add(pnlMain);

		setTitle("Add Member Screen");
		setSize(600, 600); // width and height of screen
		setLocationRelativeTo(null); // center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void searchMember() throws DatabaseException
	{

		int iMemberId = 0;
		try
		{
			iMemberId = Integer.parseInt(txtMemberID.getText());
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,
					"Book ID must be an integer number");
			return;
		}

		member = FileDatabase.getDB().getMemberByID(iMemberId);

		if (member == null)
		{
			JOptionPane.showMessageDialog(this, "Member with ID not found!");
		}
		else
		{
			txtPassword.setText(member.getPassword());
			txtConfirmPassword.setText(member.getPassword());
			txtName.setText(member.getName());
			txtPhoneNumber.setText(member.getPhoneNumber());
			txtAddress.setText(member.getAddress());
			txtEmail.setText(member.getEmail());
		}
	}

	// comment
	/**
	 * test github change 1
	 * add book
	 * 
	 * @throws DatabaseException
	 */
	private void editMember() throws DatabaseException
	{
		String memberID = txtMemberID.getText();
		String password = txtPassword.getText();
		String confirmedPass = txtConfirmPassword.getText();
		String name = txtName.getText();
		String phone = txtPhoneNumber.getText();
		String address = txtAddress.getText();
		String email = txtEmail.getText();

		int iMemberID = 0;
		try
		{
			iMemberID = Integer.parseInt(memberID);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this,
					"Member ID must be an integer number");
			return;
		}

		if (member == null)
		{
			JOptionPane.showMessageDialog(this,
					"Please enter Member ID and Search");
			return;
		}

		if (!password.equals(confirmedPass))
		{
			JOptionPane.showMessageDialog(this, "Passwords do not match!");
			return;
		}

		// txtPassword is the JPasswordField, it is obsolute method
		// it is replaced by new JAVA JDK library, new method is getPassword()
		// (new char[])
		// the Eclipse will give the warning if getText Method is used
		// but we can use Both

		String pass = new String(txtPassword.getPassword());

		member.setPassword(pass);
		member.setName(txtName.getText());
		member.setPhoneNumber(txtPhoneNumber.getText());
		member.setEmail(txtEmail.getText());

		FileDatabase db = FileDatabase.getDB();
		db.save();

		JOptionPane.showMessageDialog(this,
				"Member has been edited successfully");

		// close this screen
		mainScreen.setVisible(true);
		setVisible(false);

	}
}
