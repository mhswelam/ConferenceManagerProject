import java.util.Map;
/**
 * @author Clean Code
 * This class to create a Sub-Program Chair
 *
 */
public class SubProgramChair extends User{
	
	/** the amount of papers that can be assigned to the Sub Program Chair. */
	public int papersAssigned = 4;
	
	/** a list of the papers that the Sub Program Chair has access to. */
	private Map<Integer, Paper> myAssignedPapers;
	
	/** The Sub Program Chairs role ID. */
	final int myRoleId = 2;
	
	/**
	 * Constructor for the Sub Program Chair class.
	 * @param aUserId the Sub Program chairs ID.
	 * @param aFristName the Sub Program chairs first Name.
	 * @param aLastName the Sub Program chairs last Name.
	 * @param anEmail the Sub Program Chairs Email. Email is for 
	 * notification purposes only.
	 */
	public SubProgramChair(int aUserId, String aFristName, String aLastName,
			String anEmail){
	    	super(aUserId, aFristName, aLastName, anEmail);
	}
	
	/**
	 * Assigns Papers to Reviewers.
	 * @param idPaper the Papers ID which is used to retrieve the paper.
	 * @param idReviewer the Reviewers Id that you wish to select.
	 */
	private void assignPapers(int idPaper, int idReviewer) {
		Paper myPaper = myAssignedPapers.get(idPaper);
		myPaper.reviewed++;
		if (myPaper.reviewed == 1) {
			myPaper.myAssignedReviewer0 = idReviewer;
		} else if (myPaper.reviewed == 2) {
			myPaper.myAssignedReviewer1 = idReviewer;
		} else if (myPaper.reviewed == 3) {
			myPaper.myAssignedReviewer2 = idReviewer;
			//Once their is 3 reviewers for a paper it cannot be reviewed by any more.
		} else {
			System.out.println("This paper cannot be reviewed"
					+ " by anymore reviewers");
		}
	}
	
	/**
	 * Create the recommendation for the paper.
	 * @param idPaper the ID of the paper.
	 * @param theGrade the Sub Program chairs grade of the paper.
	 * @param theRational the Sub Program chairs rational behind the grade of the paper.
	 * @return the recommendation.
	 */
	private Recommendation recommendation(int idPaper, int theGrade, String theRational) {
		Recommendation rec = new Recommendation(idPaper, super.myUserId, theGrade, theRational);
		return rec;
	}
	
	/**
	 * The getter method for the amount of assigned papers to this Sub Program Chair.
	 * @return the amount of papers this Sub Program chair can take on.
	 */
	public int getAmountAssigned() {
		return papersAssigned;
	}
}
