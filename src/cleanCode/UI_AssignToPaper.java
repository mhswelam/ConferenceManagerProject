package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

/**
 * @author Clean Code
 *  
 * This class to a page that assigns users to papers.
 *
 */
public class UI_AssignToPaper extends JPanel implements ActionListener {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** Paper that is being displyed.*/
	private Paper myPaper;
	/** Conference. */
	private Conference myConference;
	
	/** Label that holds authors name. */
	private JLabel myAuthorNameLabel;
	/** Label that holds title of the paper.*/
	private JLabel myPaperTitleLabel;
	
	/** Combo box that holds a list of subprogram chairs. */
	private JComboBox mySubChairBox;
	/** Combo box that holds a list of reviewers. */
	private JComboBox myReviewerOneBox;
	/** Combo box that holds a list of reviewers. */
	private JComboBox myReviewerTwoBox;
	/** Combo box that holds a list of reviewers. */
	private JComboBox myReviewerThreeBox;
	
	/** Label that displays "Select Subprogram Chair.*/
	private JLabel mySubChairLabel;
	/** Label that displays "Select First Reviewer: ".*/
	private JLabel myFirstReviewerLabel;
	/** Label that displays "Select Second Reviewer: ".*/
	private JLabel mySecondReviewerLabel;
	/** Label that displays "Select Third Reviewer: ".*/
	private JLabel myThirdReviewerLabel;
	
	
	
	
	
	/**
	 * Creates a panel that contains all information 
	 * needed to assign paper to a user.
	 * 
	 * @param theTheUserId unique user identification number.
	 * @param theRoleId role identification number.
	 * @param theTable table that contains currently selected paper.
	 * @param theConference conference.
	 */
	public UI_AssignToPaper(final int theUserId, final int theRoleId,
							final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myPaper = null;
		myConference = theConference;
		
		//initially when nothing is selected.
		myAuthorNameLabel = new JLabel("Not Selected");
		myPaperTitleLabel = new JLabel("Not Selected");
		
		mySubChairBox = new JComboBox();
		mySubChairBox.addActionListener(this);
		myReviewerOneBox = new JComboBox();
		myReviewerOneBox.addActionListener(this);
		myReviewerTwoBox = new JComboBox();
		myReviewerTwoBox.addActionListener(this);
		myReviewerThreeBox = new JComboBox();
		myReviewerThreeBox.addActionListener(this);
		
		mySubChairLabel = new JLabel("Select Subprogram Chair: ");
		myFirstReviewerLabel = new JLabel("Select First Reviewer: ");
		mySecondReviewerLabel = new JLabel("Select Second Reviewer: ");
		myThirdReviewerLabel = new JLabel("Select Third Reviewer: ");
	}
	
	/**
	 * Sets up the display panel to choose Subprogram Chair for Program Chair.
	 * Or to choose the Reviewers for Subprogram Chair.
	 */
	public void setUp() {
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(BACKGROUND_COLOR);
		add(mainPanel, BorderLayout.CENTER);
		JLabel authorLabel = new JLabel("Author: ");
		JLabel titleLabel = new JLabel("Title: ");
		JLabel nameLabel = new JLabel();
		
		//Set up for Program Chair
		if (myRoleId == 1) {
			nameLabel.setText("Assign Paper to Subprogram Chair");
//			setUpPC();
			createProgramChairLayout(authorLabel, titleLabel, mainPanel);
		//Set up for Subprogram Chair
		} else if (myRoleId == 2) {
			nameLabel.setText("Assign Reviewers to the Paper");
//			setUpSPC();
			createSubProgramChairLayout(authorLabel, titleLabel, mainPanel);
		}
		setUpLayout(nameLabel);
	}
	
	/**
	 * Changer the paper that is being displayed.
	 * 
	 * @param thePaper a manuscript.
	 */
	public void setDisplayPaper(final Paper thePaper) {
		myPaper = thePaper;
		myPaperTitleLabel.setText(myPaper.getTitle());
		String firstName = myConference.getAuthor(
											   myPaper.getAuthor()).myFristName;
		String lastName = myConference.getAuthor(
												myPaper.getAuthor()).myLastName;
		myAuthorNameLabel.setText(firstName + " " + lastName);
	}
	
	/**
	 * Sets up the panel so Program Chair can designate 
	 * a Subprogram Chair for a paper.
	 */
	public void setUpPC() {
		if (myPaper != null) {
			//Add available Subprogram Chairs to Combo Box.
			ArrayList<SubProgramChair> availableSPC = 
								myConference.getAvaSubProgram(myPaper.getId());
			if (mySubChairBox.getItemCount() > 0) {
				mySubChairBox.removeAllItems();
			}
			for (SubProgramChair spc : availableSPC) {
				String name = spc.myFristName + " " + spc.myLastName;
				mySubChairBox.addItem(name);
			}
		}
	}
	
	/**
	 * Sets up the panel so Subprogram Chair can Designate three
	 * Reviewers for the Paper.
	 */
	public void setUpSPC() {
		if (myPaper != null) {
			//Add available Reviewers to Combo Boxes.
			ArrayList<Reviewer> availableReviewers = myConference.getAvaReviewer();
			if (myReviewerOneBox.getItemCount() > 0 || 
				myReviewerTwoBox.getItemCount() > 0 || 
				myReviewerThreeBox.getItemCount() > 0) {
				myReviewerOneBox.removeAllItems();
				myReviewerTwoBox.removeAllItems();
				myReviewerThreeBox.removeAllItems();
			}
			for (Reviewer rev : availableReviewers) {
				String name = rev.myFristName + " " + rev.myLastName;
				myReviewerOneBox.addItem(name);
				myReviewerTwoBox.addItem(name);
				myReviewerThreeBox.addItem(name);
			}
		}
	}
	
