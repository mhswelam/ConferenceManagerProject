package cleanCode;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * This class to create conference class to hold information about it and all needed map
 * that hold the data
 * 
 * @author Clean code / Mohamed
 *
 */
public class Conference {
	
	/**
	 * This to hold the conference name.
	 */
	public String myName;
	/**
	 * This to hold the conference description.
	 */
	public String myDescription;
	/**
	 * This to hold the conference paper due date.
	 */
	public Date myPaperDueDate;
	/**
	 * This to hold the conference program Chair.
	 */
	public int myProgramChair;
	/**
	 * This to hold the list of the reviewer include program chair and the sub program chairs.
	 */
	public static Map<Integer, User> listOfReviewer;
	/**
	 * This to hold the conference list of the authors.
	 */
	public static Map<Integer, User> listOfAuthors;
	/**
	 * This to hold the conference list of the paper.
	 */
	public static Map<Integer, Paper> listOfPaper;
	

	/**
	 * This is a constructor to create conference
	 */
	public Conference(){
		readConferenceInfo();
		createReviewerMap();
	}
	
	/**
	 * This method to read the conference file and save the info.
	 */
	private void readConferenceInfo(){
		final String errorMessage = "File not found.";
		DateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		 Scanner toRead = null;
	        String [] lines = new String[4];
	        int index = 0;
	        try {
	            final File readFile = new File("conferenceInfo.txt");
	            toRead = new Scanner(readFile);
	        } catch (final IOException e) {
	            System.out.println(errorMessage);
	            System.exit(0);
	        }
	        
	        while (toRead.hasNextLine()) {
	            
	            lines[index] = toRead.nextLine();
	            index++;
	        }
	        toRead.close();
	        myName = lines[0];
	        myDescription = lines[1];
	        
				try {
					myPaperDueDate = formatter.parse(lines[2]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			myProgramChair = Integer.parseInt(lines[3]);
	        
	}
	
	/**
	 * This method to create the reviewer map.
	 */
	private void createReviewerMap() {
		listOfReviewer = new HashMap<Integer, User>();
		final String errorMessage = "File not found";
        Scanner toRead = null;
        String [] line = new String[5];
        try {
            final File readFile = new File("vipUsers.csv");
            toRead = new Scanner(readFile);
        } catch (final IOException e) {
            System.out.println(errorMessage);
            System.exit(0);
        }
        
        while (toRead.hasNextLine()) {
            
            line = toRead.nextLine().split(",");
            if (!("UserID".equals(line[0]))) {
            	if (line[4].equals("4")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new Reviewer(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            	} else if (line[4].equals("1")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new ProgramChair(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            	} else if (line[4].equals("2")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new SubProgramChair(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            	}
            }      
        }
        
        toRead.close();
	}
	
}
