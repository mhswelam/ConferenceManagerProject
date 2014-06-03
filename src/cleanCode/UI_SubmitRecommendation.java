package cleanCode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class UI_SubmitRecommendation extends JPanel implements ActionListener{
	
    private Conference myConferenc;
	
	private Paper myPaper;
	
	private int myUserId; 
	private JTextArea rational_TextArea;
	private int aField;
	private JComboBox comboBox_Grade;

	/**
	 * Create the panel.
	 */
	public UI_SubmitRecommendation(Conference aConference, Paper aPaper, int userId) {
		
		String [] reviewGrade = {"","[1] strong reject","[2] reject","[3] neutral", "[4] accept","[5] strong accept"};
		myConferenc = aConference;
		myPaper = aPaper;
		myUserId = userId;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		
		JLabel paperLabel = new JLabel("Selected Paper :");
		topPanel.add(paperLabel);
		
		JLabel currentPaper = new JLabel(myPaper.getTitle());
		topPanel.add(currentPaper);
		
		JLabel authorLabel = new JLabel("Author :");
		topPanel.add(authorLabel);
		
		String authorName = myConferenc.getAuthor(myPaper.getAuthor()).myFristName +" " +myConferenc.getAuthor(myPaper.getAuthor()).myLastName;
		JLabel currentAuthorLabel = new JLabel(authorName);
		topPanel.add(currentAuthorLabel);
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		JLabel gradLabel = new JLabel("Summary Recommendation : ");
		
		comboBox_Grade = new JComboBox(reviewGrade);
		
		JLabel rationalLabel = new JLabel("Rational for Recommendation : ");
		
		JButton submit_Rec_Btn = new JButton("Submit Recommendation");
		submit_Rec_Btn.addActionListener(this);
		
		rational_TextArea = new JTextArea();
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addGap(46)
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(rational_TextArea, Alignment.LEADING)
						.addComponent(rationalLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.LEADING, gl_centerPanel.createSequentialGroup()
							.addComponent(gradLabel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox_Grade, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_centerPanel.createSequentialGroup()
							.addGap(355)
							.addComponent(submit_Rec_Btn)))
					.addContainerGap(349, Short.MAX_VALUE))
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox_Grade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(gradLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(rationalLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rational_TextArea, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(submit_Rec_Btn)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		centerPanel.setLayout(gl_centerPanel);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		aField = comboBox_Grade.getSelectedIndex();
		String summary = rational_TextArea.getText();
		if (summary.length() > 0 && aField > 0) {
			int nextRecom = ++myConferenc.lastRecommendationID;
			myConferenc.addRecommendation(new Recommendation(nextRecom, myPaper.getId(), myUserId, aField, summary));
			JOptionPane.showMessageDialog(this,
				    "Thank you, The paper recommendation has been submited.");
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please make sure to fill all fields!");
		}
		
	}
}
