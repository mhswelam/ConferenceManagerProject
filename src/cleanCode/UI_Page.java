package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the main page.
 *
 */
public class UI_Page {
	/** Role choices. */
	private final String[] options = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
	/** Main window frame. */
	private JFrame myFrame;
	/** Panel that contains all other panels. */
	private JPanel contentPane;
	/** To hold the conference class. */
	private Conference myConference;
	UI_Login myLogInPanel;

	/**
	 * Constructs graphical user interface.
	 * 
	 * @param theConference conference.
	 */
	public UI_Page(final Conference theConference) {
		myFrame = new JFrame("Conference");
		myConference = theConference;
		contentPane = new JPanel(new BorderLayout());
		myLogInPanel = new UI_Login(myConference);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		contentPane.setBackground(new Color(255, 255, 255));
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of the frame 900 width 700 height
		myFrame.setPreferredSize(new Dimension(900, 700));
		
		setUpPanels();
		
		myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
	}
	
	/**
	 * Sets up initial log in screen.
	 */
	private void setUpPanels() {
		myLogInPanel.addComponentListener(new ComponentAdapter() {
			/**
			 * When the user loged in, sets up the rest of the program.
			 */
			@Override
			public void componentHidden(final ComponentEvent theEvent) {
				UI_Login panel = (UI_Login) theEvent.getComponent();
				contentPane.remove(panel);
				int userId = panel.getUderId();
				int roleId = panel.getRoleId();
				System.out.println("User Id : " + userId + " Rode num : " + roleId);
				initializeProgram(userId, roleId);
			}
		});
		
		myLogInPanel.logIn();
		
		contentPane.add(myLogInPanel, BorderLayout.CENTER);
		myFrame.add(contentPane);
	}
	
	/**
	 * Starts the program for a particular user.
	 */
	public void initializeProgram(final int theUserId, final int theRoleId) {
		//"Welcome User" layout
		setUpWelcomePanel(theRoleId);
		
		UI_ControlPanel controlPanel = new UI_ControlPanel();
		UI_PaperInfo paperInfo = new UI_PaperInfo();
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
		UI_UserInfo userInfo = new UI_UserInfo();
	}
	
	private void setUpWelcomePanel(final int theRoleId) {
		String welcomeText = "Welcome " + options[theRoleId];
		JLabel welcomeLabel = new JLabel(welcomeText);
		
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 10));
		welcomeLabel.setLabelFor(northPanel);
		northPanel.setPreferredSize(new Dimension(900, 70));
		northPanel.setBackground(new Color(250, 250, 250));
		
		JButton logOut = new JButton("Log Out");
		logOut.addActionListener(new ActionListener() {
			/**
			 * Logs out the user.
			 */
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				int ok = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to log out?", 
						   "Log out", JOptionPane.YES_NO_OPTION); 
					if (ok ==  JOptionPane.YES_OPTION) {
						contentPane.removeAll();
						myLogInPanel.logOut();
						contentPane.add(myLogInPanel, BorderLayout.CENTER);
						myLogInPanel.setVisible(true);
					}
			}
			
		});
		
		northPanel.add(welcomeLabel);
		northPanel.add(logOut);
		
		contentPane.add(northPanel, BorderLayout.NORTH);
	}
}
