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
	/** Program Chairs role ID. */
	private final static int MY_ROLE_ID = 1;
	
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
	 */
	public ProgramChair(final int theUserId, final String theFirstName, 
						final String theLastName, final String theEmail) {
		
		super(theUserId, theFirstName, theLastName, theEmail);
		myAssignedPapers = new HashMap<Integer, List<Integer>>();
		mySubProgramChairs = new ArrayList<Integer>();
		myReviewers = new ArrayList<Integer>();
		myPapers = new ArrayList<Integer>();
	}
	
	/**
	 * Designates SubProgram Chair for a manuscript.
	 * 
	 * @param the_sub_chair SubProgram Chair to oversee the manuscript.
	 * @param the_paper_id paper to be designated.
	 */
	public void selectSubProgramChair(final int theSubChair, 
									  final Paper thePaper) {
		if (!myAssignedPapers.containsKey(theSubChair)) {
			myAssignedPapers.put(theSubChair, new ArrayList<Integer>());
		} 
		myAssignedPapers.get(theSubChair).add(thePaper.getId());
		thePaper.assignSubProgramChair(theSubChair);
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
