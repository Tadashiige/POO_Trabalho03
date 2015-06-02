package br.com.icmc.trabalho03.user;

import java.util.ArrayList;

import br.com.icmc.trabalho03.BorrowParser;
import br.com.icmc.trabalho03.BorrowRegister;

public class UserParser {
	public static int lastID = 0;
	
	public static User parse(String csv, String cmd){		
		String[] csvSplit = csv.split(",");
		
		int ID = Integer.parseInt(csvSplit[0]);
		UserRelationship type = UserRelationship.valueOf(csvSplit[1]);
		String name = csvSplit[2];		
		int document = Integer.parseInt(csvSplit[3]);
		
		User user;
		
		switch(type){
			case Teacher:
				user = new Teacher(ID, type, name, document);
				break;
			case University:
				user = new University(ID, type, name, document);
				break;
			case Community:
				user = new Community(ID, type, name, document);
				break;
			default:
				user = null;
				break;
		}
		
		BorrowParser.lastUserID = 0;
		
		
		ArrayList<BorrowRegister> bookList = new ArrayList<BorrowRegister>(); 
		
		if(cmd != null && csvSplit.length > 4){			
			for(String borrow : csvSplit[4].split(";")){								
				bookList.add(BorrowParser.parseUser(borrow));
			}
		}
			
		user.setBorrowList(bookList);
		
		
		lastID = ID;
		user.borrowID = BorrowParser.lastUserID;
		
		return user;
	}
}
