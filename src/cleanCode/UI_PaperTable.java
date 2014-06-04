package cleanCode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * @author Clean Code
 * This class to create a table containing information at a glance.
 *
 */
public class UI_PaperTable extends JPanel {
	boolean DEBUG = false;
	/** Column headers of the table. */
	private final static String[][] COLUMN_NAMES = {{},																//Empty 			0
		{"Author", "Title", "Review 1", "Review 2", "Review 3", "Subprogram Chair", "Acceptence Status", "Select"},	//Program Chair 	1
		{"Author", "Title", "Review 1", "Review 2", "Review 3", "Select"}, 											//SubProgram Chair	2
		{"Author", "Title", "Acceptence Status", "Select"},															//Author			3
		{"Author", "Title", "Review", "Select"}};																	//Reviewer			4
	
	/** Background color is white. */
	private final static Color BACKGROUND_COLOR = new Color(255, 255, 255);
	
	/** Unique identification number of the user. */
	private int myUserId;
	/** Role of the user. */
	private int myRoleId;
	/** Conference. */
	private Conference myConference;
	/** List of papers that this user needs to see. */
	private ArrayList<Paper> myPaperList;
	/** Data that will be contained within the table. */
	private Object[][] myTableData;
	
	/**
	 * Creates a table containing all the papers.
	 * 
	 * @param theTheUserId unique user identification number.
	 * @param theRoleId role identification number.
	 * @param theConference conference.
	 */
	public UI_PaperTable(final int theUserId, final int theRoleId, 
			final Conference theConference) {
		super(new FlowLayout());
		setBackground(BACKGROUND_COLOR);
		myUserId = theUserId;
		myRoleId = theRoleId;
		myConference = theConference;
		myPaperList = myConference.getPaperList(myRoleId, myUserId);
		myTableData = new Object[myPaperList.size()][COLUMN_NAMES[myRoleId].length];
	}

	/**
	 * Creates the panel that contains paper information.
	 */
	public void setUp() {
		setData();
		JTable table = new JTable(new MyTableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(BACKGROUND_COLOR);
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(750, 500));
		table.setBackground(BACKGROUND_COLOR);
		add(scrollPane);
	}
	//Add another column with radio button that will select the paper.
	//Then the next tab will contain the information for the paper.
	/**
	 * Retrieves all paper data for the table. 
	 * 
	 * @return data from all the papers.
	 */
	private void setData() {
		//Names at titles of the paper are included for all users.
		fillNameTitle();
		//Program Chair
		if (myRoleId == 1) {
			addSelectButton(7);
		//SPC
		} else if (myRoleId == 2) {
			addSelectButton(5);
		//Author
		} else if (myRoleId == 3) {
			addSelectButton(3);
		//Reviewer
		} else if (myRoleId == 4) {
			addSelectButton(3);
		}
	}
	
	/**
	 * Fills the Author and title columns of the table.
	 * 
	 */
	private void fillNameTitle() {
		int i = 0;
		for (Paper paper : myPaperList) {
			int authorId = paper.getAuthor();
			//Retrieving Authors first and last name.
			String firstName = myConference.getAuthor(authorId).myFristName;
			String lastName = myConference.getAuthor(authorId).myLastName;
			String wholeName = firstName + " " + lastName;
			myTableData[i][0] = wholeName;

			//Title of the paper
			String title = paper.getTitle();
			myTableData[i][1] = title;
			i++;
		}
	}
	
	private void addSelectButton(final int thePosition) {
		myTableData[0][thePosition] = new Boolean(false);

//		JRadioButton select = new JRadioButton();
		for (int i = 1; i < myPaperList.size(); i++) {
			myTableData[i][thePosition] = new Boolean(false);
		}
		
	}
	
	/**
	 * Class that determines the table 
	 * 
	 * @author Clean Code
	 *
	 */
	private class MyTableModel extends AbstractTableModel {
 	    
	    public int getColumnCount() {
            return COLUMN_NAMES[myRoleId].length;
        }
 
        public int getRowCount() {
            return myTableData.length;
        }
 
        public String getColumnName(int col) {
            return COLUMN_NAMES[myRoleId][col];
        }
 
        public Object getValueAt(int row, int col) {
            return myTableData[row][col];
        }
 
        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
// 
        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
           return false;
        }
        
        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            myTableData[row][col] = value;
            fireTableCellUpdated(row, col);
        }
	}
}
