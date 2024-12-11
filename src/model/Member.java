package model;

/**
 * Author: Joshua Bernardi, Zalma Farah
 * 
 * Member represents a user that can borrow, return book
 */
public class Member
{

	/**
	 * id
	 */
	private int memberID; // has a id

	/**
	 * password
	 */
	private String password;// has a password

	/**
	 * name
	 */
	private String name; // has a name

	/**
	 * phone number
	 */
	private String phoneNumber; // has a phone number

	/**
	 * address
	 */
	private String address; // has a address

	/**
	 * email
	 */
	private String email; // has a email

	/**
	 * constructor
	 * 
	 * @param memberID
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param address
	 * @param email
	 */
	public Member(int memberID, String password, String name,
			String phoneNumber, String address, String email)
	{
		this.memberID = memberID;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	/**
	 * @return the memberID
	 */
	public int getMemberID()
	{
		return memberID;
	}

	/**
	 * @param memberID the memberID to set
	 */
	public void setMemberID(int memberID)
	{
		this.memberID = memberID;
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

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

}
