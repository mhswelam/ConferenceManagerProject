package cleanCode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	public int myPaperToDelete;
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
	 * This to hold the conference list of reviews.
	 */
	public static Map<Integer, Review> listOfReviews;
	/**
	 * This to hold the conference list of recommendation.
	 */
	public static Map<Integer, Recommendation> listOfRecommendation;
	/**
	 * This to hold the last paper id.
	 */
	public int lastPaperID = 0;
	/**
	 * This to hold the last review id.
	 */
	public int lastReviewID = 0;
	/**
	 * This to hold the last recommendation id.
	 */
	public int lastRecommendationID = 0;

	/**
	 * This is a constructor to create conference
	 */
	public Conference(){
		readConferenceInfo();
		createReviewerMap();
		createAuthorMap();
		createPaperMap();
		createReviewMap();
		createRecommendationMap();
		//System.out.println(lastPaperID);
		//addPaper(new Paper(++lastPaperID,65,"Test",3,0,0,0,0,0,0,0,0,"No status"));
		//lastRecommendationID++;
		//addRecommendation(new Recommendation(lastRecommendationID, 99, 23, 1, "It is working"));
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
        String [] line = new String[6];
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
            				new Reviewer(Integer.parseInt(line[0]), line[1], line[2], line[3],Integer.parseInt(line[5])));
            	} else if (line[4].equals("1")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new ProgramChair(Integer.parseInt(line[0]), line[1], line[2], line[3]));
            		myProgramChair = Integer.parseInt(line[0]);
            	} else if (line[4].equals("2")) {
            		listOfReviewer.put(Integer.parseInt(line[0]), 
            				new SubProgramChair(Integer.parseInt(line[0]), line[1], line[2], line[3], Integer.parseInt(line[5])));
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
        String [] line = new String[6];
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
            		listOfAuthors.put(Integer.parseInt(line[0]), 
            				new Author(Integer.parseInt(line[0]), line[1], line[2], line[3],Integer.parseInt(line[5])));
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
	 * This method to create the review map.
	 */
	private void createReviewMap() {
		listOfReviews = new TreeMap<Integer, Review>();
		final String errorMessage = "File not found";
        Scanner toRead = null;
        String [] line = new String[13];
        try {
            final File readFile = new File("reviews.csv");
            toRead = new Scanner(readFile);
        } catch (final IOException e) {
            System.out.println(errorMessage);
            System.exit(0);
        }
        while (toRead.hasNextLine()) {
            
            line = toRead.nextLine().split(",");
            if (!("reviewId".equals(line[0]))) {
            	listOfReviews.put(Integer.parseInt(line[0]), new Review(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), 
            			Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6]),Integer.parseInt(line[7]),Integer.parseInt(line[8]),
            					Integer.parseInt(line[9]),Integer.parseInt(line[10]),Integer.parseInt(line[11]),line[12]));
            	lastReviewID = Integer.parseInt(line[0]);
            }      
        }
        
        toRead.close();
        
	}
	/**
	 * This method to create the recommendation map.
	 */
	private void createRecommendationMap() {
		listOfRecommendation = new TreeMap<Integer, Recommendation>();
		final String errorMessage = "File not found";
        Scanner toRead = null;
        String [] line = new String[5];
        try {
            final File readFile = new File("recommendation.csv");
            toRead = new Scanner(readFile);
        } catch (final IOException e) {
            System.out.println(errorMessage);
            System.exit(0);
        }
        while (toRead.hasNextLine()) {
            
            line = toRead.nextLine().split(",");
            if (!("recommendationId".equals(line[0]))) {
            	listOfRecommendation.put(Integer.parseInt(line[0]), new Recommendation(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), 
            			Integer.parseInt(line[3]), line[4]));
            	lastRecommendationID = Integer.parseInt(line[0]);
            }      
        }
        
        toRead.close();
	}
	/**
	 * This method to add a review to the map and to the file.
	 * @param aReview
	 */
	public void addReview(Review aReview) {
		listOfReviews.put(aReview.getMyReviewId(), aReview);
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reviews.csv", false)))) {
			out.println("reviewId,paperId,reviewerId,fristComment,secondComment,thirdComment,forthComment,FivthComment,SixthComment,SeventhComment,EighthComment,NinethComment,Summary");
			for (Entry<Integer, Review> entry: listOfReviews.entrySet()) {
				out.println(entry.getKey() + "," + entry.getValue().getMyPaperId() + "," + entry.getValue().getMyReviewerId() + "," + 
						entry.getValue().getMyComments()[0]+ "," + entry.getValue().getMyComments()[1]+ "," + entry.getValue().getMyComments()[2] + "," +
						entry.getValue().getMyComments()[3]+ "," + entry.getValue().getMyComments()[4]+ "," + entry.getValue().getMyComments()[5]+ "," + entry.getValue().getMyComments()[6]
								+ "," + entry.getValue().getMyComments()[7]+ "," + entry.getValue().getMyComments()[8]+ "," + entry.getValue().getMySummary());
			}
			out.close();
		}catch (IOException e) {
			System.out.println(e);
            System.exit(0);
		}
		Paper temp = listOfPaper.get(aReview.getMyPaperId());
		listOfPaper.put(aReview.getMyPaperId(), 
				new Paper(temp.getId(),temp.getAuthor(), temp.getTitle(), temp.getNumReviewers(),
						temp.getSubProgramChair(), aReview.getMyReviewId(), temp.getReviews()[0],
						temp.getReviews()[1], temp.getReviews()[2], temp.getReviewers()[0],temp.getReviewers()[1],
						temp.getReviewers()[2], temp.getStatus()));
		writePaperMapToFile();
	}

	/**
	 * This method to add a recommendation to the map and to the file.
	 * it will update the paper with the recommendation.
	 * @param aRecomm a recommendation
	 */
	public void addRecommendation(Recommendation aRecomm) {
		listOfRecommendation.put(aRecomm.getMyrecommendationId(), aRecomm);
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("recommendation.csv", false)))) {
			out.println("recommendationId,paperId,subProgramId,grade,rational");
			for (Entry<Integer, Recommendation> entry: listOfRecommendation.entrySet()) {
				out.println(entry.getKey() + "," + entry.getValue().getMyPaperID() + "," + entry.getValue().getMySubProgramID() + "," + 
						entry.getValue().getGrade()+ "," + entry.getValue().getRational());
			}
			out.close();
		}catch (IOException e) {
			System.out.println(e);
            System.exit(0);
		}
		Paper temp = listOfPaper.get(aRecomm.getMyPaperID());
		listOfPaper.put(aRecomm.getMyPaperID(), 
				new Paper(temp.getId(),temp.getAuthor(), temp.getTitle(), temp.getNumReviewers(),
						temp.getSubProgramChair(), aRecomm.getMyrecommendationId(), temp.getReviews()[0],
						temp.getReviews()[1], temp.getReviews()[2], temp.getReviewers()[0],temp.getReviewers()[1],
						temp.getReviewers()[2], temp.getStatus()));
		writePaperMapToFile();
		
	}
	/**
	 * This method to return review if exists if not it will return null.
	 * @param aReviewID review id
	 * @return the review or null
	 */
	public Review getReview(int aReviewID) {
		if (listOfReviews.containsKey(aReviewID)) {
			return listOfReviews.get(aReviewID);
		} else {
			return null;
		}
	}
	
	/**
	 * This method to return recommendation if exists if not it will return null.
	 * @param aRecommendationID recommendation id
	 * @return the recommendation or null
	 */
	public Recommendation getRecommendation(int aRecommendationID) {
		if (listOfRecommendation.containsKey(aRecommendationID)) {
			return listOfRecommendation.get(aRecommendationID);
		} else {
			return null;
		}
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
		// if the author a reviewer or subprogram or program chair it will be added to author list
		if(!isAuthor(aPaper.getAuthor())) {
			addAuthor(aPaper.getAuthor());
		}
	}
	
	/**
	 * This will write the paper map to file.
	 */
	public void writePaperMapToFile() {
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
	 * This method to return a array list of paper for each user reflecting their role
	 * 
	 * @param aRoleID the role id 1 or 2 or 3 or 4
	 * @param userId the user id
	 * @return a array list of paper if user has any otherwise will return empty array list.
	 */
	public ArrayList<Paper> getPaperList(int aRoleID, int userId) {
		ArrayList<Paper> result = new ArrayList<Paper>();
		if (aRoleID == 1) {
			for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
				result.add(entry.getValue());
			}
		} else if (aRoleID == 2) {
			for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
				if (entry.getValue().getSubProgramChair() == userId) {
					result.add(entry.getValue());
				}
			}
			// check reviewers
		} else if (aRoleID == 4){
			for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
				if (entry.getValue().getReviewers()[0] == userId || 
						entry.getValue().getReviewers()[1] == userId || entry.getValue().getReviewers()[2] == userId) {
					result.add(entry.getValue());
				}
			}
		} else if (aRoleID == 3) {
			for (Entry<Integer, Paper> entry: listOfPaper.entrySet()) {
				if (entry.getValue().getAuthor() == userId) {
					result.add(entry.getValue());
				}
			}
		}
		return result;
	}

	
	/**
	 * This method to return a reviewer from the the list of reviewer.
	 * @param userID the user id 
	 * @return the user type User it will return null if user not exist.
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
	 * @return the user type User it will return null if user not exist.
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
	
	/**
	 * This method will add author to author map and the file.
	 * @param aUserId it will take a user id 
	 */
	public void addAuthor(int aUserId) {
		User temp = getReviewer(aUserId);
		listOfAuthors.put(aUserId, new Author(aUserId,temp.myFristName, temp.myLastName, temp.myEmail, temp.paperAssinged ));
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("authors.csv", false)))) {
			out.println("UserID,FirstName,LastName,email,RoleID");
			for (Entry<Integer, User> entry: listOfAuthors.entrySet()) {
				out.println(entry.getKey() + "," + entry.getValue().myFristName + "," + entry.getValue().myLastName
						+ "," + entry.getValue().myEmail);
			}
		    
		    out.close();
		}catch (IOException e) {
			System.out.println(e);
            System.exit(0);
		}
	}
	
	/**
	 * This method to get available reviewers
	 */
	public ArrayList<Reviewer> getAvaReviewer() {
		ArrayList<Reviewer> result = new ArrayList<Reviewer>(); 
		for (Entry<Integer, User> entry: listOfReviewer.entrySet()) {
			if (entry.getValue().myRoleId == 4 && entry.getValue().paperAssinged < 4) {
				result.add((Reviewer) entry.getValue());
			}
		}
		return result;
	}
	
	/**
	 * This method to get available subProgram chair
	 */
	public ArrayList<SubProgramChair> getAvaSubProgram() {
		ArrayList<SubProgramChair> result = new ArrayList<SubProgramChair>(); 
		for (Entry<Integer, User> entry: listOfReviewer.entrySet()) {
			if (entry.getValue().myRoleId == 2 && entry.getValue().paperAssinged < 4) {
				result.add((SubProgramChair) entry.getValue());
			}
		}
		return result;
	}
	
	/**
	 * This method to return paper 
	 * @param aPaperId paper id 
	 * @return the paper with that Id. 
	 */
	public Paper getPaper(int aPaperId) {
		
		Paper result = listOfPaper.get(aPaperId);
		return result;
	}
}
