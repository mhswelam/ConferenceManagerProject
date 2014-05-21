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
	final int myRoleId = 1;
	/** Map of SubProgram Chairs and their Assigned papers. */
	Map<SubProgramChair, List<Paper>> myAssignedPapers;
	/** List designated SubProgram Chairs. */
	List<SubProgramChair> mySubProgramChairs;
	/** List of reviewers .*/
	List<Reviewer> myReviewers;
	/** Papers submitted to the confirence. */
	List<Paper> myPapers;
	
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
		myAssignedPapers = new HashMap<SubProgramChair, List<Paper>>();
		mySubProgramChairs = new ArrayList<SubProgramChair>();
		myReviewers = new ArrayList<Reviewer>();
		myPapers = new ArrayList<Paper>();
	}
	
	/**
	 * Designates SubProgram Chair for a manuscript.
	 * 
	 * @param the_sub_chair SubProgram Chair to oversee the manuscript.
	 * @param the_paper_id paper to be designated.
	 */
	public void selectSubProgramChair(final SubProgramChair theSubChair, 
									  final Paper thePaper) {
		if (!myAssignedPapers.containsKey(theSubChair)) {
			myAssignedPapers.put(theSubChair, new ArrayList<Paper>());
		} 
		myAssignedPapers.get(theSubChair).add(thePaper);
	}
	
	/**
	 * @return list of designated SubProgram Chairs.
	 */
	public List<SubProgramChair> viewLisSubChairst() {
		return mySubProgramChairs;
	}
	
	/**
	 * @return List of reviewers.
	 */
	public List<Reviewer> viewReviewerList() {
		return myReviewers;
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
							 final PaperStatus theStatus) {
		thePaper.changeStatus(theStatus);
	}
}
