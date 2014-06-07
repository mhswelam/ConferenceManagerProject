package cleanCode;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import cleanCode.UI_PaperTable.MyTableModel;

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
		//JComponent viewPaperTab = table;
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
		
		//"Review Papers"
		Paper temp = myConference.getPaper(9);
		
		JComponent tab = new UI_SubmitReview(myConference, temp, theUserId);
		myTabbedPane.addTab(TASKS[theRoleId][1], tab);
        tab.setBackground(BACKGROUND_COLOR);
		int size = TASKS[theRoleId].length;
		for (int i = 0; i < size; i++) {
			//JComponent tab = null;
			//View Paper for any user
			if (TASKS[theRoleId][i].equals(TASKS[theRoleId][0])) {
				
//				tab = makeViewPaperPanel(theUserId, theRoleId);
			//Submit Paper for Author
			} else {
				
				//tab = makeTextPanel(TASKS[theRoleId][i]);
			}
	        //myTabbedPane.addTab(TASKS[theRoleId][i], tab);
	        //tab.setBackground(BACKGROUND_COLOR);
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
		UI_PaperTable table = new UI_PaperTable(theUserId, theRoleId,
												myConference);
		table.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][0], table);
        table.setBackground(BACKGROUND_COLOR);
		
		//"Assign Papers"
        UI_AssignToPaper reviewersToPaper = new UI_AssignToPaper(theUserId, theRoleId, 
				   myConference);
        reviewersToPaper.setUp();
		myTabbedPane.addTab(TASKS[theRoleId][1], reviewersToPaper);
		reviewersToPaper.setBackground(BACKGROUND_COLOR);
		
		//"Recommend Paper"
        Paper temp = myConference.getPaper(6);
        JComponent recoomTab = new UI_SubmitRecommendation(myConference, temp, theUserId);
        myTabbedPane.addTab(TASKS[theRoleId][2], recoomTab);
        recoomTab.setBackground(BACKGROUND_COLOR);
        
		//"View Reviewers"
		int size = TASKS[theRoleId].length;
		for (int i = 0; i < size; i++) {
			JComponent tab = null;
			//View Paper for any user
			if (TASKS[theRoleId][i].equals(TASKS[theRoleId][0])) {
				
				//tab = table;
//				tab = makeViewPaperPanel(theUserId, theRoleId);
			//Submit Paper for Author
			} else {
				//tab = makeTextPanel(TASKS[theRoleId][i]);
				
			}
	        
		}
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
		myTabbedPane.addTab(TASKS[theRoleId][2], acceptPaper);
		table.getTable().getModel().addTableModelListener(new 
									   MyTableModelListener(table, subToPaper));
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
    * Removes all tabbed panels when the user logs out.
    */
   public void logOut() {
	   myTabbedPane.removeAll();
   }
   
   private class MyTableModelListener implements TableModelListener {
	   private UI_PaperTable myPaperTable;
	   private UI_AssignToPaper myAssignToPaper;
	   
	   public MyTableModelListener(final UI_PaperTable theTable, 
			   					   final UI_AssignToPaper theAssignToPaper) {
		   super();
		   myPaperTable = theTable;
		   myAssignToPaper = theAssignToPaper;
	   }
	   
		@Override
		public void tableChanged(TableModelEvent theEvent) {
			// TODO Auto-generated method stub
			int row = theEvent.getFirstRow();
	        int column = theEvent.getColumn();
	        MyTableModel model = (MyTableModel)theEvent.getSource();
	        String columnName = model.getColumnName(column);
	        Object data = model.getValueAt(row, column);
	        System.out.println("Table changed at " + row + " " + data.toString());
	        if (data.equals(true)) {
	        	Paper tempPaper = myPaperTable.getSelectedPaper(row);
	        	myAssignToPaper.setDisplayPaper(tempPaper);
	        	myAssignToPaper.repaint();
	        }
		}
   }
}
