package br.com.icmc.trabalho03.user;

public class UserParser {
	public static int lastID = 0;
	
	public static User parse(String csv){		
		String[] csvSplit = csv.split(",");
		
		int borrowID = Integer.parseInt(csvSplit[0]);
		int ID = Integer.parseInt(csvSplit[1]);
		UserRelationship type = UserRelationship.valueOf(csvSplit[2]);
		String name = csvSplit[3];		
		System.out.println(csvSplit[4]);
		int document = Integer.parseInt(csvSplit[4]);
		int borrowedBooks = Integer.parseInt(csvSplit[5]);
		
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
		
		lastID = ID;		
		user.setBorrowID(borrowID);
		user.setBorrow(borrowedBooks);
		
		return user;
	}
}
