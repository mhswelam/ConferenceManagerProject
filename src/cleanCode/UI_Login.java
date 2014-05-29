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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author Clean Code
 * This class to create a user interface for the login
 *
 */
public class UI_Login extends JPanel implements ActionListener {
	private final String[] options = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
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
	UI_Page myMainPage;
	
	/**
	 * Instantiates Log In panel when Conference starts running.
	 * 
	 * @param theMainPage 
	 */
	public UI_Login(final UI_Page theMainPage) {
		super(new FlowLayout(FlowLayout.CENTER, 300, 100));
		setBackground(new Color(255, 255, 255));
		
		myUserId = -1;
		myRoleId = -1;
		myRoleBox = new JComboBox<String>(options);
		myUserNameField = new JTextField(15);
		myLogInButton = new JButton("Log In");
		myLogInButton.addActionListener(this);
		myMainPage = theMainPage;
	}
	
	/**
	 * Sets up the panels for log in screen.
	 */
	public void setUpPanel() {
		JPanel loginFrame = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
		loginFrame.setPreferredSize(new Dimension(350, 270));
		Border panelBorder = BorderFactory.createLineBorder(new Color(235, 235, 235), 2);
		loginFrame.setBorder(panelBorder);
		loginFrame.setBackground(new Color(250, 250, 250));
	
		
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
	
	public void logIn() {
		
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent theEvent) {
		myUserId = Integer.parseInt(myUserNameField.getText());
		myRoleId = myRoleBox.getSelectedIndex();
		System.out.println("User Id : " + myUserId + " Rode num : " + myRoleId);
	}
}
