package br.com.icmc.trabalho03;

import java.util.ArrayList;
import java.util.Date;

import BorrowRegister.BorrowManager;
import BorrowRegister.BorrowRegister;
import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.book.BookManager;
import br.com.icmc.trabalho03.book.BookType;
import br.com.icmc.trabalho03.user.User;
import br.com.icmc.trabalho03.user.UserManager;
import br.com.icmc.trabalho03.user.UserRelationship;

public class LibraryManager{
	public static Date systemDate = new Date();
	private BorrowManager borrowManager;
	private UserManager userManager;
	private BookManager bookManager;
	
	public LibraryManager (){
		this.borrowManager = new BorrowManager();
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

	public ArrayList<User> matchUser (String doc){
		return userManager.matchUser(doc);
	}
	
	public String timeSetup (String time){
		Date newDate = new Date(time);
		
		systemDate = newDate;
		
		return newDate.getDate()+"/"+
			(newDate.getMonth()+1) +"/"+
			(newDate.getYear()+1900);
	}
	
	public void userSignup (UserRelationship type, String name, int document){
		userManager.signupUser(type, name, document);
	}
	
	public void bookSignup (BookType type, String name){
		bookManager.signupBook(type, name);
	}
	
	public void borrowBook (User user, Book book){
		boolean process = userManager.borrowUser(user.getID(), book);
		System.out.println(process);
		if(process == true){
			bookManager.borrowIt(book.getID());
			borrowManager.registNewBorrow(user.borrowID, user.getID(), book.getID());
		}
	}
	
	public void returnBook (User user, Book book){
		boolean process  = false;
		process = userManager.returnUser(user.getID());
		process = process && bookManager.returnIt(book.getID());
		if(process == true)
			borrowManager.registReturn(user.getID(), book.getID());
	}
	
	public ArrayList<BorrowRegister> getBorrowUserList (User user){		
		return borrowManager.getBorrowUserId(Integer.toString(user.getID()));
	}
	
	public void userSuspension (int ID){
		userManager.userSuspensionCalculation();
	}
	
	public ArrayList<User> userList (){
		return userManager.getUserList();
	}
	
	public ArrayList<Book> bookList (){
		return bookManager.getBookList();
	}
	
	public ArrayList<Book> borrowedList (){
		return bookManager.getBorrowList ();
	}

	public ArrayList<Book> borrowedList (String bookID, String bookName){
		return bookManager.getBorrowList (bookID, bookName);
	}
}
