package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Clean Code/Zack 
 * @author edited by Mohamed  6/11/2014 to show the file been submitted and massage to confirm submition
 * This class to create a submit paper panel for the author.
 *
 */
public class UI_SubmitPaper extends JPanel implements 
											ActionListener {
	
	/**Adding default serial ID to get rid of error.*/
	private static final long serialVersionUID = 1L;
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new 
			Color(255, 255, 255);
	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	private int myRoleId;
	private JFrame myFrame;
	
	/** Missing: Which of the conference categories best 
	 * characterizes this paper (used to match reviewers):*/
	
	/** Field where Author puts the title of their paper.
	  * 100 characters max. */
	private JTextField myTitleField;
	/** Field where Author puts the keywords that describe 
	 * the paper. */
	private JTextField myKeywordsField;
	/** Field where Author writes abstract of the paper.
	 *  100 characters max. */
	private JTextField myAbstractField;
	/** Button that submits  the paper. */
	private JButton mySubmitButton;
	/** Button that opens up file chooser for submitting
	 *  paper. */
	private JButton myChooseFileButton;
	
	private JLabel myFile = new JLabel("File :");
	
	private JLabel myPaperFile;
	
	
	/**
	 * Creates a panel containing the submission sheet and a 
	 * dialog allowing the Author to submit their manuscript.
	 * 
	 * @param theUserId unique identification number of 
	 * the user.
	 * @param theRoleId role of the user.
	 * @param theConference conference.
	 * @param theFrame window where information is 
	 * displayed.
	 */
	public UI_SubmitPaper(final int theUserId, 
			final int theRoleId, 
			final Conference theConference, 
			final JFrame theFrame) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myConference = theConference;
		myFrame = theFrame;
		myTitleField = new JTextField(20);
		myKeywordsField = new JTextField(20);
		myAbstractField = new JTextField(58);
		mySubmitButton = new JButton("Submit");
		mySubmitButton.addActionListener(this);
		myChooseFileButton = new JButton("Choose File");
		myChooseFileButton.addActionListener(this);
		myPaperFile = new JLabel("");
	}

	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		JLabel panelName = new JLabel("Submission Form");
		
		//Filler panels to make a decent layout
		JPanel northfiller = new JPanel();
		northfiller.setPreferredSize(new Dimension(800,50));
		northfiller.setBackground(BACKGROUND_COLOR);
		northfiller.add(panelName);
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
		makeSubmitDialog();
	}
	
	/**
	 * Creates a form for submission.
	 */
	private void makeSubmitForm() {
		JLabel titleLabel = new JLabel("Paper title "
				+ "(100 characters max): ");
		titleLabel.setLabelFor(myTitleField);
		JLabel keywordsLabel = new JLabel("Keywords "
				+ "(for searching): ");
		keywordsLabel.setLabelFor(myKeywordsField);
		JLabel abstractLabel = new JLabel("Abstract: "
				+ "(100 words max): ");
		abstractLabel.setLabelFor(myAbstractField);
		
		//Panel that contains the form to submit the paper
		JPanel submitForm = new JPanel();
		submitForm.setPreferredSize(new Dimension(400,300));
		submitForm.setBackground(BACKGROUND_COLOR);
		submitForm.add(titleLabel, BorderLayout.NORTH);
		submitForm.add(myTitleField, BorderLayout.NORTH);
		submitForm.add(keywordsLabel, BorderLayout.NORTH);
		submitForm.add(myKeywordsField, BorderLayout.NORTH);
		submitForm.add(abstractLabel, BorderLayout.CENTER);
		submitForm.add(myAbstractField, BorderLayout.CENTER);
		submitForm.add(myFile, BorderLayout.SOUTH);
		submitForm.add(myPaperFile, BorderLayout.SOUTH);
		add(submitForm, BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Creates a dialog that lets author upload the paper.
	 */
	public void makeSubmitDialog() {
		JPanel dialogPanel = new JPanel(new BorderLayout());
		dialogPanel.setPreferredSize(new 
				Dimension(800, 100));
		dialogPanel.setBackground(BACKGROUND_COLOR);
		
		//Filler panels for decent layout
		JPanel westfiller = new JPanel();
		westfiller.setPreferredSize(new Dimension(30, 100));
		westfiller.setBackground(BACKGROUND_COLOR);
		JPanel eastfiller = new JPanel();
		eastfiller.setPreferredSize(new Dimension(30, 100));
		eastfiller.setBackground(BACKGROUND_COLOR);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(BACKGROUND_COLOR);
		
		centerPanel.add(myChooseFileButton, 
				BorderLayout.NORTH);
		centerPanel.add(mySubmitButton, BorderLayout.SOUTH);
		
		dialogPanel.add(westfiller, BorderLayout.WEST);
		dialogPanel.add(eastfiller, BorderLayout.EAST);
		dialogPanel.add(centerPanel, BorderLayout.CENTER);
		
		add(dialogPanel, BorderLayout.SOUTH);
	}
	

	/**
	 * Uploads a paper the user chose to submit.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		//Author is trying to choose a file to upload
		if (theEvent.getSource() == myChooseFileButton) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.resetChoosableFileFilters();
			fileChooser.setFileFilter(new FileNameExtensionFilter
                    ("PDF Format (*.pdf)", "pdf"));
			int returnValue = fileChooser.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File paper = fileChooser.getSelectedFile();
				paper.renameTo(new File("\\papers\\"+paper.getName()));
				myPaperFile.setText(paper.getName());
			}
		} else if (theEvent.getSource() == mySubmitButton) {
			Paper myPaper = null;
			String title = myTitleField.getText();
			String key = myKeywordsField.getText();
			String abs = myAbstractField.getText();
			if (title.isEmpty() || key.isEmpty() || 
					abs.isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"You must fill out all of "
						+ "the text fields", 
						"missing fields",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int paperID = 
						myConference.lastPaperID + 1;
				myPaper = new Paper(paperID, 
						myUserId, title, 
						0, 0, 0, 0, 0, 0, 0, 0, 0, 
						"No status");
				myConference.addPaper(myPaper);
				JOptionPane.showMessageDialog(this,
					    "Thank you, The paper has been submited.");
				
			}


		}	
	}
}
