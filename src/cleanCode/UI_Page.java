package cleanCode;

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
	//Observes all other UI classes.
	//Controls changes to all other UI classes.

	/**
	 * Constructs graphical user interface.
	 */
	public UI_Page() {
		myFrame = new JFrame();
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.setBackground(Color.WHITE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void start() {
		myFrame.setVisible(true);
		myFrame.getContentPane().setBackground(Color.WHITE);
		myFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel contentPane = new JPanel();
		myFrame.getContentPane().add(contentPane);
		//700 width 500 height
		myFrame.setBounds(100, 100, 1000, 700);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
