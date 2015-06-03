package BorrowRegister;

import java.util.Date;

public class BorrowParser {
	public static int lastID = 0;	
	
	public static BorrowRegister parse(String csv){		
		String[] csvSplit = csv.split(",");
		
		int ID = Integer.parseInt(csvSplit[0]);		
		int bookID = Integer.parseInt(csvSplit[1]);
		int userID = Integer.parseInt(csvSplit[2]);				
		
		BorrowRegister borrow = new BorrowRegister(ID, bookID, userID);
		
		Date borrowIt = new Date(Long.parseLong(csvSplit[3]));
		Date returnIt = null;
		if(csvSplit[4].equals("null") == false)
			returnIt = new Date(Long.parseLong(csvSplit[4]));
		
		borrow.setBorrowIt(borrowIt);
		borrow.setReturnIt(returnIt);
		
		lastID = ID;
		return borrow;
	}
	
}
