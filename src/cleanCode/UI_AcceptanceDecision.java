package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * @author Clean Code
 * This class to a page that lets Program Chair 
 * Accept/Deny Paper in the conference. 
 *
 */
public class UI_AcceptanceDecision extends JPanel implements ActionListener {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** Paper that is displayed. */
	private Paper myPaper;
	private int myPaperId;
	/** Conference. */
	private Conference myConference;
	/** Label that contains the title of the paper. */
	JLabel myTitleNameLabel;
	/** Label that contains the name of the author.*/
	JLabel myAuthorNameLabel;
	/** Button for Program Chair to accept the paper.*/
	JRadioButton myAcceptRadioButton;
	/** Button for Program Chair to deny the paper.*/
	JRadioButton myDenyRadioButton;
	
	/**
	 * Creates a panel that lets Program Chair Accept/Reject selected paper.
	 * 
	 * @param theTheUserId unique user identification number.
	 * @param theRoleId role identification number.
	 * @param theConference conference.
	 */
	public UI_AcceptanceDecision(final int theUserId, final int theRoleId,
			final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		
		myUserId = theUserId;
		myRoleId = theRoleId;
		myConference = theConference;
		myPaper = null;
		myPaperId = 0;
		
		myTitleNameLabel = new JLabel("Not Selected");
		myAuthorNameLabel = new JLabel("Not Selected");
		myAcceptRadioButton = new JRadioButton("Accept Paper");
		myAcceptRadioButton.addActionListener(this);
		
		myDenyRadioButton = new JRadioButton("Deny Paper");
		myDenyRadioButton.addActionListener(this);
	}
	
	/**
	 * Sets up the panel where Program Chair can accept of deny the paper.
	 */
	public void setUp() {
		JPanel panel = new JPanel();
		panel.setForeground(BACKGROUND_COLOR);
		panel.setBackground(BACKGROUND_COLOR);
		add(panel, BorderLayout.CENTER);
		
		JLabel titleLabel = new JLabel("Title: ");
		JLabel authorLabel = new JLabel("Author: ");
		JLabel makeDecisionLabel = new JLabel("Make Decision: ");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(makeDecisionLabel)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(
									Alignment.TRAILING)
								.addGroup(Alignment.LEADING, 
										gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(
											Alignment.LEADING)
										.addComponent(authorLabel)
										.addComponent(titleLabel))
									.addPreferredGap(
											ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(
											Alignment.LEADING)
										.addComponent(myAuthorNameLabel)
										.addComponent(myTitleNameLabel)))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(myAcceptRadioButton)))
							.addGap(63)
							.addComponent(myDenyRadioButton)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorLabel)
						.addComponent(myTitleNameLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(titleLabel)
						.addComponent(myAuthorNameLabel))
					.addGap(137)
					.addComponent(makeDecisionLabel)
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(myAcceptRadioButton)
						.addComponent(myDenyRadioButton))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(500, 50));
		panel_1.setBackground(BACKGROUND_COLOR);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		JLabel lblMakeAcceptenceDesicion = 
										new JLabel("Make Acceptence Desicion ");
		lblMakeAcceptenceDesicion.setBounds(168, 28, 193, 16);
		panel_1.add(lblMakeAcceptenceDesicion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(100, 500));
		panel_2.setBackground(BACKGROUND_COLOR);
		add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(BACKGROUND_COLOR);
		panel_3.setPreferredSize(new Dimension(100, 500));
		add(panel_3, BorderLayout.EAST);
	}
	
	/**
	 * Changes the paper that is currently displayed.
	 * 
	 * @param thePaper paper that will be displayed.
	 */
	public void setDisplayPaper(final Paper thePaper) {
		myPaper = thePaper;
		myTitleNameLabel.setText(myPaper.getTitle());
		String firstName = myConference.getAuthor(
											   myPaper.getAuthor()).myFristName;
		String lastName = myConference.getAuthor(
												myPaper.getAuthor()).myLastName;
		myAuthorNameLabel.setText(firstName + " " + lastName);
	}

	/**
	 * Changes the status of the paper.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		if (theEvent.getActionCommand().equals("Accept Paper")) {
			myPaper.changeStatus("Accepted");
		} else if (theEvent.getActionCommand().equals("Deny Paper")) {
			myPaper.changeStatus("Denied");
		}
	}
}
