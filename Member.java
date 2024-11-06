/**
 * Member is the super class of Student, Professor
 */
public class Member {

	private String name;
	private String phoneNumber;
	private int memberID;
	private String password;
	
	
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
}
