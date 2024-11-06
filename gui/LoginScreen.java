package gui;

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
