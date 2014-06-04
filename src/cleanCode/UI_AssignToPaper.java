package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to a page that assigns users to papers.
 *
 */
public class UI_AssignToPaper extends JPanel {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** unique identification number of the paper that is displayed. */
	private int myPaperId;
	/** Conference. */
	private Conference myConference;
	private JLabel myAuthorLabel;
	private JLabel myTitleLabel;
	private JComboBox myAssignSPC;
	
	/**
	 * Creates a panel that contains all information 
	 * needed to assign paper to a user.
	 * 
	 * @param theTheUserId unique user identification number.
	 * @param thePaperId unique identification number of the paper that is displayed. 
	 * @param theRoleId role identification number.
	 * @param theConference conference.
	 */
	public UI_AssignToPaper(final int theUserId, final int theRoleId, 
			final int thePaperId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myPaperId = thePaperId;
		myConference = theConference;
		myAuthorLabel = new JLabel();
		myTitleLabel = new JLabel();
		
	}
	
	public void setUp() {
		JPanel content = new JPanel();
		Paper paper = myConference.getPaper(myPaperId);
		String title = paper.getTitle();
		int authorId = paper.getAuthor();
		String firstName = myConference.getAuthor(authorId).myFristName;
		String lastName = myConference.getAuthor(authorId).myLastName;
		
		myAuthorLabel.setText("Authors Name: " + firstName + " " + lastName);
		myTitleLabel.setText("Title: " + title);
		JLabel assign = new JLabel("Assign Subprogram Chair: ");
		
		ArrayList<SubProgramChair> availableSPC = myConference.getAvaSubProgram();
		String[] subChairs = new String[availableSPC.size()];
		for (SubProgramChair spc : availableSPC) {
			String name = spc.myFristName + " " + spc.myLastName;
		}
		myAssignSPC = new JComboBox(subChairs);
		content.add(myAuthorLabel);
		content.add(myTitleLabel);
		content.add(myAssignSPC);
		add(content);
	}

	private void getPaperInfo() {
		Paper paper = myConference.getPaper(myPaperId);
		String title = paper.getTitle();
		int authorId = paper.getAuthor();
		String firstName = myConference.getAuthor(authorId).myFristName;
		String lastName = myConference.getAuthor(authorId).myLastName;
	}
	

}
