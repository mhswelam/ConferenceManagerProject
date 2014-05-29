
package cleanCode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	public Author(final int aUserId, final String aFirstName, final String aLastName, final String anEmail) {
		super(aUserId, aFirstName, aLastName, anEmail);
		mySubmittedPapers = new ArrayList<Integer>();
		myPapersAssigned = 0;
	}
	
	/**
	 * Submits a new paper to the conference.
	 * 
	 * @param idPaper The paper ID
	 */
	public void submitPaper(final int thePaperId) {
		String title = JOptionPane.showInputDialog("Please enter a title for the paper.");
		//Paper newPaper = new Paper(idPaper, this, title);
		//submittedPapers.add(newPaper);
	}
	
	/**
	 * Author edits the paper.
	 * 
	 * @param thePaperId unique identification number of the paper.
	 */
	public void editPaper(final int thePaperId) {
		mySubmittedPapers.get(thePaperId);
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
				//also delete the paper from database
			}
		}
	}
	
	/**
	 * @param thePaperId unique paper identification number.
	 * 
	 * @return returns list of reviews for the specified paper.
	 */
	public int[] seeReviews(final Paper thePaper) {
		for (int i = 0; i < mySubmittedPapers.size(); i++) {
			int id = mySubmittedPapers.get(i);
			if (thePaper.getId() == id) {
				return thePaper.getReviews();
			}
		}
		return null; //?? Still working on this one
	}
}
