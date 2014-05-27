package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

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
		super(new BorderLayout());
		setPreferredSize(new Dimension(300, 400));
		setBackground(new Color(205, 205, 205));
	}
	
	public void logIn() {
//		JPanel mainWindow = new JPanel(new BorderLayout());
//		mainWindow.setBackground(new Color(205, 205, 205));
//		mainWindow.setPreferredSize(new Dimension(300, 400));
		
//		add(mainWindow, BorderLayout.CENTER);

		
//		Object[] choices = {"Author", "Reviewer", "SubProgram Chair", "Program Chair"};
//		JLabel logIn = new JLabel("Log in", JLabel.CENTER);
//		logIn.setVerticalTextPosition(JLabel.CENTER);
//		logIn.setHorizontalTextPosition(JLabel.CENTER);
//		add(logIn, BorderLayout.CENTER);
		
//		JOptionPane.showOptionDialog(this ,"Log In", "Log In", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
	}
}