	/**
	 * Sets up the layout of the main panel.
	 */
	private void setUpLayout(final JLabel theTopLabel) {
		JPanel rightFiller = new JPanel();
		rightFiller.setBackground(BACKGROUND_COLOR);
		rightFiller.setPreferredSize(new Dimension(100, 500));
		add(rightFiller, BorderLayout.EAST);
		
		JPanel leftFiller = new JPanel();
		leftFiller.setBackground(BACKGROUND_COLOR);
		leftFiller.setPreferredSize(new Dimension(100, 500));
		add(leftFiller, BorderLayout.WEST);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		titlePanel.setBackground(BACKGROUND_COLOR);
		titlePanel.setPreferredSize(new Dimension(500, 50));
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(null);
		
		
		theTopLabel.setBounds(149, 28, 264, 16);
		theTopLabel.setComponentOrientation(
											ComponentOrientation.LEFT_TO_RIGHT);
		theTopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		theTopLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		titlePanel.add(theTopLabel);
	}
	
	/**
	 * Sets up layout for Program Chair.
	 * 
	 * @param theTitleLabel label that displays "Title: ".
	 * @param theAuthorLabel label that displays "Author: "
	 * @param theMainPanel panel that contains all the information.
	 */
	private void createProgramChairLayout(final JLabel theTitleLabel, 
		final JLabel theAuthorLabel, final JPanel theMainPanel) {
		GroupLayout mainPanelLayout = new GroupLayout(theMainPanel);
		//parallel group
		mainPanelLayout.setHorizontalGroup(
			mainPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
						.addGroup(mainPanelLayout.createSequentialGroup()
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(theAuthorLabel)
								.addComponent(theTitleLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(myPaperTitleLabel)
								.addComponent(myAuthorNameLabel)))
						.addGroup(mainPanelLayout.createSequentialGroup()
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(mySubChairLabel))
							.addGap(18)
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addGroup(mainPanelLayout.createParallelGroup(
													   Alignment.LEADING, false)
									.addComponent(mySubChairBox, 0, 107, 
														 Short.MAX_VALUE)))))));
		
		//vertical group
		mainPanelLayout.setVerticalGroup(
			mainPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(theAuthorLabel)
						.addComponent(myAuthorNameLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(theTitleLabel)
						.addComponent(myPaperTitleLabel))
					.addGap(31)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(mySubChairLabel)
						.addComponent(mySubChairBox, GroupLayout.PREFERRED_SIZE, 
												   	GroupLayout.DEFAULT_SIZE, 
													GroupLayout.PREFERRED_SIZE))
					));
		
		theMainPanel.setLayout(mainPanelLayout);
	}
	
	/**
	 * Sets up the layout for Subprogram Chair.
	 * 
	 * @param theTitleLabel label that displays "Title: ".
	 * @param theAuthorLabel label that displays "Author: "
	 * @param theMainPanel panel that contains all the information.
	 */
	private void createSubProgramChairLayout(final JLabel theTitleLabel, 
		final JLabel theAuthorLabel, final JPanel theMainPanel) {
		GroupLayout mainPanelLayout = new GroupLayout(theMainPanel);
		//parallel group
		mainPanelLayout.setHorizontalGroup(
			mainPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
						.addGroup(mainPanelLayout.createSequentialGroup()
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(theAuthorLabel)
								.addComponent(theTitleLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(myPaperTitleLabel)
								.addComponent(myAuthorNameLabel)))
						.addGroup(mainPanelLayout.createSequentialGroup()
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(myFirstReviewerLabel)
								.addComponent(mySecondReviewerLabel)
								.addComponent(myThirdReviewerLabel)
								)
							.addGap(18)
							.addGroup(mainPanelLayout.createParallelGroup(
															  Alignment.LEADING)
								.addComponent(myReviewerThreeBox, 0, 
													   GroupLayout.DEFAULT_SIZE, 
													   			Short.MAX_VALUE)
								.addGroup(mainPanelLayout.createParallelGroup(
													   Alignment.LEADING, false)
									.addComponent(myReviewerTwoBox, 0, 
													   GroupLayout.DEFAULT_SIZE, 
													   			Short.MAX_VALUE)
									.addComponent(myReviewerOneBox, 0, 
													   GroupLayout.DEFAULT_SIZE, 
													   			Short.MAX_VALUE)
															))))));
		
		//vertical group
		mainPanelLayout.setVerticalGroup(
			mainPanelLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainPanelLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(theAuthorLabel)
						.addComponent(myAuthorNameLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(theTitleLabel)
						.addComponent(myPaperTitleLabel))
					.addGap(31)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(myFirstReviewerLabel)
						.addComponent(myReviewerOneBox, 
								GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE)
						.addComponent(myReviewerTwoBox, 
								GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(mySecondReviewerLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainPanelLayout.createParallelGroup(
															 Alignment.BASELINE) 
						.addComponent(myReviewerThreeBox, 
								GroupLayout.PREFERRED_SIZE, 
								GroupLayout.DEFAULT_SIZE, 
								GroupLayout.PREFERRED_SIZE)
						.addComponent(myThirdReviewerLabel))
					));
		
		theMainPanel.setLayout(mainPanelLayout);
	}

	/**
	 * Program Chair designates Subprogram Chair to the paper.
	 * Subprogram Chair designates Reviewers to the paper.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
//		System.out.println(theEvent.getActionCommand());
		
		//Program Chair assigns Subprogram Chair
		if (myRoleId == 1) {
			
//			myPaper.assignSubProgramChair(theSubChairId);
			
		//Subprogram Chair assigns Reviewers
		} else if (myRoleId == 2) {
			
		}
		
	}
}