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
public class UI_Login extends JPanel {
	int myUserId;
	int myRole;
	boolean submitted;
	UI_Page myMainPage;
	
	/**
	 * Instantiates Log In panel when Conference starts running.
	 */
	public UI_Login(UI_Page mainPage) {
		super(new FlowLayout(FlowLayout.CENTER, 300, 100));
//		setPreferredSize(new Dimension(600, 600));
		//White background color
		setBackground(new Color(255, 255, 255));
		
		//Role and user ID are not yet specified.
		myUserId = -1;
		myRole = -1;
		submitted = false;
		myMainPage = mainPage;
	}
	
	public void logIn() {
		JPanel loginFrame = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
		loginFrame.setPreferredSize(new Dimension(350, 450));
		Border panelBorder = BorderFactory.createLineBorder(new Color(235, 235, 235), 2);
		loginFrame.setBorder(panelBorder);
		loginFrame.setBackground(new Color(250, 250, 250));
		
//		JLabel logInText = new JLabel("Log In");
//		logInText.setVerticalTextPosition(JLabel.TOP);
//		logInText.setHorizontalTextPosition(JLabel.CENTER);
		
		
		JLabel userNameLabel = new JLabel("Enter User Id");
		JTextField userNameField = new JTextField(20);
		userNameLabel.setLabelFor(userNameField);
		userNameField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				JTextField tf = (JTextField) theEvent.getSource();
				String userName = tf.getText();
				myUserId = Integer.parseInt(userName);
//				System.out.println("I added user name");
			}
		});
		
		
		JLabel comboBoxText = new JLabel("Select Your Role");
		
		String[] options = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
		JComboBox roles = new JComboBox(options);
		
		//Looks at the role user selected
		roles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				JComboBox cb = (JComboBox) theEvent.getSource();
		        String selectedRole = (String) cb.getSelectedItem();
		        if (selectedRole.equals("Author")) {
		        	myRole = 0;
		        } else if (selectedRole.equals("Reviewer")) {
		        	myRole = 1;
		        } else if (selectedRole.equals("SubProgram Chair")) {
		        	myRole = 2;
		        } else {
		        	myRole = 3;
		        }
//		        System.out.println("I selected a role");
			}
		});
		
		comboBoxText.setLabelFor(roles);
		
		JButton logIn = new JButton("Log In");
		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent theEvent) {
				JButton l = (JButton) theEvent.getSource();
				//Checks if this is a valid user
				submitted = true;
//				getUser();
//				System.out.println("I tried to log in.");
				myMainPage.initializeProgram();
			}
		});

//		loginFrame.add(logInText);
		loginFrame.add(userNameLabel);
		loginFrame.add(userNameField);
		loginFrame.add(comboBoxText);
		loginFrame.add(roles);
		loginFrame.add(logIn);
		
		add(loginFrame);
	}
	
	/**
	 * @param theRole
	 * @param theUserId
	 * @return string that contains role number followed by space followed by user id.
	 */
	public String getUser() {
		return myRole + " " + myUserId;
	}
}
