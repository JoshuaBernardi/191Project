/**
 * 
 */
package gui;


import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * 
 */
public class ListMemberScreen extends JFrame
{
	private JPanel pnlMain;
	private JList<String> membersList;
	private JScrollPane scrollPane;
	
	
	/**
	 * @param args
	 */
	public ListMemberScreen(List<String> members)
	{
		setTitle("List of Members");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//initialize the panel and list
		pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		
		membersList = new JList<>(members.toArray(new String[0]));
		scrollPane = new JScrollPane(membersList);
		
		pnlMain.add(scrollPane, BorderLayout.CENTER);
		
		add(pnlMain);
	
	}
	
	public static void main(String[] args)
	{
		List<String> members = List.of()
	}

}
