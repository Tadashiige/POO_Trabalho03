package br.com.icmc.trabalho03.user;

import java.util.ArrayList;

import br.com.icmc.trabalho03.book.Book;

public class UserManager {
	/**
	 * SignUp user
	 * borrow
	 * return
	 * list
	 */
	private static int ID = 0;
	private ArrayList<User> userList;
	
	public UserManager (){				
		userList = UserFile.loadFile();
		ID = UserParser.lastID;
	}
	
	public void signupUser (UserRelationship type, String name, int document){
		ID++;
		switch(type){
			case Teacher:
				userList.add(new Teacher(ID, type, name, document));
				break;
			case University:
				userList.add(new University(ID, type, name, document));
				break;
			case Community:
				userList.add(new Community(ID, type, name, document));
				break;
			default:
				ID--;
				//TODO popup message "Relationship type undefined";
				break;
		}
		UserFile.writeFile(userList);		
	}
	
	public void borrowUser (int ID, Book book){
		userList.get(ID).borrowBook(book);
	}
	
	public void returnUser (int userID, int bookID){
		userList.get(userID).returnBook(bookID);
	}
	
	public void userSuspensionCalculation (){
		//TODO
	}
	
	public ArrayList<User> getUserList (){
		return userList;
	}
}
