package cleanCode;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for paper Info.
 *
 */
public class UI_PaperInfo extends JPanel {
	/** Conference. */
	private Conference myConference;
	
	/**
	 * Creates information panel for a paper.
	 * 
	 * @param theRoleId role of the user viewing paper info.
	 * @param theUserId identification number of the user.
	 * @param theConference the conference.
	 */
	public UI_PaperInfo(final int theRoleId, final int theUserId, 
			final Conference theConference) {
		super(new BorderLayout());
		myConference = theConference;
	}

	/**
	 * Sets up the panel.
	 */
	public void setUp() {
		
	}
}
