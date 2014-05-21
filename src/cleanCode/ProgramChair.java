package cleanCode;

import cleanCode.Paper;
import cleanCode.PaperStatus;
import cleanCode.SubProgramChair;

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
	}
	
	/**
	 * Designates SubProgram Chair for a manuscript.
	 * 
	 * @param the_sub_chair SubProgram Chair to oversee the manuscript.
	 * @param the_paper_id paper to be designated.
	 */
	public void selectSubProgramChair(final SubProgramChair theSubChair, 
									  final Paper thePaperId) {
		
	}
	
	/**
	 * 
	 */
	public void viewList() {
		System.out.println("View List");
	}
	
	/**
	 * List of reviewers.
	 */
	public void viewReviewerList() {
		
	}
	
	/**
	 * Accepts/Rejects paper for the conference.
	 * 
	 * @param the_paper_id identification number of the 
	 * paper to be accepted/rejected.
	 * @param the_status paper status yes/no.
	 * 
	 */
	public void makeDesicion(final int thePaperId, 
							 final PaperStatus theStatus) {
		
	}
}
