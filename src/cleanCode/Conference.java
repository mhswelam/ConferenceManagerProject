package cleanCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


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
	 * This to hold the last paper id.
	 */
	public static int lastPaperID = 0;
	

	/**
	 * This is a constructor to create conference
	 */
	public Conference(){
		readConferenceInfo();
		createReviewerMap();
		createAuthorMap();
		createPaperMap();
		System.out.println(listOfPaper.containsKey(145));
		//lastPaperID++;
		//addPaper(new Paper(lastPaperID,55,"Test",0,0,0,0,0,0,0,0,0,PaperStatus.Undecided.toString()));
		//removePaper(140);
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

	/**
	 * This method to create the author map.
	 */
	private void createAuthorMap() {
		listOfAuthors = new HashMap<Integer, User>();
		final String errorMessage = "File not found";
        Scanner toRead = null;
        String [] line = new String[5];
        try {
            final File readFile = new File("authors.csv");
            toRead = new Scanner(readFile);
        } catch (final IOException e) {
            System.out.println(errorMessage);
            System.exit(0);
        }
        
        while (toRead.hasNextLine()) {
            
            line = toRead.nextLine().split(",");
            if (!("UserID".equals(line[0]))) {
            	if (line[4].equals("3")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new Author(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            	} 
            }      
        }
        
        toRead.close();
	}
	/**
	 * This method to create the paper map.
	 */
	private void createPaperMap() {
		listOfPaper = new TreeMap<Integer, Paper>();
		final String errorMessage = "File not found";
        Scanner toRead = null;
        String [] line = new String[13];
        try {
            final File readFile = new File("paper.csv");
            toRead = new Scanner(readFile);
        } catch (final IOException e) {
            System.out.println(errorMessage);
            System.exit(0);
        }
        
        while (toRead.hasNextLine()) {
            
            line = toRead.nextLine().split(",");
            if (!("paperID".equals(line[0]))) {
            	
            	listOfPaper.put(Integer.parseInt(line[0]), 
            				new Paper(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2],Integer.parseInt(line[3]),Integer.parseInt(line[4]),
            						Integer.parseInt(line[5]),Integer.parseInt(line[6]),Integer.parseInt(line[7]),Integer.parseInt(line[8]),Integer.parseInt(line[9]),
            						Integer.parseInt(line[10]),Integer.parseInt(line[11]),line[12]));
            	lastPaperID = Integer.parseInt(line[0]);
            }      
        }
        
        toRead.close();
	}
	
	/**
	 * This method to add a paper to the map and to the file.
	 * @param aPaper
	 */
	public void addPaper(Paper aPaper) {
		
		listOfPaper.put(aPaper.getId(), aPaper);
		
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paper.csv", false)))) {
			out.println("paperID,AuthorID,TheTitle,numOfReviewer,subProgID,recommID,reviewID,reviewID,reviewID,reviewerID,reviewerID,reviewerID,paperStatus");
			for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
				out.println(entry.getKey() + "," + entry.getValue().getAuthor() + "," + entry.getValue().getTitle() + "," + entry.getValue().getReviewers().length 
						+ "," + entry.getValue().getSubProgramChair() + "," + entry.getValue().getRecommendation() + "," + entry.getValue().getReviewers()[0] 
								+ "," + entry.getValue().getReviewers()[1] + "," + entry.getValue().getReviewers()[2]+ "," + entry.getValue().getReviews()[0]
										+ "," + entry.getValue().getReviews()[1] + "," + entry.getValue().getReviews()[2] + "," + entry.getValue().getStatus());
			}
		    
		    out.close();
		}catch (IOException e) {
			System.out.println(e);
            System.exit(0);
		}
	}
	
	/**
	 * This method to remove a paper from the map and from the file.
	 * @param aPaper paper to be removed.
	 */
	public void removePaper(int aPaperId) {
		if (listOfPaper.containsKey(aPaperId)) {
			listOfPaper.remove(aPaperId);
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paper.csv", false)))) {
				out.println("paperID,AuthorID,TheTitle,numOfReviewer,subProgID,recommID,reviewID,reviewID,reviewID,reviewerID,reviewerID,reviewerID,paperStatus");
				for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
					out.println(entry.getKey() + "," + entry.getValue().getAuthor() + "," + entry.getValue().getTitle() + "," + entry.getValue().getReviewers().length 
							+ "," + entry.getValue().getSubProgramChair() + "," + entry.getValue().getRecommendation() + "," + entry.getValue().getReviewers()[0] 
									+ "," + entry.getValue().getReviewers()[1] + "," + entry.getValue().getReviewers()[2]+ "," + entry.getValue().getReviews()[0]
											+ "," + entry.getValue().getReviews()[1] + "," + entry.getValue().getReviews()[2] + "," + entry.getValue().getStatus());
				}
			    
			    out.close();
			}catch (IOException e) {
				System.out.println(e);
	            System.exit(0);
			}
		}
		
	}
	/**
	 * This method to return a reviewer from the the list of reviewer.
	 * @param userID the user id 
	 * @return the user type User.
	 */
	public User getReviewer(int userID) {
		User result = null;
		if (listOfReviewer.containsKey(userID)) {
			result = listOfReviewer.get(userID);
		}
		return result;
	}
	
	/**
	 * This method to return an author from the the list of author.
	 * @param userID the user id 
	 * @return the user type User.
	 */
	public User getAuthor(int userID) {
		User result = null;
		if (listOfAuthors.containsKey(userID)) {
			result = listOfAuthors.get(userID);
		}
		return result;
	}
	
	/**
	 * This method to return true if the user a reviewer,programChair or subprogramChair  otherwise false.
	 * @param userID the user id
	 * @return true if the user a reviewer otherwise false
	 */
	public boolean isReviewer(int userID) {
		if (listOfReviewer.containsKey(userID)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method to return true if the user a reviewer,programChair or subprogramChair  otherwise false.
	 * @param userID the user id
	 * @return true if the user a reviewer otherwise false
	 */
	public boolean isAuthor(int userID) {
		if (listOfAuthors.containsKey(userID)) {
			return true;
		} else {
			return false;
		}
	}
	
}

