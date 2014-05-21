package cleanCode;

/**
 * @author Clean Code
 * This class to create a Paper
 * 
 * @author Polina Kud
 *
 */
public class Paper {
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
		myAssignedReviewer0 = 0; 
		myAssignedReviewer1 = 0;
		myAssignedReviewer2 = 0;
		myReviewed = false;
		myReview0 = null;
		myReview1 = null;
		myReview2 = null;
		myRecommendation = null;
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