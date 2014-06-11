package cleanCode;


/**
 * @author Clean Code
 * This class to create a Paper
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
	private int[] myReviews;
	/** List of 3 reviewers assigned to the paper. */
	private int[] myReviewers;

	
	
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
		this(theId, theAuthor, theTitle, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
				"Undecided");
	}
	
	/**
	 * Creates a new paper.
	 * 
	 * @param theId unique identification number of the paper.
	 * @param theAuthorId unique identification number of the author
	 * @param theTitle title of the paper.
	 * @param theNumOfReviewer number of assigned reviewers.
	 * @param theSubProgId unique identification number of the Subprogram Chair.
	 * @param theRecommendId Subprogram Chair recommendation id number.
	 * @param theReviewOneId identification number of the first review.
	 * @param theReviewTwoId identification number of the second review.
	 * @param theReviewThreeId identification number of the third review.
	 * @param theReviewerOneId identification number of the first reviewer.
	 * @param theReviewerTwoId identification number of the second reviewer.
	 * @param theReviewerThreeId identification number of the third reviewer.
	 * @param theStatus acceptance status of the paper.
	 */
	public Paper(final int theId, final int theAuthorId, final String theTitle, 
				final int theNumOfReviewer,final int theSubProgId, 
				final int theRecommendId, final int theReviewOneId, 
				final int theReviewTwoId, final int theReviewThreeId, 
				final int theReviewerOneId, final int theReviewerTwoId, 
				final int theReviewerThreeId, final String theStatus)  {
		
		this(theId, theAuthorId, theTitle, theNumOfReviewer, theSubProgId, 
				theRecommendId, theReviewOneId, theReviewTwoId, theReviewThreeId, 
				theReviewerOneId, theReviewerTwoId, theReviewerThreeId, 
				theStatus, false);
	}
	
	/**
	 * Creates a new paper.
	 * 
	 * @param theId unique identification number of the paper.
	 * @param theAuthorId unique identification number of the author
	 * @param theTitle title of the paper.
	 * @param theNumOfReviewer number of assigned reviewers.
	 * @param theSubProgId unique identification number of the Subprogram Chair.
	 * @param theRecommendId Subprogram Chair recommendation id number.
	 * @param theReviewOneId identification number of the first review.
	 * @param theReviewTwoId identification number of the second review.
	 * @param theReviewThreeId identification number of the third review.
	 * @param theReviewerOneId identification number of the first reviewer.
	 * @param theReviewerTwoId identification number of the second reviewer.
	 * @param theReviewerThreeId identification number of the third reviewer.
	 * @param theStatus acceptance status of the paper.
	 * @param theReviewed true if the reviewers have submitted all the reviews.
	 */
	public Paper(final int theId, final int theAuthorId, final String theTitle, 
			final int theNumOfReviewer,final int theSubProgId, 
			final int theRecommendId, final int theReviewOneId, 
			final int theReviewTwoId, final int theReviewThreeId, 
			final int theReviewerOneId, final int theReviewerTwoId, 
			final int theReviewerThreeId, final String theStatus, 
			final boolean theReviewed)  {
		
		myId = theId;
		myAuthor = theAuthorId;
		myTitle = theTitle;
		numReviewers = theNumOfReviewer;
		mySubProgramChair = theSubProgId;
		myRecommendation = theRecommendId;
		
		myReviews = new int[NUM_REVIEW];
		myReviews[0] = theReviewOneId;
		myReviews[1] = theReviewTwoId;
		myReviews[2] = theReviewThreeId;
		
		myReviewers = new int[NUM_REVIEW];
		myReviewers[0] = theReviewerOneId;
		myReviewers[1] = theReviewerTwoId;
		myReviewers[2] = theReviewerThreeId;
		
		myStatus = theStatus;
		myReviewed = theReviewed;
	}
	
	/**
	* Assigns a reviewer to review the paper. 
	* 
	* @param theReviewer Reviewer of the paper.
	*/
	public void addReviewer(final int theReviewerId) {
		if (numReviewers < NUM_REVIEW) {
			for (int i = 0; i < NUM_REVIEW; i++) {
				if (myReviewers[i] == 0) {
					myReviewers[i] = theReviewerId;
					numReviewers++;
					break;
				}
			}
		}
	}

	/**
	* Adds review to the paper.
	* 
	* @param theReview review of the paper.
	*/
	public void addReview(final int theReviewId) {
		if (!myReviewed) {
			for (int i = 0; i < NUM_REVIEW; i++) {
				if (myReviews[i] == 0) {
					myReviews[i] = theReviewId;
					if (i == 2) {
						myReviewed = true;
					}
					break;
				}
			}
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
	public int[] getReviewers() {
		return myReviewers;
	}
	
	/**
	 * @return List of completed reviews.
	 */
	public int[] getReviews() {
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
	
	public String toString() {
		return myTitle;
	}
}