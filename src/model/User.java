/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * User can log in and uses the system
 */
package model;

public class User
{
	/**
	 * id
	 */
	private String userID; // has id

	/**
	 * password
	 */
	private String password; // has password

	/**
	 * constructor
	 * 
	 * @param userID
	 * @param password
	 */
	public User(String userID, String password)
	{
		this.userID = userID;
		this.password = password;
	}

	/**
	 * @return the userID
	 */
	public String getUserID()
	{
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

}
