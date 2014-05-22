package cleanCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clean Code
 * This class to create a Paper
 * 
 * @author Polina Kud
 *
 */
public class Paper {
	/** Maximum number of reviews and reviewers for the paper. */
	private final static int NUM_REVIEW = 3;
	
	/** Unique identification number of the paper. */
	private int myId;
	/** How many people are reviewing this paper*/
	private int reviewed;
	/** Title of the paper. */
	private String myTitle;
	/** Author of the paper. */
	private int myAuthor;
	/** Review status of the paper. */
	private boolean myReviewed;
	/** Subprogram Chair in charge of the paper. */
	private int mySubProgramChair;
	/** List of 3 reviews for the paper. */
	private List<Integer> myReviews;
	/** List of 3 reviewers assigned to the paper. */
	private List<Integer> myReviewers;
	/** Recommendation of SubProgram Chair. */
	private Recommendation myRecommendation;
	/** Acceptance Status of the paper. */
	private PaperStatus myAcceptanceStatus;
	
	
	/**
	 * Creates a new paper. 
	 * Initial paper status: Undecided.
	 * Initially no reviewers are assigned.
	 * The paper has not been reviewed.
	 * There is no recommendation from SubProgram Chair.
	 * 
	 * @param theId unique identification number of the paper.
	 * @param theAuthor author of the paper.
	 * @param theTitle title of the paper.
	 */
	public Paper(final int theId, final int theAuthor, final String theTitle) {
		myId = theId;
		reviewed = 0;
		myTitle = theTitle;
		myAuthor = theAuthor;
		myAcceptanceStatus = PaperStatus.Undecided;
		
		mySubProgramChair = 0;
		myReviewers = new ArrayList<Integer>();
		myReviews = new ArrayList<Integer>();
		
		myReviewed = false;
		myRecommendation = null;
	}
	
	/**
	* Assigns a reviewer to review the paper. 
	* 
	* @param theReviewer reviewer of the paper.
	*/
	public void addReviewer(final int theReviewerId) {
		if (myReviewers.size() < NUM_REVIEW) {
			myReviewers.add(theReviewerId);
		}
	}

	/**
	* Adds review to the paper.
	* 
	* @param theReview review of the paper.
	*/
	public void review(final int theReviewId) {
		if (myReviews.size() < NUM_REVIEW) {	
			myReviews.add(theReviewId);
		}
		isReviewed();
	}

	/**
	 * SubProgram Chair adds recommendation to the paper for Program Chair.
	 * 
	 * @param theRecommendation recommendation form from SubProgram Chair.
	 */
	public void addRecommendation(final Recommendation theRecommendation) {
		myRecommendation = theRecommendation;
	}
	
	/**
	* Changes the reviewed status of the paper
	* if the maximum number of reviews has been 
	* submitted.
	*/

	private void isReviewed() {
		if (myReviews.size() == NUM_REVIEW) {
			myReviewed = true;
		}
	}

	/**
	* Assigned SubProgram chair to the paper.
	* 
	* @param theSubChair SubProgram Chair selected for the paper.
	*/
	public void assignSubProgramChair(final int theSubChairId) {
		mySubProgramChair = theSubChairId;
	}

	/**
	* @return SubProgram Chair designated for the paper.
	*/
	public int getSubProgramChair() {
		return mySubProgramChair;
	}


	/**
	* 
	* @return Unique identification number of the paper.
	*/
	public int getId() {
		return myId;
	}

	/**
	* Downloads the paper.
	*/
	public void download() {
		
	}

	/**
	* Uploads the paper.
	*/
	public void upload() {

	}

	/**
	* Change paper status to Accepted/Rejected. 
	* Initially the status is Undecided.
	* 
	* @param theStatus Accepted / Rejected status of the paper.
	*/
	public void changeStatus(final PaperStatus theStatus) {
		myAcceptanceStatus = theStatus;
	}

	/** 
	* Status of the paper.
	* Initially Undecided. 
	* ProgramChair specifies if the paper is 
	* accepted / denied to the conference.
	* 
	* @return Accepted, Denied, Undecided.
	*/
	public PaperStatus status() {
		return myAcceptanceStatus;
	}
}