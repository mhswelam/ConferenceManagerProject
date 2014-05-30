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
	private final static String[][] TASKS = {{"View Papers", "Submit Paper"}, 
		{"Review Papers"}, {"View Papers", "Assign Papers", "View Reviewers"}, 
		{ "View Papers", "Assign Papers", "View Subprogram Chairs", "View Reviewers", "View Authors"}};
	
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
	}
	
	/**
	 * Sets up the Panel.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theRoleId role of the user.
	 */
	public void setUp(final int theUserId, final int theRoleId) {
		JTabbedPane tabbedPane = new JTabbedPane();
		int size = TASKS[theRoleId].length;
		List<JComponent> textPanels = new ArrayList<JComponent>();
		for (int i = 0; i < size; i++) {
			JComponent tab = makeTextPanel(TASKS[theRoleId][i]);
	        tabbedPane.addTab(TASKS[theRoleId][i], tab);
	        textPanels.add(tab);
		}

        add(tabbedPane);
	}

   private JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
