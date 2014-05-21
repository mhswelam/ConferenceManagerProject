package cleanCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecommendationTest {
	
	/**
	 * This method to test getmypaperId.
	 */
	@Test
	public void testgetMyPaperId() {
		
		Recommendation myRec = new Recommendation(122, 252, 5, "This paper is good");
		int output = myRec.getMyPaperID();
		int excepected = 122;
		assertEquals(excepected, output);
	}

	/**
	 * This method to test getmySubProgramId.
	 */
	@Test
	public void testgetMySubProgramId() {
		
		Recommendation myRec = new Recommendation(122, 252, 5, "This paper is good");
		int output = myRec.getMySubProgramID();
		int excepected = 252;
		assertEquals(excepected, output);
	}
	
	/**
	 * This method to test getGrade.
	 */
	@Test
	public void testgetGrade() {
		
		Recommendation myRec = new Recommendation(122, 252, 5, "This paper is good");
		int output = myRec.getGrade();
		int excepected = 5;
		assertEquals(excepected, output);
	}
	
	
	/**
	 * This method to test getRational.
	 */
	@Test
	public void testgetRational() {
		
		Recommendation myRec = new Recommendation(122, 252, 5, "This paper is good");
		String output = myRec.getRational();
		String excepected = "This paper is good";
		assertEquals(excepected, output);
	}
}
