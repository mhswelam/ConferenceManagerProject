package cleanCode;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		{"View Submitted Papers", "Submit Paper", "Edit Paper", "Unsubmit Paper"}, 				//Author
		{"View Papers", "Review Papers"}, 										   				//Reviewer
		{"View Papers", "Assign Papers", "Recommend Paper", "View Reviewers"},		//Subprogram Chair
		{ "View Papers", "Assign Papers", "Make Acceptance Decision",		//Program Chair
			"View Subprogram Chairs", "View Reviewers", "View Authors"}};
	
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
		setBackground(new Color(255, 255, 255));
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
			JComponent tab = makeTextPanel(TASKS[theRoleId][i]);
	        myTabbedPane.addTab(TASKS[theRoleId][i], tab);
	        myTextPanels.add(tab);
		}

        add(myTabbedPane);
	}

   private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.setBackground(new Color(255, 255, 255));
        panel.add(filler);
        return panel;
    }
   
   /**
    * Removes all tabbed panels when the user logs out.
    */
   public void logOut() {
	   myTabbedPane.removeAll();
	   myTextPanels.clear();
   }
}
