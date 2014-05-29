package cleanCode;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the main page.
 *
 */
public class UI_Page {
	/** Main window frame. */
	private JFrame myFrame;
	JPanel contentPane;
	
	private UI_Login logInPanel;

	/** To hold the conference class. */
	private Conference myConference;
	//Observes all other UI classes.
	//Controls changes to all other UI classes.

	/**
	 * Constructs graphical user interface.
	 * 
	 * @param theConference conference.
	 */
	public UI_Page(Conference theConference) {
		myFrame = new JFrame("Conference");
		
		logInPanel = new UI_Login(this);
		myConference = theConference;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		myFrame.setVisible(true);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of the frame 1200 width 900 height
		myFrame.setPreferredSize(new Dimension(1200, 900));
		
		
		setUpPanels();
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        
	}
	
	/**
	 * Sets up all interface panels.
	 */
	private void setUpPanels() {
		contentPane = new JPanel(new BorderLayout());
		
		
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
//		UI_Login loginPanel = new UI_Login();
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
		
		//Welcome User Panel
		JPanel northPanel = new JPanel(new BorderLayout());
		northPanel.setPreferredSize(new Dimension(200, 100));
		//Blue color is north panel
		//northPanel.setBackground(new Color(33, 104, 255));
		
		//Task Info Panel?
		JPanel southPanel = new JPanel(new BorderLayout());
		southPanel.setPreferredSize(new Dimension(200, 100));
		//Yellow color is south panel
		//southPanel.setBackground(new Color(237, 255, 33));
		
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(logInPanel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		
		
		myFrame.add(contentPane);
		
		logInPanel.logIn();
		
	}
	
	/**
	 * Starts the program for a particular user.
	 */
	public void initializeProgram() {
//		contentPane.remove(logInPanel);
		if (myConference.listOfReviewer.containsKey(logInPanel.myUserId)) {
			myFrame.remove(contentPane);
			myFrame.repaint();
		} else {
			JOptionPane.showMessageDialog(myFrame, "Enter Correct Information");
		}
//		String roleUserId = logInPanel.getUser();
	}
}
