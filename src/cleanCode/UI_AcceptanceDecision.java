package cleanCode;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JRadioButton;

/**
 * @author Clean Code
 * This class to a page that lets Program Chair 
 * Accept/Deny Paper in the conference. 
 *
 */
public class UI_AcceptanceDecision extends JPanel {
	
	/**
	 * Creates a panel that lets Program Chair Accept/Reject selected paper.
	 * @param theTheUserId unique user identification number.
	 * @param theRoleId role identification number.
	 * @param theConference conference.
	 */
	public UI_AcceptanceDecision(final int theUserId, final int theRoleId,
			final Conference theConference) {
		super(new BorderLayout());
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		
		JLabel lblTitle = new JLabel("Title: ");
		
		JLabel lblAuthor = new JLabel("Author: ");
		
		JLabel lblNotSelected = new JLabel("Not Selected");
		
		JLabel lblNotSelected_1 = new JLabel("Not Selected");
		
		JLabel lblMakeDecision = new JLabel("Make Decision: ");
		
		JRadioButton rdbtnAccept = new JRadioButton("Accept Paper");
		
		JRadioButton rdbtnDeny = new JRadioButton("Deny Paper");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMakeDecision)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAuthor)
										.addComponent(lblTitle))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNotSelected_1)
										.addComponent(lblNotSelected)))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnAccept)))
							.addGap(63)
							.addComponent(rdbtnDeny)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(lblNotSelected))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(lblNotSelected_1))
					.addGap(137)
					.addComponent(lblMakeDecision)
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAccept)
						.addComponent(rdbtnDeny))
					.addContainerGap(269, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(500, 50));
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		JLabel lblMakeAcceptenceDesicion = new JLabel("Make Acceptence Desicion ");
		lblMakeAcceptenceDesicion.setBounds(168, 28, 193, 16);
		panel_1.add(lblMakeAcceptenceDesicion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(100, 500));
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setPreferredSize(new Dimension(100, 500));
		add(panel_3, BorderLayout.EAST);
	}
}
