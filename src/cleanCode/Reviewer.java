package cleanCode;
import java.util.ArrayList;

/**
 * @author Clean Code/ Mohamed
 * This class to create a Reviewer
 *
 */
public class Reviewer extends User {
	
	private ArrayList<Integer> myAssignedPapers;
	
    public int PAPERASSIGNED = 0;
    
    final int myRoleId = 1;
    
    /**
     * This is a constructor to create reviewer.
     * @param aUserId the reviewer id.
     * @param aFirstName the reviewer first name
     * @param aLastName the reviewer last name
     * @param anEmail the reviewer email
     */
    public Reviewer(int aUserId, String aFirstName, String aLastName,
			String anEmail){
    	super(aUserId, aFirstName, aLastName,
    			anEmail);
    	
    }

}
