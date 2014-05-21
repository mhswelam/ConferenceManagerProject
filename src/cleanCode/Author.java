
package cleanCode;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Clean Code / Jorge Meneses
 * 
 * Class to create an Author.
 */
public class Author extends User
{
	/** The max amount of papers that can be assigned to and author. */
	final int MAX_PAPERS = 4;
	
	/** The unique role ID for an author. */
	final int ROLE_ID = null;
	
	/** The amount of papers that have been assigned to and author. */
	int papersAssigned = 0;
	
	/** An array of Papers that have been submitted. */
	ArrayList<Paper> submittedPapers = new ArrayList<Paper>();
	
	public Author(int aUserId, String aFirstName, String aLastName, String anEmail)
	{
		super(aUserId, aFirstName, aLastName, anEmail);
	}
	
	/**
	 * Submits a new paper to the conference.
	 * 
	 * @param idPaper The paper ID
	 */
	private void submitPaper(int idPaper)
	{
		String title = JOptionPane.showInputDialog("Please enter a title for the paper.");
		Paper newPaper = new Paper(idPaper, this, title);
		submittedPapers.add(newPaper);
	}
	
	/**
	 * See reviews for a certain paper.
	 * 
	 * @param idPaper The paper ID
	 */
	private Review seeReviews(int idPaper)
	{
		Paper paper = submittedPapers.get(idPaper);
		
		if (!paper.myReviewed) return null;
		else
		{
			if (paper.myReview0 != null)
			{
				return paper.myReview0;
			}
			
			if (paper.myReview1 != null)
			{
				return paper.myReview1;
			}
			
			if (paper.myReview2 != null)
			{
				return paper.myReview2;
			}
		}
	}
	
	/**
	 * Edit a particular paper.
	 * 
	 * @param idPaper The paper ID
	 */
	private Paper editPaper(int idPaper)
	{
		unsubmitPaper(idPaper);
		submitPaper(idPaper);
	}
	
	/**
	 * Unsubmit a particular paper.
	 * 
	 * @param idPaper The paper ID
	 */
	private void unsubmitPaper(int idPaper)
	{
		for (int i = 0; i < submittedPapers.size(); i++)
		{
			if(submittedPapers.get(i).myId == idPaper)
			{
				submittedPapers.remove(i);
			}
		}
	}
}
