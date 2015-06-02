package br.com.icmc.trabalho03.book;

import java.util.ArrayList;

import br.com.icmc.trabalho03.BorrowParser;
import br.com.icmc.trabalho03.BorrowRegister;


public class BookParser {
	public static int lastID = 0;
	
	public static Book parse(String csv, String cmd){		
		String[] csvSplit = csv.split(",");
		
		int ID = Integer.parseInt(csvSplit[0]);
		BookType type = BookType.valueOf(csvSplit[1]);
		String name = csvSplit[2];				
		
		Book book;
		
		switch(type){
			case General:
				book = new Book(ID, type, name);
				break;
			case TextBook:
				book = new TextBook(ID, type, name);
				break;
			default:
				book = null;
				break;
		}
		
		BorrowParser.lastBookID = 0;
				
		ArrayList<BorrowRegister> userList = new ArrayList<BorrowRegister>(); 
		
		if(cmd != null && csvSplit.length > 3){			
			for(String borrow : csvSplit[3].split(";")){
				userList.add(BorrowParser.parseBook(borrow));
			}
					
		}
		
		book.setUserList(userList);
		
		
		lastID = ID;
		book.borrowID = BorrowParser.lastBookID;
		
		return book;
	}
}
