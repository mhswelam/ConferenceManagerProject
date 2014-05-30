package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Clean Code
 * This class to create a user interface for the user info.
 *
 */
public class UI_UserInfo extends JPanel {
	/** Users name. */
	private String myName;
	/** Users role. */
	private String myRole;
	/** Users unique identification number. */
	private String myUserId;
	/** Name of the conference. */
	private String myConferenceName;
	
	/**
	 * Creates top panel that contains name and role of the user.
	 * 
	 * @param theName name of the user.
	 * @param theRole role of the user.
	 * @param theUserId unique identification number of the user.
	 * @param theConferenceName name of the conference.
	 */
	public UI_UserInfo(final String theName, final String theRole, 
					   final String theUserId, final String theConferenceName) {
		super(new BorderLayout());
		myName = theName;
		myRole = theRole;
		myUserId = theUserId;
		myConferenceName = theConferenceName;
	}
	
	
	public void setUp() {
		setPreferredSize(new Dimension(900, 100));
		setBackground(new Color(255, 255, 255));
		
		JPanel wordPanel = new JPanel(new GridLayout(2, 8));
		wordPanel.setBackground(new Color(255, 255, 255));
		
		JLabel hello = new JLabel("Hello, " + myName);
		JLabel userId = new JLabel("User Id : " + myUserId);
		JLabel role = new JLabel("Role : " + myRole);
		JLabel conference = new JLabel("Conference : " + myConferenceName);
		
		wordPanel.add(hello);
		wordPanel.add(role);
		wordPanel.add(userId);
		wordPanel.add(conference);
		
		JPanel fillerEast = new JPanel();
		fillerEast.setPreferredSize(new Dimension(50, 100));
		fillerEast.setBackground(new Color(255, 255, 255));
		
		JPanel fillerWest = new JPanel();
		fillerWest.setPreferredSize(new Dimension(50, 100));
		fillerWest.setBackground(new Color(255, 255, 255));
		
		JPanel fillerNorth = new JPanel();
		fillerNorth.setPreferredSize(new Dimension(800, 25));
		fillerNorth.setBackground(new Color(255, 255, 255));
		
		
		JPanel fillerSouth = new JPanel();
		fillerSouth.setPreferredSize(new Dimension(800, 25));
		fillerSouth.setBackground(new Color(255, 255, 255));
		
		add(fillerEast, BorderLayout.EAST);
		add(fillerWest, BorderLayout.WEST);
		add(fillerNorth, BorderLayout.NORTH);
		add(wordPanel, BorderLayout.CENTER);
		add(fillerSouth, BorderLayout.SOUTH);
	}
}
