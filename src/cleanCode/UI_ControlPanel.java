package cleanCode;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * @author Clean Code
 * This class to create a user interface for the Control Panel.
 *
 */
public class UI_ControlPanel extends JPanel { 
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	/** Tasks for each role. 
	 * Tasks at index 0 belongs to Author, 
	 * Tasks at index 1 belongs to Reviewer,
	 * Tasks at index 2 belong to Subprogram Chair,
	 * Tasks at index 3 belong to Program Chair. */
	private final static String[][] TASKS = { 
		//0 is empty
		{},												
		//1 Program Chair
		{"View Papers", "Assign Subprogram Chair", "Make Acceptance Decision"},
		//2	Subprogram Chair
		{"View Papers", "Assign Reviewers", "Recommend Paper"}, 								
		//3 Author
		{"View Papers", "View Reviews", "Submit Paper", "Edit Paper", 
															  "Unsubmit Paper"},		
		//4 Reviewer
		{"View Papers", "Review Papers"}};														
	
	/** Tabbed pane. */
	private JTabbedPane myTabbedPane;
	/** Conference .*/
	private Conference myConference;
	private JFrame myFrame;
	
	/**
	 * Creates panel that includes task tabs.
	 * 
	 * @param theConference conference.
	 */
	public UI_ControlPanel(final Conference theConference, JFrame frame) {
		super(new GridLayout(1, 1));
		setBackground(BACKGROUND_COLOR);
		myFrame = frame;
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
			setUpAuthor(theUserId, theRoleId, myFrame);
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
	 * @param theFrame frame of the window.
	 */
	private void setUpAuthor(final int theUserId, final int theRoleId, 
							 final JFrame theFrame) {
		//View Papers
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId,
												myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//View Reviewes
		UI_ViewReviews reviewPanel = new UI_ViewReviews(theUserId, myConference, 
														theRoleId);
		reviewPanel.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][1], reviewPanel);
	
		//"Submit Paper"
		UI_SubmitPaper submitPaper = new UI_SubmitPaper(theUserId, theRoleId, 
														myConference, myFrame);
		submitPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][2], submitPaper);
		
		//"Edit Paper"
		UI_EditPaper editPaper = new UI_EditPaper(theUserId, theRoleId, 
												  myConference, myFrame);
		editPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][3], editPaper);
		
		//"Unsubmit Paper"
		UI_UnsubmitPaper unsubmit = new UI_UnsubmitPaper(theUserId, theRoleId, 
														 myConference, myFrame);
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
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId,
												myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//"Review Papers"
		Paper temp = myConference.getPaper(9);
		
		UI_SubmitReview tab = new UI_SubmitReview(myConference, temp, theUserId);
		myTabbedPane.addTab(TASKS[theRoleId][1], tab);
        tab.setBackground(BACKGROUND_COLOR);
	}
	
	/**
	 * Sets up the panel for Sub Program Chair.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpSPC(final int theUserId, final int theRoleId) {
		//"View Papers"
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId,
												myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
        table.setBackground(BACKGROUND_COLOR);
		
		//"Assign Papers"
        UI_AssignToPaper reviewersToPaper = new UI_AssignToPaper(theUserId, 
        											   theRoleId, myConference);
        reviewersToPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][1], reviewersToPaper);
		reviewersToPaper.setBackground(BACKGROUND_COLOR);
		
		//"Recommend Paper"
        Paper temp = myConference.getPaper(6);
        JComponent recoomTab = new UI_SubmitRecommendation(myConference, temp, 
        															 theUserId);
        myTabbedPane.addTab(TASKS[theRoleId][2], recoomTab);
        recoomTab.setBackground(BACKGROUND_COLOR);
    
		table.getTable().getSelectionModel().addListSelectionListener(new 
				  		   MyTableModelListener(table, reviewersToPaper, null));
	}
	
	/**
	 * Sets up the panel for Program Chair.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	private void setUpPC(final int theUserId, final int theRoleId) {
		//"View Papers" Tab 1
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId,
											    myConference);
		table.setUp(); 
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//"Assign Papers" Tab 2
		UI_AssignToPaper subToPaper = new UI_AssignToPaper(theUserId, theRoleId, 
														   myConference);
		subToPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][1], subToPaper);
		
		
		//"Make Acceptance Decision" Tab 3
		UI_AcceptanceDecision acceptPaper = new UI_AcceptanceDecision(theUserId, 
													theRoleId, myConference);
		acceptPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][2], acceptPaper);
		table.getTable().getSelectionModel().addListSelectionListener(new 
						  MyTableModelListener(table, subToPaper, acceptPaper));
	}
	
   /**
    * Removes all tabbed panels when the user logs out.
    */
   public void logOut() {
	   myTabbedPane.removeAll();
   }
}
