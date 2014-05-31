
package cleanCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clean Code / Jorge Meneses
 * 
 * Class to create an Author.
 */
public class Author extends User {
	/** The max amount of papers that can be assigned to and author. */
	private final static int MAX_PAPERS = 4;
	
	/** The unique role ID for an author. */
	private final static int ROLE_ID = 0;
	
	/** Conference. */
//	private Conference myConference;
	
	/** The amount of papers that have been assigned to and author. */
	private int myPapersAssigned;
	
	/** An array of Papers that have been submitted. */
	private List<Integer> mySubmittedPapers;
	
	
	/**
	 * Creates an author.
	 * 
	 * @param aUserId unique identification number of the user.
	 * @param aFirstName authors first name.
	 * @param aLastName authors last name.
	 * @param anEmail authors email address.
	 */
	public Author(final int aUserId, final String aFirstName, final String aLastName, 
			final String anEmail) {
		super(aUserId, aFirstName, aLastName, anEmail);
		mySubmittedPapers = new ArrayList<Integer>();
		myPapersAssigned = 0;
//		myConference = theConference; 
	}
	
	/**
	 * Submits a new paper to the conference.
	 * 
	 * @param idPaper The paper ID
	 * @param theTitle title of the paper.
	 */
	public void submitPaper(final int thePaperId, final String theTitle) {
		
		Paper newPaper = new Paper(thePaperId, myUserId, theTitle);
		mySubmittedPapers.add(newPaper.getId());
		//submittedPapers.add(newPaper);
	}
	
	/**
	 * Author edits the paper.
	 * 
	 * @param thePaperId unique identification number of the paper.
	 */
	public void editPaper(final int thePaperId) {
//		myConference.listOfPaper.get(thePaperId);
//		mySubmittedPapers.get(thePaperId);
		//still working on this one
	}
	
	/**
	 * @return number of papers author has been assigned.
	 */
	public int getNumAssinged() {
		return myPapersAssigned;
	}
	
	/**
	 * @return list of all the papers author has submitted.
	 */
	public List<Integer> getSubmittedPapers() {
		return mySubmittedPapers;
	}
	
	/**
	 * Deletes the paper from the conference.
	 * 
	 * @param thePaperId unique paper identification number.
	 */
	public void unsubmitPaper(final int thePaperId) {
		for (int i = 0; i < mySubmittedPapers.size(); i++) {
			int id = mySubmittedPapers.get(i);
			if (id == thePaperId) {
				mySubmittedPapers.remove(i);
//				myConference.removePaper(thePaperId);
			}
		}
	}
	
	/**
	 * @param thePaperId unique paper identification number.
	 * 
	 * @return returns reviews for the specified paper.
	 */
	public Review seeReview(final int thePaperId) {
		for (int i = 0; i < mySubmittedPapers.size(); i++) {
			int id = mySubmittedPapers.get(i);
			if (thePaperId == id) {
//				return myConference.getReview(thePaperId);
			}
		}
		return null;
	}
}
