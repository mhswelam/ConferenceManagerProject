package cleanCode;
import java.util.ArrayList;

/**
 * @author Clean Code/ Mohamed
 * This class to create a Review.
 * 
 */

public class Review {
	
	
	/**
	 * This to hold the review id.
	 */
	private int myReviewId;
	

	/**
	 * This to hold the paper id.
	 */
	private int myPaperId;
	/**
	 * This to hold the Reviewer id.
	 */
	private int myReviewerId;
	

	/**
	 * This to hold number system for the comments to Author.
	 * the array will hold 4 integers with values form 1 to 5 
	 * the inputs will be validated at UI or by creating input drop list
	 * 
	 */
	private int[] myComments;
	
	private String mySummary;
	
	/**
	 * This is a  to create a review.
	 * 
	 * @param myReviewId the review id.
	 * @param aPaperId the paper id.
	 * @param aReviewerId the reviewer id.
	 * @param aFristComment a number from 1 to 5 respond for first Q.
	 * @param aSecondComment a number from 1 to 5 respond for second Q.
	 * @param aThirdComment a number from 1 to 5 respond for third Q.
	 * @param aForthComment a number from 1 to 5 respond for forth Q.
	 */
	public Review(int aReviewId, int aPaperId, int aReviewerId, int aFristComment,
			int aSecondComment,int aThirdComment, int aForthComment, int aFivthComment, 
			int aSixthComment, int aSeventhComment, int aEighthComment, int aNinethComment, 
			String aSummary) {
		myReviewId = aReviewId;
		myPaperId = aPaperId;
		myReviewerId = aReviewerId;
	    myComments = new int [9];
	    
		myComments[0] = aFristComment;
		myComments[1] = aSecondComment;
		myComments[2] = aThirdComment;
		myComments[3] = aForthComment;
		myComments[4] = aFivthComment;
		myComments[5] = aSixthComment;
		myComments[6] = aSeventhComment;
		myComments[7] = aEighthComment;
		myComments[8] = aNinethComment;
		mySummary = aSummary;
		
		
	}
	
	/**
	 * This to return the reviewer id 
	 * @return reviewer id type int.
	 */
	public int getMyReviewerId() {
		return myReviewerId;
	}
	
	
	/**
	 * This to return the paper id 
	 * @return paper id type int.
	 */
	public int getMyPaperId() {
		return myPaperId;
	}

	/**
	 * This to return array of integer that respond to the review questions.  
	 * @return Array with number respond to the review questions.
	 */
	public int [] getMyComments() {
		return myComments;
	}
	
	/**
	 * This to return the review id   
	 * @return Array with number respond to the review questions.
	 */
	public int getMyReviewId() {
		return myReviewId;
	}

	/**
	 * This to return the summary 
	 * @return The summary.
	 */
	public String getMySummary() {
		return mySummary;
	}
	
	/**
	 * Averaged out summary of all reviews.
	 * @return
	 */
	public int getReviewSummary() {
		int total = 0;
		for (int i = 0; i < myComments.length; i++) {
			total += myComments[i];
		}
		total /= myComments.length;
		return total;
	}
}
