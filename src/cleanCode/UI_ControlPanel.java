package cleanCode;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

/**
 * @author Clean Code
 * This class to create a user interface for the Control Panel.
 *j
 */
public class UI_ControlPanel extends JPanel { 
	/** Tasks for each role. 
	 * Tasks at index 0 belongs to Author, 
	 * Tasks at index 1 belongs to Reviewer,
	 * Tasks at index 2 belong to Subprogram Chair,
	 * Tasks at index 3 belong to Program Chair. */
	private final static String[][] TASKS = {
		{"View Papers", "Submit Paper", "Edit Paper", "Unsubmit Paper"}, 	//Author
		{"View Papers", "Review Papers"}, 										   	//Reviewer
		{"View Papers", "Assign Papers", "Recommend Paper", "View Reviewers"},		//Subprogram Chair
		{ "View Papers", "Assign Papers", "Make Acceptance Decision",				//Program Chair
			"View Subprogram Chairs", "View Reviewers", "View Authors"}};
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Tabbed pane. */
	private JTabbedPane myTabbedPane;
	/** List of the tabbed panels .*/
	private List<JComponent> myTextPanels;
	/** Conference .*/
	private Conference myConference;
	
	/**
	 * Creates panel that includes task tabs.
	 * 
	 * @param theConference conference.
	 */
	public UI_ControlPanel(final Conference theConference) {
		super(new GridLayout(1, 1));
		setBackground(BACKGROUND_COLOR);
		myConference = theConference;
		myTabbedPane = new JTabbedPane();
		myTextPanels = new ArrayList<JComponent>();
	}
	
	/**
	 * Sets up the Panel.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	public void setUp(final int theUserId, final int theRoleId) {
		int size = TASKS[theRoleId].length;
		for (int i = 0; i < size; i++) {
			JComponent tab = null;
			//View Paper for any user
			if (TASKS[theRoleId][i].equals(TASKS[theRoleId][0])) {
				UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId, myConference);
				table.setUp();
				tab = table;
//				tab = makeViewPaperPanel(theUserId, theRoleId);
						//Submit Paper for Author
			} else if (TASKS[theRoleId][i].equals(TASKS[theRoleId][1])) {
				UI_SubmitPaper submitPaper = new UI_SubmitPaper(theUserId, myConference);
				submitPaper.setUp();
				tab = submitPaper;
			} else 	{
				tab = makeTextPanel(TASKS[theRoleId][i]);
			}
	        myTabbedPane.addTab(TASKS[theRoleId][i], tab);
	        myTextPanels.add(tab);
	        tab.setBackground(BACKGROUND_COLOR);
		}
        add(myTabbedPane);
	}
	
	
   private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.setBackground(BACKGROUND_COLOR);
        panel.add(filler);
        return panel;
    }
   
   /**
    * @param text
    * @return panel that shows list papers to user
    */
   private JSplitPane makeViewPaperPanel(final int theUserId, final int theRoleId) {
	   JComponent listPane = makePaperList(theUserId, theRoleId);
	   JComponent textPanel = makeTextPanel("This will show the information of selected paper.");
       JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPane, textPanel);
       splitPane.setDividerLocation(300);
       splitPane.setBackground(BACKGROUND_COLOR);

       return splitPane;
   }
   
   private JList makePaperList(final int theUserId, final int theRoleId) {
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
//	   JScrollPane paperPanel = new JScrollPane(list);
//	   paperPanel.setPreferredSize(new Dimension(100, 150));
//	   paperPanel.add(list);
//	   return paperPanel;
	   
	   return list;
   }

   
   /**
    * Removes all tabbed panels when the user logs out.
    */
   public void logOut() {
	   myTabbedPane.removeAll();
	   myTextPanels.clear();
   }
   
   //Panels for each user
//	private JComponent createAuthorPanels() {
//		return null;
//	}
//	private JComponent createReviewerPanels() {
//		return null;
//	}
//	private JComponent createSubChairPanels() {
//		return null;
//	}
//	private JComponent createProgramChairPanels() {
//		return null;
//	}
}
