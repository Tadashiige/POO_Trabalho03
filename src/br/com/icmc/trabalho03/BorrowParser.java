package br.com.icmc.trabalho03;

import java.util.Date;

import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.book.BookParser;
import br.com.icmc.trabalho03.user.User;
import br.com.icmc.trabalho03.user.UserParser;

public class BorrowParser {
	public static int lastUserID = 0;
	public static int lastBookID = 0;
	
	public static BorrowRegister parseBook(String csv){		
		String[] csvSplit = csv.split(":");
		
		int ID = Integer.parseInt(csvSplit[0]);		
		User user = UserParser.parse(csvSplit[2], null);
		Date borrowIt = new Date(csvSplit[3]);				
		Date returnIt = new Date(csvSplit[4]);
		
		BorrowRegister borrow = new BorrowRegister(ID, user);
		borrow.setBorrowIt(borrowIt);
		borrow.setReturnIt(returnIt);
		
		lastBookID = ID;
		return borrow;
	}
	
	public static BorrowRegister parseUser(String csv){
		BorrowRegister borrow = null;
		if(csv != ""){
			String[] csvSplit = csv.split(":");
			
			int ID = Integer.parseInt(csvSplit[0]);		
			Book book = BookParser.parse(csvSplit[1], null);
			Date borrowIt = new Date(csvSplit[3]);				
			Date returnIt = new Date(csvSplit[4]);
			
			borrow = new BorrowRegister(ID, book);
			borrow.setBorrowIt(borrowIt);
			borrow.setReturnIt(returnIt);
			
			lastUserID = ID;
		}
		return borrow;
	}
}
