package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Collection;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

/**
 * @author Clean Code
 * This class to create a list of papers.
 *
 */
public class UI_PaperList extends JPanel {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);

	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	
	/**
	 * Creates a list of papers.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_PaperList(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myConference = theConference;
	}
	
	/**
	 * Sets up the list on a panel.
	 */
	public void setUp() {
		add(makePaperList());
	}
	
	/**
	 * Creates a list of papers.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 * 
	 * @return a list of papers.
	 */
   private JList makePaperList() {
		 //just for Program Chair
		   Collection<Paper> paperSet = myConference.listOfPaper.values();
		   String[] paperNames = new String[paperSet.size()];
		   int i = 0;
		   for (Paper paper : paperSet) {
			   paperNames[i] = paper.getTitle();
			   i++;
		   }
		   JList<String> list = new JList<String>(paperNames);
		   
		   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   list.setLayoutOrientation(JList.VERTICAL);
		   list.setSelectedIndex(0);
		   
		   //not sure if this is needed
//			   JScrollPane paperPanel = new JScrollPane(list);
//			   paperPanel.setPreferredSize(new Dimension(100, 150));
//			   paperPanel.add(list);
//			   return paperPanel;
		   
		   return list;
	   }

}
