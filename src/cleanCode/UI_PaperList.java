package cleanCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Clean Code
 * This class to create a list of papers.
 *
 */
public class UI_PaperList extends JPanel {
	
	/**Adding default serial ID to get rid of error.*/
	private static final long serialVersionUID = 1L;

	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);

	/** Conference. */
	private Conference myConference;
	/** Unique identification number of the user. */
	private int myUserId;
	
	/**
	 * Creates a list of papers.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 */
	public UI_PaperList(final int theUserId, final Conference theConference) {
		super(new BorderLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myConference = theConference;
	}
	
	/**
	 * Sets up the list on a panel.
	 */
	public void setUp() {
		add(makePaperList());
	}
	
	/**
	 * Creates a list of papers.
	 * 
	 * @param theUserId unique identification number of the user.
	 * @param theConference conference.
	 * 
	 * @return a list of papers.
	 */
   private JList makePaperList() {
		 //just for Program Chair
		   Collection<Paper> paperSet = myConference.listOfPaper.values();
		   String[] paperNames = new String[paperSet.size()];
		   int i = 0;
		   for (Paper paper : paperSet) {
			   paperNames[i] = paper.getTitle();
			   i++;
		   }
		   final JList<String> list = new JList<String>(paperNames);
		   
		   list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   list.setLayoutOrientation(JList.VERTICAL);
		//   list.setSelectedIndex(0);
		   
		   list.addListSelectionListener(new ListSelectionListener() {

	            @Override
	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	Map<Integer, Paper> theMap = myConference.listOfPaper;
	                	Iterator it = theMap.entrySet().iterator();
	        		    while (it.hasNext()) {
	        		        Map.Entry pairs = (Map.Entry)it.next();
	        		        Paper tempPaper = (Paper) pairs.getValue();
	        		        if (tempPaper.getTitle().equals(list.
	        		        		getSelectedValue().toString())) {
	        		        	myConference.myPaperToDelete = tempPaper.getId();
	        		        	System.out.println(tempPaper.getId());
	        		        	break;
	        		        	//myConference.removePaper(tempPaper.getId());
	        		        }
	        		      //  it.remove(); 
	        		    }
	                }
	            }
	        });
		   
		   //not sure if this is needed
//			   JScrollPane paperPanel = new JScrollPane(list);
//			   paperPanel.setPreferredSize(new Dimension(100, 150));
//			   paperPanel.add(list);
//			   return paperPanel;
		   
		   return list;
	   }

}
