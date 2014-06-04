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
//			addReviewScores();
//			addSelectButton(7);
		//SPC
		} else if (myRoleId == 2) {
//			addReviewScores();
//			addSelectButton(5);
		//Author
		} else if (myRoleId == 3) {
//			addSelectButton(3);
		//Reviewer
		} else if (myRoleId == 4) {
//			addSelectButton(3);
		}
	}
	
	/**
	 * Fills the Author and title columns of the table.
	 * All users will see these columns.
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
	
	/**
	 * Adds the reviewer scores for each paper.
	 * Program Chair, Subprogram Chair will see reviews.
	 */
	private void addReviewScores() {
		System.out.println(myPaperList.size());
		int k = 0;
		for (Paper paper : myPaperList) {
			int[] reviewsId = paper.getReviews();
			for (int i = 0; i < reviewsId.length; i++) {
				String data = "";
				Review review = myConference.getReview(reviewsId[i]);
				//If there is no review. Then the paper has not been reviewed.
				if (review == null) {
					data = "Not Reviewed";
				} else {
					data = "" + myConference.getReview(reviewsId[i]).getReviewSummary();
				}
				//Reviews start at index 2 of the table
				myTableData[k][2 + i] = data;
			}
			k++;
		}
	}
	
	/**
	 * Fills check boxes for selected papers. 
	 * All users will see these columns.
	 * 
	 * @param thePosition the placement of "Select" column in the table.
	 */
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
//        	System.out.println(getValueAt(0, c).getClass());
//            return getValueAt(0, c).getClass();
//        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            myTableData[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + myTableData[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}
