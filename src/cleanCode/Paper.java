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
	int myId;
	/** How many people are reviewing this paper*/
	public int reviewed;
	/** Title of the paper. */
	String myTitle;
	/** Author of the paper. */
	Author myAuthor;
	/** Review status of the paper. */
	boolean myReviewed;
	/** Reviewer assigned to review the paper. */
	int myAssignedReviewer0;
	/** Reviewer assigned to review the paper. */
	int myAssignedReviewer1;
	/** Reviewer assigned to review the paper. */
	int myAssignedReviewer2;
	/** Subprogram Chair in charge of the paper. */
	SubProgramChair mySubProgramChair;
	/** Review of the paper. */
	Review myReview0;
	/** Review of the paper. */
	Review myReview1;
	/** Review of the paper. */
	Review myReview2;
	/** List of 3 reviews for the paper. */
	List<Review> myReviews;
	/** List of 3 reviewers assigned to the paper. */
	List<Reviewer> myReviewers;
	/** Recommendation of SubProgram Chair. */
	Recommendation myRecommendation;
	/** Acceptance Status of the paper. */
	PaperStatus myAcceptanceStatus;
	
	
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
	public Paper(final int theId, final Author theAuthor, final String theTitle) {
		myId = theId;
		reviewed = 0;
		myTitle = theTitle;
		myAuthor = theAuthor;
		myAcceptanceStatus = PaperStatus.Undecided;
		
		mySubProgramChair = null;
		myReviewers = new ArrayList<Reviewer>();
		myReviews = new ArrayList<Review>();
		
//		myAssignedReviewer0 = 0; 
//		myAssignedReviewer1 = 0;
//		myAssignedReviewer2 = 0;
		myReviewed = false;
//		myReview0 = null;
//		myReview1 = null;
//		myReview2 = null;
		myRecommendation = null;
	}
	
	/**
	* Assigns a reviewer to review the paper. 
	* Total of 3 reviewers.
	* 
	* @param theReviewer reviewer of the paper.
	*/
	public void assignReviewer(final Reviewer theReviewer) {
	if (myReviewers.size() < NUM_REVIEW) {
		myReviewers.add(theReviewer);
	}
	}

	/**
	* Adds review to the paper.
	* Total of 3 reviews.
	* 
	* @param theReview review of the paper.
	*/
	public void review(final Review theReview) {
	if (myReviews.size() < NUM_REVIEW) {	
		myReviews.add(theReview);
	}
	isReviewed();
	}

	/**
	* Changes the reviewed status of the paper
	* if the maximum number of reviews has been s
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
	public void assignSubProgramChair(final SubProgramChair theSubChair) {
		mySubProgramChair = theSubChair;
	}

	/**
	* @return SubProgram Chair designated for the paper.
	*/
	public SubProgramChair getSubProgramChair() {
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