package br.com.icmc.trabalho03;

import java.util.ArrayList;
import java.util.Date;

import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.book.BookManager;
import br.com.icmc.trabalho03.book.BookType;
import br.com.icmc.trabalho03.user.User;
import br.com.icmc.trabalho03.user.UserManager;
import br.com.icmc.trabalho03.user.UserRelationship;

public class LibraryManager{
	public static Date systemDate = new Date();
	private UserManager userManager;
	private BookManager bookManager;
	
	public LibraryManager (){
		this.userManager = new UserManager();
		this.bookManager = new BookManager();
	}
	
	public ArrayList<User> getUserList(){ 
		return userManager.getUserList();
	}
	
	public ArrayList<Book> getBookList(){
		return bookManager.getBookList();
	}
	
	public User findUser (String doc){
		return userManager.findUser(doc);
	}
	
	public ArrayList<Book> matchBookID (String ID){
		return bookManager.matchBookId(ID);
	}

	public ArrayList<Book> matchBookName (String name){
		return bookManager.matchBookName(name);
	}
	
	public String timeSetup (String time){
		Date newDate = new Date(time);
		
		systemDate = newDate;
		
		return newDate.getDate()+"/"+
			(newDate.getMonth()+1) +"/"+
			(newDate.getYear()+1900);
	}
	
	public ArrayList<User> matchUser (String doc){
		return userManager.matchUser(doc);
	}
	
	public void userSignup (UserRelationship type, String name, int document){
		userManager.signupUser(type, name, document);
	}
	
	public void bookSignup (BookType type, String name){
		bookManager.signupBook(type, name);
	}
	
	public void userBorrow (User user, Book book){
		userManager.borrowUser(user.getID(), book);
		bookManager.borrowIt(book.getID(), user);
	}
	
	public void userReturn (int userID, int bookID){
		userManager.returnUser(userID, bookID);
	}
	
	public void bookReturn (int ID){
		bookManager.returnIt(ID);
	}
	
	public void userSuspension (){
		userManager.userSuspensionCalculation();
	}
	
	public ArrayList<User> userList (){
		return userManager.getUserList();
	}
	
	public ArrayList<Book> bookList (){
		return bookManager.getBookList();
	}
	
	public ArrayList<Book> borrowedList (){
		return bookManager.getBorrowedList ();
	}

}
