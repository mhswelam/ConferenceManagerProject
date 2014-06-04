package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Clean Code
 * This class to create a view reviews paper panel for the Author.
 *
 */
public class UI_ViewReviews extends JPanel implements ActionListener, ListSelectionListener{
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);

	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	
	private int myRoleId;
	
	private String myPaperTitle;
	
	private Paper myPaper;
	
	private UI_PaperList paperList;
	
	private JPanel centerpanel;
	
	private JLabel listName;
	
	private JLabel panelInfoName;
	
	/**
	 * Creates a panel containing paper list and a panel allowing 
	 * the Author to view reviews of their manuscript.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_ViewReviews(final int theUserId, final Conference theConference, final int theRoleId) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myConference = theConference;
		myPaperTitle = "";
	}
	
	
	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		listName = new JLabel("Paper selected :");
		panelInfoName = new JLabel(myPaperTitle);
		JButton select_Btn = new JButton("Select Paper");
		select_Btn.addActionListener(this);
		//Filler panels to make a decent layout
		JPanel topLabel = new JPanel(new FlowLayout());
		topLabel.setPreferredSize(new Dimension(800, 50));
		topLabel.setBackground(BACKGROUND_COLOR);
		topLabel.add(listName);
		topLabel.add(panelInfoName);
		topLabel.add(select_Btn);
//		JPanel paperInfoPanel = new JPanel(new BorderLayout());
//		paperInfoPanel.add(makeUnsubmitPanel(), BorderLayout.CENTER);
//		paperInfoPanel.add(makeUnsubmitButton(), BorderLayout.SOUTH);
		//paperList = new UI_PaperList(myUserId, myConference);
		//paperList.setUp();
		//JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
		//									  paperList, makeReviewInfoPanel());
		//splitPane.setDividerLocation(100);
	    //splitPane.setBackground(BACKGROUND_COLOR);
	    
	    add(topLabel, BorderLayout.NORTH);
	    
	}
	

   private JPanel  makeReviewInfoPanel() {
	   JPanel reviewInfo = new JPanel();
	   reviewInfo.setBackground(BACKGROUND_COLOR);
	   JLabel info = new JLabel("This will contain reviews and information");
	   reviewInfo.add(info, BorderLayout.CENTER);
	   return reviewInfo;
   }
   
	@Override
	public void valueChanged(ListSelectionEvent theEvent) {
		
		
	}

	@Override
	public void actionPerformed(ActionEvent theEvent) {
		ArrayList<Paper> myPaperList = myConference.getPaperList(myRoleId, myUserId);
		Map<String,Paper> myPapermap = new HashMap<String,Paper>();
		String [] paperT = new String[myPaperList.size()];
		for (int i =0 ; i < myPaperList.size();i++) {
			paperT[i] = (myPaperList.get(i).getTitle());
			myPapermap.put(myPaperList.get(i).getTitle(),myPaperList.get(i));
		}
		
		myPaper = myPapermap.get(JOptionPane.showInputDialog(
                this,
                "Please select paper :",
                "Select Paper",
                JOptionPane.PLAIN_MESSAGE,
                null, paperT, ""));
		myPaperTitle = myPaper.getTitle();
		panelInfoName.setText(myPaperTitle);
		
		centerpanel = new UI_ReviewInfo(myPaper, myConference);
		add(centerpanel, BorderLayout.CENTER);
		
	}
}
