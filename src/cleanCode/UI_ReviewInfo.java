package cleanCode;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

public class UI_ReviewInfo extends JPanel implements ActionListener{
	
	private Paper myPaper;
	
	private int [] myReviewList;
	
	private String [] reviewGrade = {"","[1] strong reject","[2] reject","[3] neutral", "[4] accept","[5] strong accept"};
	
	private int aField;
	private int bField;
	private int cField;
	private int dField;
	private int eField;
	private int fField;
	private int gField;
	private int hField;
	private int kField;
	
	private JButton review_One_Btn;
	private JButton review_Two_Btn;
	private JButton review_Three_Btn;

	/**
	 * Create the panel.
	 */
	public UI_ReviewInfo(Paper aPaper) {
		myPaper = aPaper;
		myReviewList = myPaper.getReviewers();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel top_Panel = new JPanel();
		add(top_Panel, BorderLayout.NORTH);
		top_Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		review_One_Btn = new JButton("First Review");
		review_One_Btn.addActionListener(this);
		top_Panel.add(review_One_Btn);
		
		review_Two_Btn = new JButton("Second Review");
		review_Two_Btn.addActionListener(this);
		top_Panel.add(review_Two_Btn);
		
		review_Three_Btn = new JButton("Third Review");
		review_Three_Btn.addActionListener(this);
		top_Panel.add(review_Three_Btn);
		
		JPanel center_Panel = new JPanel();
		add(center_Panel, BorderLayout.CENTER);
		
		JLabel aLabel = new JLabel("Can The content be directly applied by classroom instructors or curriculum designers?");
		
		JLabel a_Answer = new JLabel("New label");
		
		JLabel bLabel = new JLabel("Does the work appeal to a broad readship interested in engineering education or is it narrowly specialized?");
		
		JLabel b_Answer = new JLabel("New label");
		
		JLabel cLabel = new JLabel("Does the work address a significant problem?");
		
		JLabel c_Answer = new JLabel("New label");
		
		JLabel dLabel = new JLabel("Does the author build upon relevant references and bodies of knowlwdge?");
		
		JLabel eLabel = new JLabel("If a teaching intervention is reported, is it adequately evaluated in terhs of its impact on learning in actual use ?");
		
		JLabel fLabel = new JLabel("Does the author use methods appropriate to the goals, both for instructional intervention and the evaluation of impact on learning?");
		
		JLabel gLabel = new JLabel("Did the author provide sufficient detail to replicate and evaluate?");
		
		JLabel hLable = new JLabel("Is the paper clearly and carfully written?");
		
		JLabel kLable = new JLabel("Does the paper adhere to accepted standards of style, usage, and composition?");
		
		JTextPane ratinal_textPane = new JTextPane();
		ratinal_textPane.setEditable(false);
		
		JLabel d_Answer = new JLabel("New label");
		
		JLabel e_Answer = new JLabel("New label");
		
		JLabel f_Answer = new JLabel("New label");
		
		JLabel g_Answer = new JLabel("New label");
		
		JLabel h_Answer = new JLabel("New label");
		
		JLabel k_Answer = new JLabel("New label");
		GroupLayout gl_center_Panel = new GroupLayout(center_Panel);
		gl_center_Panel.setHorizontalGroup(
			gl_center_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_center_Panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_center_Panel.createSequentialGroup()
							.addComponent(ratinal_textPane, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_center_Panel.createSequentialGroup()
							.addGroup(gl_center_Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(aLabel)
								.addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(cLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(dLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(eLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(fLabel, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
								.addComponent(gLabel, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(hLable, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
								.addComponent(kLable, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addGroup(gl_center_Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(k_Answer)
								.addComponent(h_Answer)
								.addComponent(g_Answer)
								.addComponent(f_Answer)
								.addComponent(e_Answer)
								.addComponent(d_Answer)
								.addComponent(c_Answer)
								.addComponent(b_Answer)
								.addComponent(a_Answer))
							.addGap(51))))
		);
		gl_center_Panel.setVerticalGroup(
			gl_center_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_center_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(aLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(a_Answer))
					.addGap(26)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(bLabel)
						.addComponent(b_Answer))
					.addGap(29)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cLabel)
						.addComponent(c_Answer))
					.addGap(28)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dLabel)
						.addComponent(d_Answer))
					.addGap(27)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(eLabel)
						.addComponent(e_Answer))
					.addGap(31)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fLabel)
						.addComponent(f_Answer))
					.addGap(32)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(gLabel)
						.addComponent(g_Answer))
					.addGap(33)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(hLable)
						.addComponent(h_Answer))
					.addGap(32)
					.addGroup(gl_center_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(kLable)
						.addComponent(k_Answer))
					.addGap(34)
					.addComponent(ratinal_textPane, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		center_Panel.setLayout(gl_center_Panel);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(review_One_Btn)) {
			
		} else if (e.getSource().equals(review_Two_Btn)) {
			
		}else if (e.getSource().equals(review_Three_Btn)) {
			
		}
		
	}
	
	
	private String getValue(int index) {
		String result = reviewGrade[index];
		return result;
	}
}
