package cleanCode;

/**
 * @author Clean Code/ Mohamed
 * This class to create a Reviewer
 *
 */
public class Reviewer extends User {
	
	final int MAX_PAPER = 4;
	
	
	
    public int paperAssinged = 0;
    
    
    /**
     * This is a constructor to create reviewer.
     * @param aUserId the reviewer id.
     * @param aFirstName the reviewer first name
     * @param aLastName the reviewer last name
     * @param anEmail the reviewer email
     */
    public Reviewer(int aUserId, String aFirstName, String aLastName,
			String anEmail, int aPaperAssigned){
    	super(aUserId, aFirstName, aLastName,
    			anEmail,4);
    	
    	paperAssinged = aPaperAssigned ;
    }
    
    

}
