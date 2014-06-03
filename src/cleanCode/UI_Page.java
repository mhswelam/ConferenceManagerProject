package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the main page.
 *
 */
public class UI_Page {
	/** Role choices. */
	private final String[] OPTIONS = {"","Program Chair","SubProgram Chair","Author", "Reviewer"};
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Main window frame. */
	private JFrame myFrame;
	/** Panel that contains all other panels. */
	private JPanel contentPane;
	/** To hold the conference class. */
	private Conference myConference;
	/** Log in screen. */
	private UI_Login myLogInPanel;
	/** Control panel where users can do all the tasks. */
	private UI_ControlPanel myControlPanel;

	/**
	 * Constructs graphical user interface.
	 * 
	 * @param theConference conference.
	 */
	public UI_Page(final Conference theConference) {
		myConference = theConference;
		myFrame = new JFrame("Conference");
		contentPane = new JPanel(new BorderLayout());
		myLogInPanel = new UI_Login(myConference);
		myControlPanel = new UI_ControlPanel(myConference);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Size of the frame 900 width 700 height
		myFrame.setPreferredSize(new Dimension(900, 700));
		contentPane.setBackground(BACKGROUND_COLOR);
		myControlPanel.setBackground(BACKGROUND_COLOR);
		
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
//				System.out.println("User Id : " + userId + " Rode num : " + roleId);
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
		//Retrieves the First and Last name of the user
		String firstName = "";
		String lastName = "";
		if (theRoleId == 1 || theRoleId == 2 || theRoleId == 4) {
			if (myConference.isReviewer(theUserId)) {
				firstName = myConference.getReviewer(theUserId).myFristName;
				lastName = myConference.getReviewer(theUserId).myLastName;
			}
		} else {
			firstName = myConference.getAuthor(theUserId).myFristName;
			lastName = myConference.getAuthor(theUserId).myLastName;
		}
		
		//Creates the top User Information panel that contains the ID Name etc
		UI_UserInfo userInfo = new UI_UserInfo(firstName + " " + lastName, 
											OPTIONS[theRoleId], 
											   "" + theUserId, myConference.myName);
		userInfo.setUp();
		
		//add "Log Out" button to the panel
		userInfo.add(createLogOutButton(), BorderLayout.EAST);
		
		
		myControlPanel.setUp(theUserId, theRoleId);
		
		contentPane.add(userInfo, BorderLayout.NORTH);
		contentPane.add(myControlPanel, BorderLayout.CENTER);
		
		
//		UI_PaperInfo paperInfo = new UI_PaperInfo();
		UI_TaskInfo taskInfo  = new UI_TaskInfo();
	}
	
	/**
	 * @return button that logs out the user, clearing all the information.
	 */ 
	private JButton createLogOutButton() {
		JButton logOut = new JButton("Log Out");
		logOut.addActionListener(new ActionListener() {
			/**
			 * Logs out the user.
			 */
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				int ok = JOptionPane.showConfirmDialog(contentPane, 
						"Are you sure you want to log out?", 
						   "Log out", JOptionPane.YES_NO_OPTION); 
					if (ok ==  JOptionPane.YES_OPTION) {
						contentPane.removeAll();
						myLogInPanel.logOut();
						myControlPanel.logOut();
						contentPane.add(myLogInPanel, BorderLayout.CENTER);
						myLogInPanel.setVisible(true);
					}
			}
			
		});
		return logOut;
	}
}
