package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SearchBookScreen extends JFrame
{
	private JTextField txtSearchBook;
	private JButton btnSearch;
	private JButton btnCancel;
	private MainScreen mainScreen;
	
	/*
	 * 
	 * 
	 */
	public SearchBookScreen(MainScreen mainScreen)
	{
		this.mainScreen = mainScreen;
		
		//
		txtSearchBook = new JTextField(20);
		btnSearch = new JButton("Search");
		btnCancel = new JButton("Cancel");
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new GridLayout(2,2,10,10));
		
		pnlMain.add(new JLabel("Search Term: "));
		pnlMain.add(txtSearchBook);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		pnlButtons.add(btnSearch);
		pnlButtons.add(btnCancel);
		
		setLayout(new BorderLayout(10, 10));
		add(pnlMain, BorderLayout.CENTER);
		add(pnlButtons, BorderLayout.SOUTH);
		
	
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				searchBook();
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				mainScreen.setVisible(true);
				dispose();
			}
		});
		
		//
		setTitle("Search Book");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*
	 * 
	 * 
	 */
	public void searchBook()
	{
		String searchBook = txtSearchBook.getText();
		
		
		
	}
	
}	
	

