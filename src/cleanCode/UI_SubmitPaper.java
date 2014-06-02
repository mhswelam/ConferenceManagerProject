package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Clean Code
 * This class to create a submit paper panel for the author.
 *
 */
public class UI_SubmitPaper extends JPanel {
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	/** Field where Author puts their name. */
	private JTextField myNameField;
	/** Field where Author puts their email. */
	private JTextField myEmailField;
	/** Field where Author puts the name of the conference for submitted paper. */
	private JTextField myConferenceField;
	
	/** Missing: Which of the conference categories best characterizes this paper (used to match reviewers): */
	
	/** Field where Author puts the title of their paper.
	 *  100 characters max. */
	private JTextField myTitleField;
	/** Field where Author puts the keywords that describe the paper. */
	private JTextField myKeywordsField;
	/** Field where Author writes abstract of the paper.
	 *  100 characters max. */
	private JTextField myAbstractField;

	
	
	/**
	 * Creates a panel containing the submission sheet and a 
	 * dialog allowing the Author to submit their manuscript.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_SubmitPaper(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myConference = theConference;
		myNameField = new JTextField(10);
		myEmailField = new JTextField(10);
		myConferenceField = new JTextField(10);
		myTitleField = new JTextField(10);
		myKeywordsField = new JTextField(10);
		myAbstractField = new JTextField(10);
	}

	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		//Filler panels to make a decent layout
		JPanel northfiller = new JPanel();
		northfiller.setPreferredSize(new Dimension(800, 40));
		northfiller.setBackground(BACKGROUND_COLOR);
		JPanel westfiller = new JPanel();
		westfiller.setPreferredSize(new Dimension(30, 500));
		westfiller.setBackground(BACKGROUND_COLOR);
		JPanel eastfiller = new JPanel();
		eastfiller.setPreferredSize(new Dimension(30, 500));
		eastfiller.setBackground(BACKGROUND_COLOR);
		
		add(northfiller, BorderLayout.NORTH);
		add(westfiller, BorderLayout.WEST);
		add(eastfiller, BorderLayout.EAST);
		makeSubmitForm();
	}
	
	/**
	 * Creates a form for submission.
	 */
	private void makeSubmitForm() {
		//Creating labels
		JLabel nameLabel = new JLabel("Your Name: ");
		nameLabel.setLabelFor(myNameField);
		JLabel emailLabel = new JLabel("Your email: ");
		emailLabel.setLabelFor(myEmailField);
		JLabel conferenceLabel = new JLabel("Conference name: ");
		conferenceLabel.setLabelFor(myConferenceField);
		JLabel titleLabel = new JLabel("Paper title (100 characters max): ");
		titleLabel.setLabelFor(myTitleField);
		JLabel keywordsLabel = new JLabel("Keywords (for searching): ");
		keywordsLabel.setLabelFor(myKeywordsField);
		JLabel abstractLabel = new JLabel("Abstract: (100 words max): ");
		abstractLabel.setLabelFor(myAbstractField);
		
		//Panel that contains the form for submission of paper
		JPanel submitForm = new JPanel();
		submitForm.setPreferredSize(new Dimension(400, 300));
		submitForm.setBackground(BACKGROUND_COLOR);
		
		submitForm.add(nameLabel);
		submitForm.add(myNameField);
		submitForm.add(emailLabel);
		submitForm.add(myEmailField);
		submitForm.add(conferenceLabel);
		submitForm.add(myConferenceField);
		submitForm.add(titleLabel);
		submitForm.add(myTitleField);
		submitForm.add(keywordsLabel);
		submitForm.add(myKeywordsField);
		submitForm.add(abstractLabel);
		submitForm.add(myAbstractField);
		
		add(submitForm, BorderLayout.CENTER);
	}
	
	/**
	 * Creates a dialog that lets author upload the paper.
	 */
	public void makeSubmitDialog() {
		JPanel dialogPanel = new JPanel();
		
		add(dialogPanel, BorderLayout.CENTER);
	}
}
