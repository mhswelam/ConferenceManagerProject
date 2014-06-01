package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a submit paper panel for the author.
 *
 */
public class UI_SubmitPaper extends JPanel {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Conference. */
	private Conference myConference;
	
	/**
	 * Creates a panel containing the submission sheet and a 
	 * dialog allowing the Author to submit their manuscript.
	 */
	public UI_SubmitPaper(final Conference theConference) {
		super(new BorderLayout());
		myConference = theConference;
	}

}
