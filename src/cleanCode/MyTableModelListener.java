package cleanCode;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
* Updates information in Assign to Subprogram Chair, Assign to Reviewer
* and Accept Decision Panels.
* 
* @author CleanCode
*
*/
public class MyTableModelListener implements ListSelectionListener {
   /** Table that displays the papers.*/
   private UI_PaperTable myPaperTable;
   /** Panel that lets Program Chair assign Paper to Subprogram Chair.
    *  Panel that lets Subprogram Chair assign Paper to Reviewers.*/
   private UI_AssignToPaper myAssignToPaper;
   /** Panel that lets Program Chair accept or deny paper.*/
   private UI_AcceptanceDecision myAcceptPaper;
   
   /**
    * Creates a listener that updates the 
    * Information for appropriate panels.
    * 
    * @param theTable table that displays all the papers.
    * @param theAssignToPaper panel that lets assign a user to the paper.
    * @param theAcceptPaper panel that lets Program Chair accept/deny paper.
    */
   public MyTableModelListener(final UI_PaperTable theTable, 
		   					   final UI_AssignToPaper theAssignToPaper, 
		   					   final UI_AcceptanceDecision theAcceptPaper) {
	   super();
	   myPaperTable = theTable;
	   myAssignToPaper = theAssignToPaper;
	   myAcceptPaper = theAcceptPaper;
   }
   
   /**
    * Changes the paper that will be displayed in the other panels.
    * 
    * @param theEvent event that specifies if a table row has been selected.
    */
	@Override
	public void valueChanged(ListSelectionEvent theEvent) {
		final int row = myPaperTable.getTable().getSelectedRow();
		Paper tempPaper = myPaperTable.getSelectedPaper(row);
		if (myAssignToPaper != null) {
	    	myAssignToPaper.setDisplayPaper(tempPaper);
		} 
		if (myAcceptPaper != null) {
	    	myAcceptPaper.setDisplayPaper(tempPaper);
		}
	}
}