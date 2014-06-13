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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Clean code /  Mohamed
 * to create panel to submit review. 
 */
public class UI_SubmitReview extends JPanel implements ActionListener{
	
	private Conference myConferenc;
	
	private Paper myPaper;
	
	private int myUserId; 
	private int myRoleId;
	private JTextField summary_textField;
	private int aField;
	private int bField;
	private int cField;
	private int dField;
	private int eField;
	private int fField;
	private int gField;
	private int hField;
	private int kField;
	
	private JComboBox comboBox_A;
	private JComboBox comboBox_B;
	private JComboBox comboBox_C;
	private JComboBox comboBox_D;
	private JComboBox comboBox_E;
	private JComboBox comboBox_F;
	private JComboBox comboBox_G;
	private JComboBox comboBox_H;
	private JComboBox comboBox_K;
	
	private JButton submitReviewBtn;
	private JButton selectPaperBtn;
	
	private String authorName;
	
	private JLabel currentAuthorLabel;
	private JLabel currentPaper;
	/**
	 * Create the panel.
	 */
	public UI_SubmitReview(Conference aConference, int roleId,int userId) {
		String [] reviewGrade = {"","[1] strong reject","[2] reject","[3] neutral", "[4] accept","[5] strong accept"};
		myConferenc = aConference;
		myRoleId = roleId;
		myUserId = userId;
		myPaper = null;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		
		JLabel paperLabel = new JLabel("Selected Paper :");
		
		currentPaper = new JLabel("");
		
		JLabel authorLabel = new JLabel("Author :");
		
		authorName = "";
		currentAuthorLabel = new JLabel(authorName);
		
		selectPaperBtn = new JButton("Select Paper");
		selectPaperBtn.addActionListener(this);
		
		GroupLayout gl_topPanel = new GroupLayout(topPanel);
		gl_topPanel.setHorizontalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(paperLabel)
					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_topPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(currentPaper)
							.addGap(311)
							.addComponent(currentAuthorLabel)
							.addGap(189))
						.addGroup(gl_topPanel.createSequentialGroup()
							.addGap(190)
							.addComponent(authorLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(selectPaperBtn)
					.addGap(249))
		);
		gl_topPanel.setVerticalGroup(
			gl_topPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_topPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(paperLabel)
							.addComponent(currentPaper)
							.addComponent(authorLabel))
						.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(currentAuthorLabel)
							.addComponent(selectPaperBtn))))
		);
		topPanel.setLayout(gl_topPanel);
		
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		
		JLabel aLabel = new JLabel("Can The content be directly applied by classroom instructors or curriculum designers?    [5] Directly applicable.......[1] Not applicable");
		comboBox_A = new JComboBox(reviewGrade);
		
		
		JLabel bLabel = new JLabel("Does the work appeal to a broad readship interested in engineering education or is it narrowly specialized?  [5] Broad......[1] Narrow");
		
		comboBox_B = new JComboBox(reviewGrade);
		
		JLabel cLable = new JLabel("Does the work address a significant problem?   [5] Significant.....[1] Insignificant");
		
		comboBox_C = new JComboBox(reviewGrade);
		
		JLabel dLabel = new JLabel("Does the author build upon relevant references and bodies of knowlwdge?   [5] Relevant references ....[1] Few if any relevant references");
		
		comboBox_D = new JComboBox(reviewGrade);
		
		JLabel elabel = new JLabel("If a teaching intervention is reported, is it adequately evaluated in terhs of its impact on learning in actual use ?  [5] Excellent ....[1] Inadequate");
		
		comboBox_E = new JComboBox(reviewGrade);
		
		JLabel fLabel = new JLabel("Does the author use methods appropriate to the goals, both for instructional intervention and the evaluation of impact on learning? [5] Appropriate......[1] Inappropriate");
		
		comboBox_F = new JComboBox(reviewGrade);
		
		JLabel gLabel = new JLabel("Did the author provide sufficient detail to replicate and evaluate? [5] Sufficient......[1] Insufficient");
		
		comboBox_G = new JComboBox(reviewGrade);
		
		JLabel hLabel = new JLabel("Is the paper clearly and carfully written? [5] Excellent..........[1]Unacceptable");
		
		comboBox_H = new JComboBox(reviewGrade);
		
		JLabel kLabel = new JLabel("Does the paper adhere to accepted standards of style, usage, and composition?  [5] Excellent.....[1]Unacceptable");
		
		comboBox_K = new JComboBox(reviewGrade);
		
		JLabel summaryLabel = new JLabel("Summary Comments: ");
		
		summary_textField = new JTextField();
		summary_textField.setColumns(10);
		
		submitReviewBtn = new JButton("Submit Review");
		submitReviewBtn.addActionListener(this);
		
		
		GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
		gl_centerPanel.setHorizontalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(aLabel, GroupLayout.PREFERRED_SIZE, 1571, Short.MAX_VALUE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(127)
							.addComponent(comboBox_A, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(128)
							.addComponent(comboBox_B, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(cLable, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(127)
							.addComponent(comboBox_C, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(dLabel, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(128)
							.addComponent(comboBox_D, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(elabel, GroupLayout.PREFERRED_SIZE, 730, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(131)
							.addComponent(comboBox_E, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(fLabel, GroupLayout.PREFERRED_SIZE, 828, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(133)
							.addComponent(comboBox_F, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(gLabel, GroupLayout.PREFERRED_SIZE, 828, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(132)
							.addComponent(comboBox_G, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(hLabel, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(136)
							.addComponent(comboBox_H, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(kLabel, GroupLayout.PREFERRED_SIZE, 647, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addGap(137)
							.addComponent(comboBox_K, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(summaryLabel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_centerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(summary_textField, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
							.addGap(90)
							.addComponent(submitReviewBtn)))
					.addContainerGap())
		);
		gl_centerPanel.setVerticalGroup(
			gl_centerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPanel.createSequentialGroup()
					.addComponent(aLabel)
					.addGap(6)
					.addComponent(comboBox_A, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_B, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cLable, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_C, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_D, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(elabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_E, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(fLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_F, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(gLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_G, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_H, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(kLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_K, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(summaryLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_centerPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(summary_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitReviewBtn))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		centerPanel.setLayout(gl_centerPanel);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(selectPaperBtn)) {
			ArrayList<Paper> myPaperList = myConferenc.getPaperList(myRoleId, myUserId);
			Map<String,Paper> myPapermap = new HashMap<String,Paper>();
			String [] paperT = new String[myPaperList.size()];
			for (int i =0 ; i < myPaperList.size();i++) {
				
					paperT[i] = (myPaperList.get(i).getTitle());
					myPapermap.put(myPaperList.get(i).getTitle(),myPaperList.get(i));
			}
			myPaper = myPapermap.get(JOptionPane.showInputDialog(
	                this,
	                "Please select paper :",
	                "Select Paper",
	                JOptionPane.PLAIN_MESSAGE,
	                null, paperT, ""));
			
			if (myPaper != null) {
				myConferenc.setSelectedPaper(myPaper.getId());
				authorName = myConferenc.getAuthor(myPaper.getAuthor()).myFristName +" " +myConferenc.getAuthor(myPaper.getAuthor()).myLastName;
				currentPaper.setText(myPaper.getTitle());
				currentAuthorLabel.setText(authorName);
			}
			
			
		} else if (e.getSource().equals(submitReviewBtn) && myPaper != null) {
			aField = comboBox_A.getSelectedIndex();
			bField = comboBox_B.getSelectedIndex();
			cField = comboBox_C.getSelectedIndex();
			dField = comboBox_D.getSelectedIndex();
			eField = comboBox_E.getSelectedIndex();
			fField = comboBox_F.getSelectedIndex();
			gField = comboBox_G.getSelectedIndex();
			hField = comboBox_H.getSelectedIndex();
			kField = comboBox_K.getSelectedIndex();
			String summary = summary_textField.getText();
			if (summary.length()>0 && aField > 0 && bField > 0 && cField > 0 && dField > 0 && eField > 0 && fField > 0 && gField > 0 && hField > 0 && kField > 0) {
				int nextReview = ++myConferenc.lastReviewID;
				myConferenc.addReview(new Review (nextReview, myConferenc.getSelectedPaper(),myUserId,aField,bField,cField,dField,eField,fField,gField,hField,kField,summary));
				JOptionPane.showMessageDialog(this,
					    "Thank you, The paper review has been submited.");
				
			} else {
				JOptionPane.showMessageDialog(this,
					    "Please make sure to fill all fields!");
			}
		} else {
			JOptionPane.showMessageDialog(this,
				    "Please select paper !");
		}
		
		
	}
}
