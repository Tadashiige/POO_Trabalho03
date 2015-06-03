package br.com.icmc.trabalho03.user;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
	
	public User findUser (String doc){
		return userList
			.stream()
			.filter(user -> user.getDocument() == Integer.parseInt(doc))
			.findAny()
			.orElse(null);
	}
	
	public ArrayList<User> matchUser (String doc){
		
		return new ArrayList<User>(userList
				.stream()				
				.filter(user -> Integer.toString(user.getDocument()).matches("(.*)"+doc+"(.*)"))				
				.collect(Collectors.toList())
			);
		
	}
	
	public void signupUser (UserRelationship type, String name, int document){
		ID++;
		User user = null;
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
				ID--;
				//TODO popup message "Relationship type undefined";
				System.out.println("Relationship type undefined");
				return;
		}		
		userList.add(user);
		UserFile.writeFile(userList);		
	}
	
	public boolean borrowUser (int ID, Book book){
		boolean process = userList.get(ID-1).borrowBook(book);		
		
		UserFile.writeFile(userList);
		
		return process;
	}
	
	public boolean returnUser (int userID){
		boolean process = userList.get(userID-1).returnBook();
		
		UserFile.writeFile(userList);
		
		return process;
	}
	
	public void userSuspensionCalculation (){
		//TODO
	}
	
	public ArrayList<User> getUserList (){
		return userList;
	}
}
