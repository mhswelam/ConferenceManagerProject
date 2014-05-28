package cleanCode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
	
	/**
	 * Instantiates Log In panel when Conference starts running.
	 */
	public UI_Login() {
		super(new FlowLayout(FlowLayout.CENTER, 300, 100));
//		setPreferredSize(new Dimension(600, 600));
		//White background color
		setBackground(new Color(255, 255, 255));
	}
	
	public void logIn() {
		JPanel loginFrame = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 10));
		loginFrame.setPreferredSize(new Dimension(350, 450));
		Border panelBorder = BorderFactory.createLineBorder(new Color(235, 235, 235), 2);
		loginFrame.setBorder(panelBorder);
		loginFrame.setBackground(new Color(250, 250, 250));
		
		JLabel logInText = new JLabel("Log In");
		logInText.setVerticalTextPosition(JLabel.TOP);
		logInText.setHorizontalTextPosition(JLabel.CENTER);
		
		
		JLabel userNameLabel = new JLabel("Enter User Name");
		JTextField userNameField = new JTextField(20);
		userNameLabel.setLabelFor(userNameField);
		
		JLabel comboBoxText = new JLabel("Select Your Role");
		
		String[] options = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
		JComboBox roles = new JComboBox(options);
		
		comboBoxText.setLabelFor(roles);
		
		JButton logIn = new JButton("Log In");
		
		loginFrame.add(logInText);
		loginFrame.add(userNameLabel);
		loginFrame.add(userNameField);
		loginFrame.add(comboBoxText);
		loginFrame.add(roles);
		loginFrame.add(logIn);
		
		add(loginFrame);
	}
}
