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
	private int numReviewers;
	/** Title of the paper. */
	private String myTitle;
	/** Author of the paper. */
	private int myAuthor;
	/** Review status of the paper. */
	private boolean myReviewed;
	/** Subprogram Chair in charge of the paper. */
	private int mySubProgramChair;
	
	/** Recommendation of SubProgram Chair. */
	private int myRecommendation;
	/** Acceptance Status of the paper. */
	private String myStatus;
	
	/** List of 3 reviews for the paper. */
	private List<Integer> myReviews;
	/** List of 3 reviewers assigned to the paper. */
	private List<Integer> myReviewers;

	
	
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
		this(theId, theAuthor, theTitle, 0, 0, 0, 0, 0, 0, 0, 0, 0, "Undecided");
	}
	
	
	public Paper(final int theId, final int theAuthorId, final String theTitle, 
				final int theNumOfReviewer,final int theSubProgId, final int theRecommendId, 
				final int theReviewOneId, final int theReviewTwoId, final int theReviewThreeId, 
				final int theReviewerOneId, final int theReviewerTwoId, 
				final int theReviewerThreeId, final String theStatus)  {
		
		this(theId, theAuthorId, theTitle, theNumOfReviewer, theSubProgId, 
				theRecommendId, theReviewOneId, theReviewTwoId, theReviewThreeId, 
				theReviewerOneId, theReviewerTwoId, theReviewerThreeId, theStatus, false);
	}
	
	public Paper(final int theId, final int theAuthorId, final String theTitle, 
			final int theNumOfReviewer,final int theSubProgId, final int theRecommendId, 
			final int theReviewOneId, final int theReviewTwoId, final int theReviewThreeId, 
			final int theReviewerOneId, final int theReviewerTwoId, 
			final int theReviewerThreeId, final String theStatus, final boolean theReviewed)  {
		
		myId = theId;
		myAuthor = theAuthorId;
		myTitle = theTitle;
		numReviewers = theNumOfReviewer;
		mySubProgramChair = theSubProgId;
		myRecommendation = theRecommendId;
		
		myReviews = new ArrayList<Integer>();
		myReviews.add(theReviewOneId);
		myReviews.add(theReviewTwoId);
		myReviews.add(theReviewThreeId);
		
		myReviewers = new ArrayList<Integer>();
		myReviewers.add(theReviewerOneId);
		myReviewers.add(theReviewerTwoId);
		myReviewers.add(theReviewerThreeId);
		
		myStatus = theStatus;
		myReviewed = theReviewed;
	}
	
	/**
	* Assigns a reviewer to review the paper. 
	* 
	* @param theReviewer Reviewer of the paper.
	*/
	public void addReviewer(final int theReviewerId) {
		if (myReviewers.size() < NUM_REVIEW) {
			myReviewers.add(theReviewerId);
			numReviewers++;
		}
	}

	/**
	* Adds review to the paper.
	* 
	* @param theReview review of the paper.
	*/
	public void addReview(final int theReviewId) {
		if (myReviews.size() < NUM_REVIEW) {	
			myReviews.add(theReviewId);
		}
		reviewed();
	}
	
	/**
	* Changes the reviewed status of the paper
	* if the maximum number of reviews has been 
	* submitted.
	*/
	private void reviewed() {
		if (myReviews.size() == NUM_REVIEW) {
			myReviewed = true;
		}
	}

	/**
	 * SubProgram Chair adds recommendation to the paper for Program Chair.
	 * 
	 * @param theRecommendation recommendation form from SubProgram Chair.
	 */
	public void addRecommendation(final int theRecommendationId) {
		myRecommendation = theRecommendationId;
	}

	/**
	* Assigned SubProgram chair to the paper.
	* 
	* @param theSubChair Identification number of 
	* SubProgram Chair selected for the paper.
	*/
	public void assignSubProgramChair(final int theSubChairId) {
		mySubProgramChair = theSubChairId;
	}
	
	/**
	* Change paper status to Accepted/Rejected. 
	* Initially the status is Undecided.
	* 
	* @param theStatus Accepted / Rejected status of the paper.
	*/
	public void changeStatus(final String theStatus) {
		myStatus = theStatus;
	}

	/**
	 * @return true is all Reviewers have submitted their reviews. 
	 * False otherwise.
	 */
	public boolean isReviewed() {
		return myReviewed;
	}
	
	/**
	 * @return List of Reviewers for this paper. 
	 */
	public List<Integer> getReviewers() {
		return myReviewers;
	}
	
	/**
	 * @return List of completed reviews.
	 */
	public List<Integer> getReviews() {
		return myReviews;
	}
	
	/**
	* @return Identification number of SubProgram 
	* Chair designated for the paper.
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
	 * @return Title of the manuscript.
	 */
	public String getTitle() {
		return myTitle;
	}
	
	/**
	 * @return Recommendation from SubProgram Chair.
	 */
	public int getRecommendation() {
		return myRecommendation;
	}

	/** 
	* Status of the paper.
	* Initially Undecided. 
	* ProgramChair specifies if the paper is 
	* accepted / denied to the conference.
	* 
	* @return Accepted, Denied, Undecided.
	*/
	public String getStatus() {
		return myStatus;
	}
	
	/**
	 * @return number of reviewers.
	 */
	public int getNumReviewers() {
		return numReviewers;
	}

	/**
	 * @return Identification number of the Author of this paper.
	 */
	public int getAuthor() {
		return myAuthor;
	}
	
	//Author submits the paper into the database.
	
	/**
	* Downloads the paper.
	*/
	public void download() {
		
	}
	
	//Constructor will upload the paper
	/**
	* Uploads the paper.
	*/
	public void upload() {

	}
}