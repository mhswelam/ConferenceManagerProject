package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the main page.
 *
 */
public class UI_Page {
	/** Main window frame. */
	public JFrame myFrame;
	
	/**
	 * To hold the conference class
	 */
	public Conference myConference;
	//Observes all other UI classes.
	//Controls changes to all other UI classes.

	/**
	 * Constructs graphical user interface.
	 */
	public UI_Page(Conference aConference) {
		myFrame = new JFrame();
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.setBackground(Color.WHITE);
		myConference = aConference;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of the frame 1200 width 800 height
		myFrame.setPreferredSize(new Dimension(1200, 900));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of the frame 1200 width 800 height
		myFrame.setPreferredSize(new Dimension(1200, 900));
		
		
		setUpPanels();
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        logInPanel.logIn();
	}
	
	/**
	 * Sets up all interface panels.
	 */
	private void setUpPanels() {
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
		
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(200, 100));
		northPanel.setBackground(new Color(105, 105, 105));
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(1000, 700));
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.add(logInPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(100, 100));
		eastPanel.setBackground(new Color(105, 105, 105));
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(100, 100));
		westPanel.setBackground(new Color(105, 105, 105));
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(200, 100));
		southPanel.setBackground(new Color(105, 105, 105));
		
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(northPanel, BorderLayout.NORTH);
		myFrame.add(eastPanel, BorderLayout.EAST);
		myFrame.add(westPanel, BorderLayout.WEST);
		myFrame.add(southPanel, BorderLayout.SOUTH);
		myFrame.add(logInPanel, BorderLayout.CENTER);
		//Size of the frame 1200 width 800 height
		myFrame.setPreferredSize(new Dimension(1200, 900));
		
		
		setUpPanels();
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        logInPanel.logIn();
	}
	
	/**
	 * Sets up all interface panels.
	 */
	private void setUpPanels() {
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
		
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(200, 100));
		northPanel.setBackground(new Color(105, 105, 105));
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(1000, 700));
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.add(logInPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(100, 100));
		eastPanel.setBackground(new Color(105, 105, 105));
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(100, 100));
		westPanel.setBackground(new Color(105, 105, 105));
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(200, 100));
		southPanel.setBackground(new Color(105, 105, 105));
		
		
		setUpPanels();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(northPanel, BorderLayout.NORTH);
		myFrame.add(eastPanel, BorderLayout.EAST);
		myFrame.add(westPanel, BorderLayout.WEST);
		myFrame.add(southPanel, BorderLayout.SOUTH);
		myFrame.add(logInPanel, BorderLayout.CENTER);
		//Size of the frame 1200 width 800 height
		myFrame.setPreferredSize(new Dimension(1200, 900));
		
		
		setUpPanels();
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        logInPanel.logIn();
	}
	
	/**
	 * Sets up all interface panels.
	 */
	private void setUpPanels() {
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
		
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(200, 100));
		northPanel.setBackground(new Color(105, 105, 105));
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(1000, 700));
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.add(logInPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(100, 100));
		eastPanel.setBackground(new Color(105, 105, 105));
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(100, 100));
		westPanel.setBackground(new Color(105, 105, 105));
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(200, 100));
		southPanel.setBackground(new Color(105, 105, 105));
		
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        logInPanel.logIn();
	}
	
	/**
	 * Sets up all interface panels.
	 */
	private void setUpPanels() {
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
		
		JPanel northPanel = new JPanel();
		northPanel.setPreferredSize(new Dimension(200, 100));
		northPanel.setBackground(new Color(105, 105, 105));
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setPreferredSize(new Dimension(1000, 700));
		centerPanel.setBackground(new Color(255, 255, 255));
		centerPanel.add(logInPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setPreferredSize(new Dimension(100, 100));
		eastPanel.setBackground(new Color(105, 105, 105));
		
		JPanel westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(100, 100));
		westPanel.setBackground(new Color(105, 105, 105));
		
		JPanel southPanel = new JPanel();
		southPanel.setPreferredSize(new Dimension(200, 100));
		southPanel.setBackground(new Color(105, 105, 105));
		
		
		myFrame.add(northPanel, BorderLayout.NORTH);
		myFrame.add(eastPanel, BorderLayout.EAST);
		myFrame.add(westPanel, BorderLayout.WEST);
		myFrame.add(southPanel, BorderLayout.SOUTH);
		myFrame.add(logInPanel, BorderLayout.CENTER);
	}
}
