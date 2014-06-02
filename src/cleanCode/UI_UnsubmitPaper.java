package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Clean Code
 * This class to create a unsubmit paper panel for the Author.
 *
 */
public class UI_UnsubmitPaper extends JPanel implements ActionListener, ListSelectionListener {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);

	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	/** Button that submits  the paper. */
	private JButton myUnsubmitButton;
	/** Panel that contains paper information. */
	private JPanel myInfoPanel;
	/** Label that contains name of the author. */
	private JLabel myNameLabel;
	/** Label that contains email of the author. */
	private JLabel myEmailLabel;
	/** Label that contains name of the conference. */
	private JLabel myConferenceLabel;
	/** Label that contains title of the paper. */
	private JLabel myTitleLabel;
	/** Label that contains keywords of the paper. */
	private JLabel myKeywordsLabel;
	/** Label that contains abstract of the paper. */
	private JLabel myAbstractLabel;

	

	
	/**
	 * Creates a panel containing paper information and a 
	 * button allowing the Author to delete their manuscript.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_UnsubmitPaper(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myConference = theConference;
		myUnsubmitButton = new JButton("Unsubmit");
		myInfoPanel = new JPanel();
		myUnsubmitButton.addActionListener(this);
		myNameLabel = new JLabel();
		myEmailLabel = new JLabel();
		myConferenceLabel = new JLabel("Conference name: " + myConference.myName);
		myTitleLabel = new JLabel();
		myKeywordsLabel = new JLabel();
		myAbstractLabel = new JLabel();
	}
	
	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		JLabel listName = new JLabel("List Of Papers");
		JLabel panelInfoName = new JLabel("Paper Information");
		
		//Filler panels to make a decent layout
		JPanel topLabel = new JPanel(new BorderLayout(500, 10));
		topLabel.setPreferredSize(new Dimension(800, 50));
		topLabel.setBackground(BACKGROUND_COLOR);
		topLabel.add(listName, BorderLayout.WEST);
		topLabel.add(panelInfoName,BorderLayout.CENTER);
		
		JPanel paperInfoPanel = new JPanel(new BorderLayout());
		paperInfoPanel.add(makeUnsubmitPanel(), BorderLayout.CENTER);
		paperInfoPanel.add(makeUnsubmitButton(), BorderLayout.SOUTH);
		
		UI_PaperList paperList = new UI_PaperList(myUserId, myConference);
		paperList.setUp();
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
											  paperList, paperInfoPanel);
		splitPane.setDividerLocation(300);
	    splitPane.setBackground(BACKGROUND_COLOR);
	    
	    add(topLabel, BorderLayout.NORTH);
	    add(splitPane, BorderLayout.CENTER);
	}
	
	/**
	 * Creates a panel with information about the paper Author wants to unsubmit.
	 */
	private JPanel makeUnsubmitPanel() {
		setTextForLabels();
		//Panel that contains the form for submission of paper
		JPanel myInfoPanel = new JPanel();
		myInfoPanel.setPreferredSize(new Dimension(400, 300));
		myInfoPanel.setBackground(BACKGROUND_COLOR);
		
		myInfoPanel.add(myNameLabel);
		myInfoPanel.add(myEmailLabel);
		myInfoPanel.add(myConferenceLabel);
		myInfoPanel.add(myTitleLabel);
		myInfoPanel.add(myKeywordsLabel);
		myInfoPanel.add(myAbstractLabel);
		
		return myInfoPanel;
	}
	
	/**
	 * This method changes text displayed on the labels.
	 */
	private void setTextForLabels() {
		myNameLabel.setText("Your Name: " + "This will be authors name");
		myEmailLabel.setText("Your email: " + "This wil be authors email");
		myTitleLabel.setText("Paper title (100 characters max): " + "This will be paper title");
		myKeywordsLabel.setText("Keywords (for searching): " + "These will be paper keywords");
		myAbstractLabel.setText("Abstract: (100 words max): " + "This will be paper abstract");
	}
	
	/**
	 * Creates a dialog that lets author upload the paper.
	 */
	public JPanel makeUnsubmitButton() {
		JPanel unsubmitPanel = new JPanel(new BorderLayout());
		unsubmitPanel.setPreferredSize(new Dimension(800, 100));
		unsubmitPanel.setBackground(BACKGROUND_COLOR);
		
		unsubmitPanel.add(myUnsubmitButton, BorderLayout.SOUTH);
		
		return unsubmitPanel;
	}

	/**
	 * Uploads a paper the user chose to submit.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		//Author is trying to choose a file to upload
		if (theEvent.getSource() == myUnsubmitButton) {

		}
	}

	/**
	 * Updates the paper information.
	 */
	@Override
	public void valueChanged(ListSelectionEvent theEvent) {
		// TODO Auto-generated method stub
		
	}
}
