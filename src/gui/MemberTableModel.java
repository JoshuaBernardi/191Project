/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * This class supports the table component
 * to manage the list of the items in the table
 * such as the columns (can add, edit row...)
 * 
 * This GUI is a AbstractTableModel
 */
package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Book;
import model.Member;

/**
 * this model is used to control the data part of the Jtable
 * to show members
 */
public class MemberTableModel extends AbstractTableModel
{
	/**
	 * column names
	 * 
	 * has a column names
	 * 
	 */
	private String[] columnNames = { "Member ID", "Name", "Phone", "Address",
			"Email" };

	/**
	 * reference to list of members
	 */
	private List<Member> members; // has many members

	/**
	 * constructor
	 * 
	 * @param members
	 */
	public MemberTableModel(List<Member> members)
	{
		this.members = members;
	}

	@Override
	/**
	 * return the number of columns
	 */
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	/**
	 * get the name of the column [column]
	 */
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	@Override
	/**
	 * get the number of rows in table
	 */
	public int getRowCount()
	{
		return members.size();
	}

	@Override
	/**
	 * show the value at row and column of the table
	 */
	public Object getValueAt(int row, int col)
	{
		Object val = null;

		switch (col)
		{
			case 0:
				val = members.get(row).getMemberID();
				break;
			case 1:
				val = members.get(row).getName();
				break;
			case 2:
				val = members.get(row).getPhoneNumber();
				break;
			case 3:
				val = members.get(row).getAddress();
				break;
			case 4:
				val = members.get(row).getEmail();
				break;
			default:
				break;
		}
		return val;
	}

}
