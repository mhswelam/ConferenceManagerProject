package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JList;
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
	
	/**
	 * Creates a panel containing paper list and a panel allowing 
	 * the Author to view reviews of their manuscript.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_ViewReviews(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myConference = theConference;
	}
	
	
	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		JLabel listName = new JLabel("List Of Papers");
		JLabel panelInfoName = new JLabel("Paper Reviews");
		
		//Filler panels to make a decent layout
		JPanel topLabel = new JPanel(new BorderLayout(500, 10));
		topLabel.setPreferredSize(new Dimension(800, 50));
		topLabel.setBackground(BACKGROUND_COLOR);
		topLabel.add(listName, BorderLayout.WEST);
		topLabel.add(panelInfoName,BorderLayout.CENTER);
		
//		JPanel paperInfoPanel = new JPanel(new BorderLayout());
//		paperInfoPanel.add(makeUnsubmitPanel(), BorderLayout.CENTER);
//		paperInfoPanel.add(makeUnsubmitButton(), BorderLayout.SOUTH);
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
											  makePaperList(), 
											  makeReviewInfoPanel());
		splitPane.setDividerLocation(300);
	    splitPane.setBackground(BACKGROUND_COLOR);
	    
	    add(topLabel, BorderLayout.NORTH);
	    add(splitPane, BorderLayout.CENTER);
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

   private JPanel  makeReviewInfoPanel() {
	   JPanel reviewInfo = new JPanel();
	   reviewInfo.setBackground(BACKGROUND_COLOR);
	   JLabel info = new JLabel("This will contain reviews and information");
	   reviewInfo.add(info, BorderLayout.CENTER);
	   return reviewInfo;
   }
   
	@Override
	public void valueChanged(ListSelectionEvent theEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent theEvent) {
		// TODO Auto-generated method stub
		
	}
}
