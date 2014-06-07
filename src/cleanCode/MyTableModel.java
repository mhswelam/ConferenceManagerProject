package cleanCode;
import javax.swing.table.AbstractTableModel;

/**
 * Class that determines the table model.
 * 
 * @author Clean Code
 *
 */
public class MyTableModel extends AbstractTableModel {
	/** Column headers of the table. */				 
	private final static String[][] COLUMN_NAMES = {
		//Empty 			0
		{},						
		//Program Chair 	1
		{"Author", "Title", "Review 1", "Review 2", "Review 3", 
		"Subprogram Chair : Review", "Acceptence Status", "Select"},	
		//SubProgram Chair	2
		{"Author", "Title", "Review 1", "Review 2", "Review 3", "Select"}, 
		//Author			3
		{"Author", "Title", "Acceptence Status", "Select"},			
		//Reviewer			4
		{"Author", "Title", "Review", "Select"}};			
	/** Data that will be contained within the table. */
	private Object[][] myTableData;
	private int myRoleId;
	
	
	public MyTableModel(final int theRoleId, final Object[][] theTableData) {
		super();
		myTableData = theTableData;
		myRoleId = theRoleId;
	}
	
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