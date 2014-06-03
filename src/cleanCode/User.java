package cleanCode;


/**
 * @author Clean Code
 * This class to be a blue print for the other users class
 *
 */
public class User {
	
	public static int myUserId;
	public String myFristName;
	public String myLastName;
	public String myEmail;
	public static int myRoleId;
	public int paperAssinged;
	
	public User(int aUserId, String aFristName, String aLastName,
			String anEmail, int aRoleId) {
		
		myUserId = aUserId;
		myFristName = aFristName;
		myLastName = aLastName;
		myEmail = anEmail;
		myRoleId = aRoleId;
		paperAssinged = 0;
	}
	
	public User(int aUserId, String aFristName, String aLastName,
			String anEmail, int aRoleId, int aPaperassinged) {
		
		myUserId = aUserId;
		myFristName = aFristName;
		myLastName = aLastName;
		myEmail = anEmail;
		myRoleId = aRoleId;
		paperAssinged = aPaperassinged;
	}
//	public void login(int aUserId) {
//
//	}
//	
//	public void logout() {
//		
//	}
	

}
