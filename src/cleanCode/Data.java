package cleanCode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author Zack Brentson
 * team CleanCode
 * This class reads and parses an excel spreadsheet.
 */
public class Data {

	/** the excel file you are reading.*/
	private String inputFile;
	
	/** 
	 * Setter method for the input file field.
	 * @param inputFile the file you are reading.
	 */
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * Reads the file and places it into the HashMap myMap.  loops through the excel sheet 
	 * row by row and gathers the information. The first column is the spreadsheet is the 
	 * ID's which will be used as the keys for the map. The second value will be in the first
	 * index of the String [] and it will be the users first name. The second index value will
	 * be the users last name. The third index value will be the users email. The fourth index 
	 * will be the users permission ranking. The fifth index will be the users role in the 
	 * conference.
	 * @throws IOException if no file is found an exception will be thrown.
	 */
	public HashMap<Integer, String[]> read() throws IOException  {
		HashMap<Integer, String[]> theMap = new HashMap<Integer, String[]>();
		File inputWorkbook = new File(inputFile);
		Workbook w;
	    try {
	    	w = Workbook.getWorkbook(inputWorkbook);
		    // Get the first sheet
		    Sheet sheet = w.getSheet(0);
		 
		    for (int j = 0; j < sheet.getRows(); j++) {
		    	String[] list = new String[5];
		    	int key = 0;
		    	for (int i = 0; i < sheet.getColumns(); i++) {
		    		Cell cell = sheet.getCell(i, j);
			        if (i == 0) {
			        	String word = cell.getContents();
			        	key = Integer.parseInt(word);
			        } else {
			        	list[i - 1] = cell.getContents();
			        }
		    	}   
		    	theMap.put(key, list);
		    }
	     } catch (BiffException e) {
	    	 e.printStackTrace();
	     }
	    return theMap;
	 }

	 public static void main(String[] args) throws IOException {
		 Data test = new Data();
	     test.setInputFile("src/lib/NonAuthors.xls");
	     HashMap<Integer, String[]> myMap = test.read();
	     Iterator it = myMap.entrySet().iterator();
	     while (it.hasNext()) {
	         Map.Entry pairs = (Map.Entry)it.next();
	         String[] temp = (String[]) pairs.getValue();
	         System.out.print(pairs.getKey() + " = ");
	         for(String easy: temp) {
	        	 System.out.print(easy + " ");
	         }
	         System.out.println();
	         it.remove(); // avoids a ConcurrentModificationException
	     }
	 }
}
