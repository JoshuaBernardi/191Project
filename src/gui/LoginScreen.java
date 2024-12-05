/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This is screen for login
 * 
 * This is a JFrame
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.FileDatabase;
import model.User;

/**
 * Login Screen
 */
@SuppressWarnings("serial")
public class LoginScreen extends JFrame
{
	/**
	 * user id field
	 */
	private JTextField txtUserID; //has a user id field
	
	/**
	 * password field
	 */
	private JPasswordField txtPassword; //has a password field
	
	/**
	 * constructor
	 */
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
				try
				{
					login();
				}
				catch (LoginException e1)
				{
					JOptionPane.showMessageDialog(LoginScreen.this, "Invalid user id, password. Please enter again");
					return;
				}
			}
		});
		
		add(pnlMain);		
		
		setTitle("Login Screen");
		setSize(400, 200);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * login
	 * 
	 * @throws LoginException
	 */
	private void login() throws LoginException {
		
		boolean success = false;
		String id = txtUserID.getText();
		String pass = txtPassword.getText();
		
		for (User user: FileDatabase.getDB().getUsers()) {
			if (user.getUserID().equals(id) && user.getPassword().equals(pass)) {
				success = true;
				break;
			}
		}
		
		if (!success) {
			throw new LoginException();
		}
		
		//success
		MainScreen mainScreen = new MainScreen();
		mainScreen.setVisible(true);
		
		setVisible(false);//close this login screen
	}

}
