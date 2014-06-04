package cleanCode;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Clean Code
 * This class to create a user interface for the Control Panel.
 *
 */
public class UI_ControlPanel extends JPanel { 
	/** Tasks for each role. 
	 * Tasks at index 0 belongs to Author, 
	 * Tasks at index 1 belongs to Reviewer,
	 * Tasks at index 2 belong to Subprogram Chair,
	 * Tasks at index 3 belong to Program Chair. */
	private final static String[][] TASKS = { {},												//0 is empty
		{"View Papers", "Assign Subprogram Chair", "Make Acceptance Decision"}, 				//1 Program Chair
		{"View Papers", "Assign Reviewers", "Recommend Paper"}, 								//2	Subprogram Chair
		{"View Papers", "View Reviews", "Submit Paper", "Edit Paper", "Unsubmit Paper"},		//3 Author
		{"View Papers", "Review Papers"}};														//4 Reviewer
	
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Tabbed pane. */
	private JTabbedPane myTabbedPane;
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
	}
	
	/**
	 * Sets up the Panel.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	public void setUp(final int theUserId, final int theRoleId) {
		if (theRoleId == 3) {
			setUpAuthor(theUserId, theRoleId);
		} else if (theRoleId == 4) {
			setUpReviewer(theUserId, theRoleId);
		} else if (theRoleId == 2) {
			setUpSPC(theUserId, theRoleId);
		} else if (theRoleId == 1){
			setUpPC(theUserId, theRoleId);
		}
		
        add(myTabbedPane);
	}
	
	/**
	 * Sets up the panel for Author.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpAuthor(final int theUserId, final int theRoleId) {
		//View Papers
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId, myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//View Reviewes
		UI_ViewReviews reviewPanel = new UI_ViewReviews(theUserId, myConference);
		reviewPanel.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][1], reviewPanel);
//		JComponent tab = makeTextPanel(TASKS[0][1]);
//		myTabbedPane.addTab(TASKS[theRoleId][1], tab);
	
		//"Submit Paper"
		UI_SubmitPaper submitPaper = new UI_SubmitPaper(theUserId, myConference);
		submitPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][2], submitPaper);
		
		//"Edit Paper"
		UI_EditPaper editPaper = new UI_EditPaper(theUserId, myConference);
		editPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][3], editPaper);
		
		//"Unsubmit Paper"
		UI_UnsubmitPaper unsubmit = new UI_UnsubmitPaper(theUserId, myConference);
		unsubmit.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][4], unsubmit);
		
	}
	
	/**
	 * Sets up the panel for Reviewer.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpReviewer(final int theUserId, final int theRoleId) {
		//"View Papers"
		//"Review Papers"
		
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
			} else {
				Paper temp = myConference.getPaper(9);
				tab = new UI_SubmitReview(myConference, temp, theUserId);
				//tab = makeTextPanel(TASKS[theRoleId][i]);
			}
	        myTabbedPane.addTab(TASKS[theRoleId][i], tab);
	        tab.setBackground(BACKGROUND_COLOR);
		}
	}
	
	/**
	 * Sets up the panel for Sub Program Chair.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpSPC(final int theUserId, final int theRoleId) {
		//"View Papers"
		//"Assign Papers"
		//"Recommend Paper"
		//"View Reviewers"
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
			} else {
				//tab = makeTextPanel(TASKS[theRoleId][i]);
				Paper temp = myConference.getPaper(9);
				tab = new UI_SubmitRecommendation(myConference, temp, theUserId);
			}
	        myTabbedPane.addTab(TASKS[theRoleId][i], tab);
	        tab.setBackground(BACKGROUND_COLOR);
		}
	}
	
	/**
	 * Sets up the panel for Program Chair.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpPC(final int theUserId, final int theRoleId) {
		//"View Papers"
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId, myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//"Assign Papers"
		JComponent tab = makeTextPanel(TASKS[theRoleId][1]);
		myTabbedPane.addTab(TASKS[theRoleId][1], tab);
		
		//"Make Acceptance Decision"
		JComponent tab1 = makeTextPanel(TASKS[theRoleId][2]);
		myTabbedPane.addTab(TASKS[theRoleId][2], tab1);
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
//   private JSplitPane makeViewPaperPanel(final int theUserId, final int theRoleId) {
//	   JComponent listPane = makePaperList(theUserId, theRoleId);
//	   JComponent textPanel = makeTextPanel("This will show the information of selected paper.");
//       JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPane, textPanel);
//       splitPane.setDividerLocation(300);
//       splitPane.setBackground(BACKGROUND_COLOR);
//
//       return splitPane;
//   }
   
//   private JList makePaperList(final int theUserId, final int theRoleId) {
//	 //just for Program Chair
//	   Collection<Paper> paperSet = myConference.listOfPaper.values();
//	   String[] paperNames = new String[paperSet.size()];
//	   int i = 0;
//	   for (Paper paper : paperSet) {
//		   paperNames[i] = paper.getTitle();
//		   i++;
//	   }
//	   JList<String> list = new JList<String>(paperNames);
//	   
//	   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//	   list.setLayoutOrientation(JList.VERTICAL);
//	   list.setSelectedIndex(0);
//	   
//	   //not sure if this is needed
////	   JScrollPane paperPanel = new JScrollPane(list);
////	   paperPanel.setPreferredSize(new Dimension(100, 150));
////	   paperPanel.add(list);
////	   return paperPanel;
//	   
//	   return list;
//   }

   
   /**
    * Removes all tabbed panels when the user logs out.
    */
   public void logOut() {
	   myTabbedPane.removeAll();
   }
}
