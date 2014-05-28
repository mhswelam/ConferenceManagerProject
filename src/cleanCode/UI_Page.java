package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the main page.
 *
 */
public class UI_Page {
	/** Main window frame. */
	private JFrame myFrame;
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
		
		logInPanel = new UI_Login();
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
		JPanel contentPane = new JPanel(new BorderLayout());
		
		
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		UI_Login loginPanel = new UI_Login();
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
		contentPane.add(loginPanel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		loginPanel.logIn();
		
		myFrame.add(contentPane);
//		JPanel centerPanel = new JPanel();
//		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.LINE_AXIS));
//		centerPanel.setPreferredSize(new Dimension(1000, 700));
//		centerPanel.setBackground(new Color(255, 255, 255));
//		centerPanel.add(logInPanel);
//		
//		JPanel eastPanel = new JPanel(new BorderLayout());
//		eastPanel.setPreferredSize(new Dimension(100, 100));
//		eastPanel.setBackground(new Color(105, 105, 105));
//		
//		JPanel westPanel = new JPanel(new BorderLayout());
//		westPanel.setPreferredSize(new Dimension(100, 100));
//		westPanel.setBackground(new Color(105, 105, 105));
//		
//		JPanel southPanel = new JPanel(new BorderLayout());
//		southPanel.setPreferredSize(new Dimension(200, 100));
//		southPanel.setBackground(new Color(105, 105, 105));
//		
//		
//		
//		myFrame.add(northPanel, BorderLayout.NORTH);
//		myFrame.add(eastPanel, BorderLayout.EAST);
//		myFrame.add(westPanel, BorderLayout.WEST);
//		myFrame.add(southPanel, BorderLayout.SOUTH);
//		myFrame.add(centerPanel, BorderLayout.CENTER);		
	}
}
