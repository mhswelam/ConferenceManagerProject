package cleanCode;


/**
 * @author Clean Code
 * This class to be a blue print for the other users class
 *
 */
public class User {
	
	public int myUserId;
	public String myFristName;
	public String myLastName;
	public String myEmail;
	
	
	public User(int aUserId, String aFristName, String aLastName,
			String anEmail) {
		
		myUserId = aUserId;
		myFristName = aFristName;
		myLastName = aLastName;
		myEmail = anEmail;
	}
	
	public void login(int aUserId) {

	}
	
	public void logout() {
		
	}
	

}
