package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 * @author Clean Code
 * This class to create a edit paper panel for the author.
 *
 */
public class UI_EditPaper extends JPanel implements ActionListener {
	
	/**Adding default serial ID to get rid of error.*/
	private static final long serialVersionUID = 1L;
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	private int myRoleId;
	
	/** Missing: Which of the conference categories best characterizes this 
	 * paper (used to match reviewers): */
	
	/** Field where Author puts the title of their paper.
	 *  100 characters max. */
	private JTextField myTitleField;
	/** Field where Author puts the keywords that describe the paper. */
	private JTextField myKeywordsField;
	/** Field where Author writes abstract of the paper.
	 *  100 characters max. */
	private JTextField myAbstractField;
	/** Button that submits  the paper. */
	private JButton mySubmitButton;
	/** Button that opens up file chooser for submitting paper. */
	private JButton myChooseFileButton;
	private JFrame myFrame;
	
	/**
	 * Creates a panel containing the submission sheet and a 
	 * dialog allowing the Author to edit their manuscript.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_EditPaper(final int theUserId, final int theRoleId, 
			final Conference theConference, JFrame theFrame) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myFrame = theFrame;
		myConference = theConference;
		myTitleField = new JTextField(30);
		myKeywordsField = new JTextField(30);
		myAbstractField = new JTextField(30);
		mySubmitButton = new JButton("Submit");
		mySubmitButton.addActionListener(this);
		myChooseFileButton = new JButton("Choose File");
		myChooseFileButton.addActionListener(this);
	}
	
	/**
	 * Creates the panels and sets up the UI.
	 */
	public void setUp() {
		JLabel listName = new JLabel("List Of Papers");
		JLabel panelName = new JLabel("Edit Submission Form");
		
		//Filler panels to make a decent layout
		JPanel topLabel = new JPanel(new BorderLayout(500, 10));
		topLabel.setPreferredSize(new Dimension(800, 50));
		topLabel.setBackground(BACKGROUND_COLOR);
		topLabel.add(listName, BorderLayout.WEST);
		topLabel.add(panelName,BorderLayout.CENTER);
		
		JPanel paperInfoPanel = new JPanel(new BorderLayout());
		paperInfoPanel.add(makeSubmitForm(), BorderLayout.CENTER);
		paperInfoPanel.add(makeSubmitDialog(), BorderLayout.SOUTH);
		
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
	 * Creates a form for submission.
	 */
	private JPanel makeSubmitForm() {
		//Creating labels
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
		
		submitForm.add(titleLabel);
		submitForm.add(myTitleField);
		submitForm.add(keywordsLabel);
		submitForm.add(myKeywordsField);
		submitForm.add(abstractLabel);
		submitForm.add(myAbstractField);
		
		return submitForm;
	}
	
	/**
	 * Creates a dialog that lets author upload the paper.
	 */
	public JPanel makeSubmitDialog() {
		JPanel dialogPanel = new JPanel(new BorderLayout());
		dialogPanel.setPreferredSize(new Dimension(800, 100));
		dialogPanel.setBackground(BACKGROUND_COLOR);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(BACKGROUND_COLOR);
		
		centerPanel.add(myChooseFileButton, BorderLayout.NORTH);
		centerPanel.add(mySubmitButton, BorderLayout.SOUTH);
		dialogPanel.add(centerPanel, BorderLayout.CENTER);
		
		return dialogPanel;
	}

	/**
	 * Uploads a paper the user chose to submit.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		//Author is trying to choose a file to upload
		if (theEvent.getSource() == myChooseFileButton) {
			JFileChooser fileChooser = new JFileChooser(new File("C:\\Users"
					+ "\\Zack\\git\\ConferenceManager\\src"));
			int returnValue = fileChooser.showDialog(this, "Upload");
			//This will delete old paper. Submit new paper.
			if (returnValue == JFileChooser.OPEN_DIALOG) {
				File paper = fileChooser.getSelectedFile();
			}
		} else if (theEvent.getSource() == mySubmitButton) {
			Paper myPaper = null;
			String title = myTitleField.getText();
			String key = myKeywordsField.getText();
			String abs = myAbstractField.getText();
			if (title.isEmpty() || key.isEmpty() || abs.isEmpty()) {
				JOptionPane.showMessageDialog(this,"You must fill out all of "
						+ "the text fields", 
						"missing fields",JOptionPane.ERROR_MESSAGE);
			}
			
			if (myConference.myPaperToDelete != 0) {
				myConference.removePaper(myConference.myPaperToDelete);
			}
			myPaper = new Paper(myConference.myPaperToDelete, myUserId, title, 
					0, 0, 0, 0, 0, 0, 0, 0, 0, "No status");
			myConference.addPaper(myPaper);
			myFrame.setVisible(false);
			UI_Page page = new UI_Page(myConference);
			page.refresh(myUserId, myRoleId);
			
		}	
	}
}
