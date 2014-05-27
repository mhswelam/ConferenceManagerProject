package cleanCode;
import java.util.ArrayList;

/**
 * @author Clean Code/ Mohamed
 * This class to create a Reviewer
 *
 */
public class Reviewer extends User {
	
	private ArrayList<Integer> myAssignedPapers;
	
    final int PAPERASSIGNED = 4;
    
    final int myRoleId = 4;
    
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
