package cleanCode;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI_SubmitReview extends JPanel {
	
	private Conference myConferenc;
	
	private Paper myPaper;

	/**
	 * Create the panel.
	 */
	public UI_SubmitReview(Conference aConference, Paper aPaper) {
		String [] reviewGrade = {"","[1] strong reject","[2] reject","[3] neutral", "[4] accept","[5] strong accept"};
		myConferenc = aConference;
		myPaper = aPaper;
		
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
		
		JLabel aLabel = new JLabel("Can The content be directly applied by classroom instructors or curriculum designers?    [5] Directly applicable.......[1] Not applicable");
		JComboBox comboBox_A = new JComboBox(reviewGrade);
		
		JLabel bLabel = new JLabel("Does the work appeal to a broad readship interested in engineering education or is it narrowly specialized?  [5] Broad......[1] Narrow");
		
		JComboBox comboBox_B = new JComboBox(reviewGrade);
		
		JLabel cLable = new JLabel("Does the work address a significant problem?   [5] Significant.....[1] Insignificant");
		
		JComboBox comboBox_C = new JComboBox(reviewGrade);
		
		JLabel dLabel = new JLabel("Does the author build upon relevant references and bodies of knowlwdge?   [5] Relevant references ....[1] Few if any relevant references");
		
		JComboBox comboBox_D = new JComboBox(new Object[]{});
		
		JLabel elabel = new JLabel("If a teaching intervention is reported, is it adequately evaluated in terhs of its impact on learning in actual use ?  [5] Excellent ....[1] Inadequate");
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(140)
							.addComponent(comboBox_A, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(aLabel, GroupLayout.PREFERRED_SIZE, 1057, Short.MAX_VALUE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(141)
							.addComponent(comboBox_B, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(cLable, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(139)
							.addComponent(comboBox_C, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(dLabel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(143)
							.addComponent(comboBox_D, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(elabel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addComponent(aLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_A, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_B, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cLable, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_C, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_D, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(elabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		centerPanel.setLayout(gl_centerPanel);
		
		
		

	}
}
