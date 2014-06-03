package cleanCode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Test Review class.
 * @author Polina Kud
 *
 */
public class ReviewTest {
	public static void main(String[] args) {
		
	}

	/**
	 * Tests the id validity of a review.
	 */
	@Test
	public void testGeMyReviewID() {
		Review testReviewOne = new Review(00555, 00001, 1, 2, 3,3,3,3,4,3,3,3,"good");
		int output = testReviewOne.getMyReviewerId();
		int expected = 00001;
		assertEquals(output, expected);
	}
	
	/**
	 * Tests the paper id.
	 */
	@Test
	public void testGetPaperId() {
		Review testReviewTwo = new Review(00555, 00001, 1, 2, 3,3,3,3,4,3,3,3,"good");
		int output = testReviewTwo.getMyPaperId();
		int expected = 00545;
		assertEquals(output, expected);
	}
	
	/**
	 * Tests get my comments method.
	 */
	@Test
	public void testGetMyComments() {
		Review testReviewThree = new Review(00555, 00001, 1, 2, 3,3,3,3,4,3,3,3,"good");
		int [] output = testReviewThree.getMyComments();
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		assertEquals(output, expected);
	}
}
