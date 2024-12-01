/**
 * 
 */
package gui;
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
public class MemberScreen extends JFrame{

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
	public MemberScreen(MainScreen mainScreen)
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
				new MemberScreen(mainScreen).setVisible(false);
			}
		});
	}
}

