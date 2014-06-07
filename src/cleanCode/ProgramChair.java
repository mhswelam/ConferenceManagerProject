package cleanCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Clean Code
 * This class to create a Program Chair
 * 
 * @author Polina Kud
 *
 */
public class ProgramChair extends User {

	
	/** Conference .*/
//	private Conference myConference;
	/** Map of SubProgram Chairs and their Assigned papers. */
	private Map<Integer, List<Integer>> myAssignedPapers;
	/** List designated SubProgram Chairs. */
	private List<Integer> mySubProgramChairs;
	/** List of reviewers .*/
	private List<Integer> myReviewers;
	/** Papers submitted to the confirence. */
	private List<Integer> myPapers;
	
	/**
	 * Creates a designated Program Chair
	 * 
	 * @param theUserId unique identification number of the Program Chair.
	 * @param theFirstName first name of the Program Chair.
	 * @param theLastName last name of the Program Chair.
	 * @param theEmail email of the Program Chair.
	 * @param theConference conference.
	 */
	public ProgramChair(final int theUserId, final String theFirstName, 
						final String theLastName, final String theEmail, int aPaperAssigned) {
		
		super(theUserId, theFirstName, theLastName, theEmail, 1, aPaperAssigned);
//		myConference = theConference;
		myAssignedPapers = new HashMap<Integer, List<Integer>>();
		mySubProgramChairs = new ArrayList<Integer>();
		myReviewers = new ArrayList<Integer>();
		myPapers = new ArrayList<Integer>();
	}
	
	/**
	 * Designates SubProgram Chair for a manuscript.
	 * 
	 * @param theSubChair SubProgram Chair to oversee the manuscript.
	 * @param thePaperId paper to be designated.
	 */
	public void selectSubProgramChair(final int theSubChair, 
									  final int thePaperId) {
		//check to make sure that subprogram chair is not the author of that paper
		if (!myAssignedPapers.containsKey(theSubChair)) {
			myAssignedPapers.put(theSubChair, new ArrayList<Integer>());
		} 
		myAssignedPapers.get(theSubChair).add(thePaperId);
//		myConference.listOfPaper.get(thePaperId).assignSubProgramChair(theSubChair);
		//Add subprogram Chair to list in conference
	}
	
	/**
	 * Assigns a Reviewer to be a Subprogram Chair for the conference.
	 * 
	 * @param theReviewer reviewer in the conference.
	 */
	public void designateSubProgramChair(final int theReviewer) {
		//still working
	}
	
	/**
	 * @return List of SubProgram Chairs and their corresponding papers.
	 */
	public Map<Integer, List<Integer>> getAssignedPapers() {
		return myAssignedPapers;
	}
	
	/**
	 * @return List of designated SubProgram Chairs.
	 */
	public List<Integer> getSubChairs() {
		return mySubProgramChairs;
	}
	
	/**
	 * @return List of reviewers.
	 */
	public List<Integer> getReviewers() {
		return myReviewers;
	}
	
	/**
	 * @return List of papers.
	 */
	public List<Integer> getPapers() {
		return myPapers;
	}
	
	/**
	 * Accepts/Rejects paper for the conference.
	 * 
	 * @param the_paper_id identification number of the 
	 * paper to be accepted/rejected.
	 * @param the_status paper status yes/no.
	 * 
	 */
	public void makeDesicion(final Paper thePaper, 
							 final String theStatus) {
		thePaper.changeStatus(theStatus);
	}
}
