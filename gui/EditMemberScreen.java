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
public class EditMemberScreen extends JFrame{
	
	private JTextField txtMemberName;
	private JTextField txtMemberPhone;
	
	/*
	 * Reference to main screen
	 */
	private MainScreen mainScreen;
	
	
	/*
	 * Reference to member being edited
	 * 
	 */
	private Member member;
	
	
	/**
	 * Constructor
	 * @param mainScreen References to the main screen
	 * @param member Reference to the member being edited
	 */
	
	public EditMemberScreen(MainScreen mainScreen, Member member)
	{
		this.mainScreen = mainScreen;
		this.member = member;
		

		txtMemberName = new JTextField(member.getName());
		txtMemberPhone = new JTextField(member.getPhoneNumber());
		
		JButton btnSaveChanges = new JButton("Save Changes");
		JButton btnCancel = new JButton("Cancel");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(5, 2, 10, 10));
		
		pnlMain.add(new JLabel("Phone: "));
		pnlMain.add(txtMemberPhone);
		
		pnlMain.add(new JLabel("Name: "));
		pnlMain.add(txtMemberName);
		
		pnlMain.add(btnSaveChanges);
		pnlMain.add(btnCancel);

		
		btnSaveChanges.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveChanges();
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
		
		setTitle("Edit Member Screen");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

/*
 * Save changes to the member
 * 
 */

public void saveChanges()
{
	
	member.setName(txtMemberName.getText());
	member.setPhoneNumber(txtMemberPhone.getText());
	
	FileDatabase db = FileDatabase.getDB();
	db.save();
	
	JOptionPane.showMessageDialog(this, "Member details updated successfully");
	
	
	mainScreen.setVisible(true);
	setVisible(false);
 }
}







