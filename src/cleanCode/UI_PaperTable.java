package cleanCode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Clean Code
 * This class to create a table containing information at a glance.
 *
 */
public class UI_PaperTable extends JPanel {
	/** Column headers of the table. */
	private final static String[] COLUMN_NAMES = {"Author", "Title", "Review 1", "Review 2", "Review 3", "Subprogram Chair"};
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** Conference. */
	private Conference myConference;
	
	/**
	 * Creates a table containing all the papers.
	 * 
	 * @param theTheUserId unique user identification number.
	 * @param theRoleId role identification number.
	 * @param theConference conference.
	 */
	public UI_PaperTable(final int theUserId, final int theRoleId, 
			final Conference theConference) {
		super(new FlowLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myConference = theConference;
		setUp();
	}

	public void setUp() {
		JTable table = new JTable(getData(), COLUMN_NAMES);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(BACKGROUND_COLOR);
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(700, 500));
		table.setBackground(BACKGROUND_COLOR);
		add(scrollPane);
	}
	
	/**
	 * Retrieves all paper data for the table. 
	 * 
	 * @return data from all the papers.
	 */
	private String[][] getData() {
		ArrayList<Paper> paperList = myConference.getPaperList(myRoleId, myUserId);
		String[][] data = new String[paperList.size()][COLUMN_NAMES.length];
		
		int i = 0;
		for (Paper paper : paperList) {
			System.out.println(paper.getAuthor());
			int authorId = paper.getAuthor();
			String authorFirstName = myConference.getAuthor(authorId).myFristName;
			String authorLastName = myConference.getAuthor(authorId).myLastName;
			String title = paper.getTitle();
			String r1 = "N/A";
			String r2 = "N/A";
			String r3 = "N/A";
			int scr = paper.getRecommendation();
			data[i][0] = authorFirstName + " " + authorLastName;
			data[i][1] = title;
			data[i][2] = r1;
			data[i][3] = r2;
			data[i][4] = r3;
			data[i][5] = "" + scr;
			i++;
		}
		return data;
	}
}
