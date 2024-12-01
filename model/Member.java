package model;
/**
 * Member is the super class of Student, Professor
 */
public class Member {

	private String name;
	private String phoneNumber;
	private int memberID;
	
	
	/**
	 * @param 
	 */
	
	public Member(String name, String phoneNumber, int memberID) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.memberID = memberID;
	}
	
	public String getName() {
		
		return name; //returns the member's name
		
	}
	
	public String getPhoneNumber() {
		
		return phoneNumber; //returns the member's phone number
	}
	
	public int getMemberID() {
		
		return memberID;
	}
	
	
	
	public void setName(String name)
	{
		this.name = name;
		
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public String toString()
	{
		return "Member ID: " + memberID + "\n" +
				"Name: " + name + "\n" +
				"Phone: " + phoneNumber;
	}
}


