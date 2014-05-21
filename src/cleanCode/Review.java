package cleanCode;
import java.util.ArrayList;

/**
 * @author Clean Code/ Mohamed
 * This class to create a Review.
 * 
 */
public class Review {
	
	/**
	 * This to hold the paper id.
	 */
	public int myPaperId;
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
	private ArrayList<Integer> myComments;
	
	/**
	 * This is a  to create a review.
	 *  
	 * @param aPaperId the paper id.
	 * @param aReviewerId the reviewer id.
	 * @param aFristComment a number from 1 to 5 respond for first Q.
	 * @param aSecondComment a number from 1 to 5 respond for second Q.
	 * @param aThirdComment a number from 1 to 5 respond for third Q.
	 * @param aForthComment a number from 1 to 5 respond for forth Q.
	 */
	public Review(int aPaperId, int aReviewerId, int aFristComment,
			int aSecondComment,int aThirdComment, int aForthComment) {
		myPaperId = aPaperId;
		myReviewerId = aReviewerId;
	    myComments = new ArrayList<Integer>();
	    
		myComments.add(0, aFristComment);
		myComments.add(1, aSecondComment);
		myComments.add(2, aThirdComment);
		myComments.add(3, aForthComment);
	}
	
	/**
	 * This to return the reviewer id 
	 * @return reviewer id type int.
	 */
	public int getMyReviewerId() {
		return myReviewerId;
	}

}
