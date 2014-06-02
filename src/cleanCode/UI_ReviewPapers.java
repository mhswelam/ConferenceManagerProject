package cleanCode;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class creates form that the Reviewer fills out when reviewing papers.
 *
 */
public class UI_ReviewPapers extends JPanel {
	
	/**
	 * Creates a panel that contains a list of papers and a form for
	 * each selected paper. The reviewer can fill it out to review the paper.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_ReviewPapers(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
	}

}
