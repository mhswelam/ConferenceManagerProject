package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		JPanel loginFrame = new JPanel();
		loginFrame.setPreferredSize(new Dimension(350, 450));
		Border panelBorder = BorderFactory.createLineBorder(new Color(235, 235, 235), 2);
		loginFrame.setBorder(panelBorder);
		loginFrame.setBackground(new Color(250, 250, 250));
		
		JLabel text = new JLabel("Log In:");
		loginFrame.add(text, BorderLayout.NORTH);
		
		add(loginFrame);
	}
}
