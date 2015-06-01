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
	public static Date systemDate;
	private UserManager userManager;
	private BookManager bookManager;
	
	public LibraryManager (){
		this.userManager = new UserManager();
		this.bookManager = new BookManager();
	}
	
	public void userSingup (int ID, UserRelationship type, String name, int document){
		userManager.signupUser(type, name, document);
	}
	
	public void bookSingup (int ID, BookType type, String name){
		bookManager.signupBook(type, name);
	}
	
	public void userBorrow (int ID, Book book){
		userManager.borrowUser(ID, book);
	}
	
	public void BookBorrow (int ID, User user){
		bookManager.borrowIt(ID, user);
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
	/**
	 * Funções:
	 * 
	 * List: 
	 * 		User.list
	 * 		Book.list
	 * 		Book.Borrowed.list
	 *
	 */

}
