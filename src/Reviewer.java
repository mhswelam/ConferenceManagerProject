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
    
    public Reviewer(int aUserId, String aFristName, String aLastName,
			String anEmail){
    	super(aUserId, aFristName, aLastName,
    			anEmail);
    }

}
