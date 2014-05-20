/**
 * @author Clean Code
 * This class to create a Program Chair
 * 
 * @author Polina Kud
 *
 */
public class ProgramChair {
	/** Unique user identification number of the Program Chair. */
	int myUserId;
	
	/**
	 * Creates a designated Program Chair
	 */
	public ProgramChair(final int theUserId) {
		myUserId = theUserId;
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
