package cleanCode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author Clean Code
 * This class to create a user interface for the login
 *
 */ 
public class UI_Login extends JPanel implements ActionListener {
	/** Role choices when logging in. */
	private final String[] options = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** User Id entered into the text field. Initially set to -1. */
	private int myUserId;
	/** Role selected in the combo box. Initially set to -1. */
	private int myRoleId;
	/** Combo box containing a list of roles. */
	private JComboBox<String> myRoleBox;
	/** Text field for user to enter their id. */
	private JTextField myUserNameField;
	/** Button used to log in the user. */
	private JButton myLogInButton;
	/** Conference. */
	private Conference myConference;
	
	/**
	 * Instantiates Log In panel when Conference starts running.
	 * 
	 * @param theConference conference.
	 */
	public UI_Login(final Conference theConference) {
		super(new FlowLayout(FlowLayout.CENTER, 300, 100));
		setBackground(BACKGROUND_COLOR);
		
		myUserId = 0;
		myRoleId = 0;
		myRoleBox = new JComboBox<String>(options);
		myUserNameField = new JTextField(15);
		myLogInButton = new JButton("Log In");
		myLogInButton.addActionListener(this);
		myConference = theConference;
	}
	
	/**
	 * Sets up the panels for log in screen.
	 */
	public void logIn() {
		JPanel loginFrame = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
		loginFrame.setPreferredSize(new Dimension(350, 270));
		Border panelBorder = BorderFactory.createLineBorder(new Color(235, 235, 235), 2);
		loginFrame.setBorder(panelBorder);
		loginFrame.setBackground(BACKGROUND_COLOR);
	
		
		JLabel userNameLabel = new JLabel("Enter User Id");
		userNameLabel.setLabelFor(myUserNameField);

		
		JLabel comboBoxText = new JLabel("Select Your Role");
		comboBoxText.setLabelFor(myRoleBox);


		loginFrame.add(userNameLabel);
		loginFrame.add(myUserNameField);
		loginFrame.add(comboBoxText);
		loginFrame.add(myRoleBox);
		loginFrame.add(myLogInButton);
		add(loginFrame);
	}
	
	/**
	 * Resets the log in screen if user decided to log out.
	 */
	public void logOut() {
		myUserNameField.setText("");
		myRoleBox.setSelectedIndex(0);
		myUserId = 0;
		myRoleId = 0;
	}

	
	/**
	 * Once the log in button is pressed. The user id and 
	 * role id is checked against user list in class and 
	 * proper permission is granted.
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		myUserId = Integer.parseInt(myUserNameField.getText());
		myRoleId = myRoleBox.getSelectedIndex();
		if (myRoleId == 1 || myRoleId == 2 || myRoleId == 4) {
			if (myConference.isReviewer(myUserId)) {
				setVisible(false);
			}
		} else {
			if (myConference.isAuthor(myUserId)){
				setVisible(false);
			}
		}
		//Here ooes the code to check user & and their role
		//If the person logging in is User, then they become author by submitting the paper;
		
//		System.out.println("User Id : " + myUserId + " Rode num : " + myRoleId);
	}
	
	/**
	 * @return unique identification number of the user that logged in.
	 */
	public int getUderId() {
		return myUserId;
	}
	
	/**
	 * @return role identification number of the user that logged in.
	 */
	public int getRoleId() {
		return myRoleId;
	}
}
