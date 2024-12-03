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
 * Responsibilities of class: This class provides a login screen where users can enter their user ID and password 
 * 
 * 
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Login Screen
 */
@SuppressWarnings("serial")
public class LoginScreen extends JFrame
{
	
	private JTextField txtUserID;
	private JPasswordField txtPassword;
	
	public LoginScreen() {
		
		txtUserID = new JTextField(10);;
		txtPassword = new JPasswordField();
		
		//buttons
		JButton btnLogin = new JButton("Login");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(3, 2, 10, 10));
		pnlMain.add(new JLabel("ID: "));
		pnlMain.add(txtUserID);
		
		pnlMain.add(new JLabel("Password: "));
		pnlMain.add(txtPassword);
		
		pnlMain.add(btnLogin);
		
		
		//add action for button
		btnLogin.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				login();
			}
		});
		
		add(pnlMain);		
		
		setTitle("Login Screen");
		setSize(400, 200);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void login() {
		//success
		MainScreen mainScreen = new MainScreen();
		mainScreen.setVisible(true);
		
		setVisible(false);//close this login screen
	}

}
