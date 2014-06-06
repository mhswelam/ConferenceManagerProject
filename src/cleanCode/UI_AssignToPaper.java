package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 * This class to a page that assigns users to papers.
 *
 */
public class UI_AssignToPaper extends JPanel {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** unique identification number of the paper that is displayed. */
	private int myPaperId;
	/** Conference. */
	private Conference myConference;
	private JLabel myAuthorLabel;
	private JLabel myTitleLabel;
	private JComboBox myAssignSPC;
	private Paper myPaper;
	
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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel, BorderLayout.CENTER);
		
		JLabel lblAuthor = new JLabel("Author: ");
		
		JLabel lblTitle = new JLabel("Title:");
		
		JLabel lblSubprogramChair = new JLabel("Select Subprogram Chair: ");
		
		JComboBox comboBox = new JComboBox();
		
		myAuthorLabel = new JLabel("Not Selected");
		
		myTitleLabel = new JLabel("Not Selected");
		
		JLabel lblSelectFirstReviewer = new JLabel("Select First Reviewer: ");
		
		JLabel lblSelectSecondReviewer = new JLabel("Select Second Reviewer: ");
		
		JLabel lblSelectThirdReviewer = new JLabel("Select Third Reviewer: ");
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		JComboBox comboBox_3 = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(mainPanel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAuthor)
								.addComponent(lblTitle))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(myTitleLabel)
								.addComponent(myAuthorLabel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSubprogramChair)
								.addComponent(lblSelectFirstReviewer)
								.addComponent(lblSelectSecondReviewer)
								.addComponent(lblSelectThirdReviewer))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, 0, 107, Short.MAX_VALUE)))))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(myAuthorLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(myTitleLabel))
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubprogramChair)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelectFirstReviewer)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectSecondReviewer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectThirdReviewer))
					.addContainerGap(348, Short.MAX_VALUE))
		);
		mainPanel.setLayout(gl_panel);
		
		JPanel rightFiller = new JPanel();
		rightFiller.setBackground(Color.WHITE);
		rightFiller.setPreferredSize(new Dimension(100, 500));
		add(rightFiller, BorderLayout.EAST);
		
		JPanel leftFiller = new JPanel();
		leftFiller.setBackground(Color.WHITE);
		leftFiller.setPreferredSize(new Dimension(100, 500));
		add(leftFiller, BorderLayout.WEST);
		
		JPanel titleNorthFiller = new JPanel();
		titleNorthFiller.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		titleNorthFiller.setBackground(Color.WHITE);
		titleNorthFiller.setPreferredSize(new Dimension(500, 50));
		add(titleNorthFiller, BorderLayout.NORTH);
		titleNorthFiller.setLayout(null);
		
		JLabel lblAssignPaperTo = new JLabel("Assign Paper to Subprogram Chair");
		lblAssignPaperTo.setBounds(149, 28, 264, 16);
		lblAssignPaperTo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblAssignPaperTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignPaperTo.setHorizontalTextPosition(SwingConstants.LEADING);
		titleNorthFiller.add(lblAssignPaperTo);
		
		myUserId = theUserId;
		myRoleId = theRoleId;
		myPaperId = 0;
		myPaper = null;
		myConference = theConference;
		
	}
	
	public void setUp() {
		JPanel content = new JPanel();
		Paper paper = myConference.getPaper(myPaperId);
		String title = paper.getTitle();
		int authorId = paper.getAuthor();
		String firstName = myConference.getAuthor(authorId).myFristName;
		String lastName = myConference.getAuthor(authorId).myLastName;
		
		myAuthorLabel.setText("Authors Name: " + firstName + " " + lastName);
		myTitleLabel.setText("Title: " + title);
		JLabel assign = new JLabel("Assign Subprogram Chair: ");
		
		ArrayList<SubProgramChair> availableSPC = myConference.getAvaSubProgram();
		String[] subChairs = new String[availableSPC.size()];
		for (SubProgramChair spc : availableSPC) {
			String name = spc.myFristName + " " + spc.myLastName;
		}
		myAssignSPC = new JComboBox(subChairs);
		content.add(myAuthorLabel);
		content.add(myTitleLabel);
		content.add(myAssignSPC);
		add(content);
	}
	
	public void setDisplayPaper(final Paper thePaper) {
		myPaper = thePaper;
		System.out.println(myPaper.getTitle());
		myTitleLabel.setText(myPaper.getTitle());
		String firstName = myConference.getAuthor(myPaper.getAuthor()).myFristName;
		String lastName = myConference.getAuthor(myPaper.getAuthor()).myLastName;
		myAuthorLabel.setText(firstName + " " + lastName);
	}

	private void getPaperInfo() {
		Paper paper = myConference.getPaper(myPaperId);
		String title = paper.getTitle();
		int authorId = paper.getAuthor();
		String firstName = myConference.getAuthor(authorId).myFristName;
		String lastName = myConference.getAuthor(authorId).myLastName;
	}
}
