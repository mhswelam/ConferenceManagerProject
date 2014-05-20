/**
 * @author Clean Code
 * This class to create a Recommendation.
 *
 */
public class Recommendation {
	
	/** This to hold the paper id. */
	private int myPaperId;
	
	/** This to hold the SubProgramChairs id. */
	private int mySubprogramChairId;
	
	/** Stores the Recommendations Grade 1-5. */
	private int myGrade;
	
	/** Stores the text rational for the grade of the paper.*/
	private String myRecRational;
	
	/**
	 * The constructor for the Recommendation class.
	 * @param thePaperId the ID of the paper.
	 * @param theSubProgramChairId the Sub Program Chairs ID.
	 * @param theGrade the grade that this paper will recieve from the Sub Program Chair.
	 * @param theRecRational the resoning behind the recomendation.
	 */
	public Recommendation(int thePaperId, int theSubProgramChairId, int theGrade,
				String theRecRational) {
		myPaperId = thePaperId;
		mySubprogramChairId = theSubProgramChairId;
		myGrade = theGrade;
		myRecRational = theRecRational;
	}
	
	/**
	 * Getter method for the paperId.
	 * @return the papers ID.
	 */
	public int getMyPaperID() {
		return myPaperId;
	}
	
	/**
	 * Getter method for the Sub Program Chairs ID.
	 * @return the Sub Program chairs ID.
	 */
	public int getMySubProgramID() {
		return mySubprogramChairId;
	}
	
	/**
	 * Getter for the grade of the paper.
	 * @return myGrade.
	 */
	public int getGrade() {
		return myGrade;
	}
	
	/**
	 * Getter for the rational of the paper.
	 * @return the rational as a String.
	 */
	public String getRational() {
		return myRecRational;
	}
}