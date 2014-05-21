package cleanCode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReviewTest {

	/**
	 * Tests the id validity of a review.
	 */
	@Test
	public void testGeMyReviewID() {
		Review testReviewOne = new Review(00555, 00001, 1, 2, 3, 4);
		Review testReviewTwo = new Review(00545, 00001, 1, 2, 3, 4);
		int output = testReviewOne.getMyReviewerId();
		int expected = 00001;
		assertEquals(output, expected);
	}
}
