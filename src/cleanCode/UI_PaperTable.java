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
			addReviewScores();
			addSPCScore();
			addAcceptanceStatus(6);
			addSelectButton(7);
		//SPC
		} else if (myRoleId == 2) {
			addReviewScores();
			addSelectButton(5);
		//Author
		} else if (myRoleId == 3) {
			addAcceptanceStatus(2);
			addSelectButton(3);
		//Reviewer
		} else if (myRoleId == 4) {
			addReviewerScore();
			addSelectButton(3);
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
	 * Adds the score of the paper particular reviewer.
	 */
	private void addReviewerScore() {
		int i = 0;
		for (Paper paper : myPaperList) {
			int[] reviewsId = paper.getReviews();
			for (int k = 0; k < reviewsId.length; k++) {
				Review rev = myConference.getReview(reviewsId[i]);
				int reviewerId = rev.getMyReviewerId();
				if (reviewerId == myUserId) {
					int temp = rev.getReviewSummary();
					String data = "";
					if (temp == 0) {
						data = "Not Reviewed";
					} else {
						data = "" + temp;
					}
					myTableData[i][2] = data;
				}
			}
			i++;
		}
	}
	
	/**
	 * Shows the Subprogram Chair score for the paper.
	 */
	private void addSPCScore() {
		int i = 0;
		for (Paper paper : myPaperList) {
			int rec = paper.getRecommendation();
			String score = "";
			if (rec == 0) {
				score = "Not Reviewed";
			} else {
				score = "" + rec;
			}
			myTableData[i][5] = score;
			i++;
		}
	}
	
	/**
	 * Shows the acceptance status of paper.
	 * @param theIndex index of the acceptance status field in the table.
	 */
	private void addAcceptanceStatus(final int theIndex) {
		int i = 0;
		for (Paper paper : myPaperList) {
			String status = paper.getStatus();
			myTableData[i][theIndex] = status;
			i++;
		}
	}
	
	/**
	 * Fills check boxes for selected papers. 
	 * All users will see these columns.
	 * 
	 * @param thePosition the placement of "Select" column in the table.
	 */
	private void addSelectButton(final int thePosition) {
		for (int i = 0; i < myPaperList.size(); i++) {
			myTableData[i][thePosition] = new Boolean(false);
		}
	}
	
	/**
	 * Class that determines the table model.
	 * 
	 * @author Clean Code
	 *
	 */
	private class MyTableModel extends AbstractTableModel {
		
		/**
		 * @return returns number of columns.
		 */
        public int getColumnCount() {
            return COLUMN_NAMES[myRoleId].length;
        }

        /**
         * @return number of rows.
         */
        public int getRowCount() {
            return myTableData.length;
        }

        /**
         * Retrieves name of the column.
         * 
         * @param theColumn column index.
         * 
         * @return returns name of the index.
         */
        public String getColumnName(final int theColumn) {
            return COLUMN_NAMES[myRoleId][theColumn];
        }

        /**
         * Retrieves the value in the selected row and column.
         * 
         * @param theRow row index.
         * @param theColumn column index.
         * 
         * @return returns object of the data.
         */
        public Object getValueAt(final int theRow, final int theColumn) {
            return myTableData[theRow][theColumn];
        }

        /**
         * Sets up the table to render data.
         * 
         * @param theColumn column index.
         * 
         * @return returns the class of the value in the table.
         */
        public Class getColumnClass(final int theColumn) {
            return getValueAt(0, theColumn).getClass();
        }

        /**
         * Lets user edit the last cell in the table.
         * 
         * @param theRow row index.
         * @param theColumn column index.
         * 
         * @return returns true if the column is editable, false if not.
         */
        public boolean isCellEditable(final int theRow, final int theColumn) {
            if (theColumn == myTableData[myRoleId].length - 1) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Changes the data in the table.
         * 
         * @param theValue object that will be in the cell.
         * @param theRow row index.
         * @param theColumn column index.
         */
        public void setValueAt(final Object theValue, final int theRow, 
        		final int theColumn) {
            myTableData[theRow][theColumn] = theValue;
            fireTableCellUpdated(theRow, theColumn);
        }
    }
}
