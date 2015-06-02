package br.com.icmc.trabalho03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.book.BookType;
import br.com.icmc.trabalho03.user.User;
import br.com.icmc.trabalho03.user.UserRelationship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class GuiLibraryIntegrator {
	private LibraryManager manager;	
	
	/* ********************************************************************
	 * Campos do gui
	 */
	
	private Label actualTime = null;	
	
	private ListView<BorrowRegister> userBorrowList = null;
	private ListView<BorrowRegister> bookBorrowList = null;
	
	private ListView<BorrowRegister> userReturnList = null;
	
	private ListView<BorrowRegister> userSuspensionList = null;
	
	private ListView<User> userList = null;
	private ListView<Book> bookList = null;
	private ListView<BorrowRegister> borrowList = null;
	
	/*
	 * ----------------- END GUI FIELDS ----------------------------------- 
	 * 
	 */
	
	public GuiLibraryIntegrator(LibraryManager manager){
		this.manager = manager;		
	}
	
	/**
	 * Sets propertys dos atributos *********************************************
	 */
	
	public void setActualTime (Label time){
		this.actualTime = time;
	}	
	
	public void setUserBorrowList(ListView<BorrowRegister> list){
		this.userBorrowList = list;
	}
	
	public void setBookBorrowList(ListView<BorrowRegister> list){
		this.bookBorrowList = list;
	}
	
	public void setUserReturnList(ListView<BorrowRegister> list){
		this.userReturnList = list;
	}
	
	public void setUserSuspensionList(ListView<BorrowRegister> list){
		this.userSuspensionList = list;
	}
	
	public void setUserList(ListView<User> list){
		this.userList = list;
	}
	public void setBookList(ListView<Book> list){
		this.bookList = list;
	}
	public void setBorrowList(ListView<BorrowRegister> list){
		this.borrowList = list;
	}	
	
	/**
	 * ----------------- END SETS -----------------------------------------------
	 */

	/**
	 * Gets propertys dos atributos *********************************************
	 */
	
	public Label getActualTime (){
		return this.actualTime;
	}	
	
	public ListView<BorrowRegister> getUserBorrowList(){
		return this.userBorrowList;
	}
	
	public ListView<BorrowRegister> getUookBorrowList(){
		return this.bookBorrowList;
	}
	
	public ListView<BorrowRegister> getUserReturnList(){
		return this.userReturnList;
	}
	
	public ListView<BorrowRegister> getUserSuspensionList(){
		return this.userSuspensionList;
	}
	
	public ListView<User> getUserList(){
		return this.userList;
	}
	public ListView<Book> getBookList(){
		return this.bookList;
	}
	public ListView<BorrowRegister> getBorrowList(){
		return this.borrowList;
	}	
	
	/**
	 * ----------------- END SETS -----------------------------------------------
	 */
	
	public User findUser (String doc){		
		return manager.findUser(doc);				
	}

	public ObservableList<BorrowRegister> getUserBorrowList (User user){
		ArrayList<BorrowRegister> list;
		System.out.println("user: "+user + user.getBorrowList());
		if(user != null)
			list = user.getBorrowList();
		else
			list = new ArrayList<BorrowRegister>();
		return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<User> matchUser (String doc){				
		ArrayList<User> list = manager.matchUser(doc);		
		
		if(list.isEmpty())
			list.addAll(manager.getUserList());			
		
		return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<Book> findBook (String ID, String name){
		ArrayList<Book> bookID = manager.matchBookID(ID);
		ArrayList<Book> bookName = manager.matchBookName(name);
		Set<Book> list = new HashSet<Book>();
		list.addAll(bookID);
		list.addAll(bookName);							
		
		if(list.isEmpty())
			list.addAll(manager.getBookList());
		
		return FXCollections.observableArrayList(list);
	}
	
	public String updateTime (String date){
		
		return manager.timeSetup(date);
	}
	
	public void signUpUser (String name, UserRelationship type, int document){		
		manager.userSignup(type, name, document);
	}
	
	public void signUpBook (String name, BookType type){				
		manager.bookSignup(type, name);
	}

	

	public void borrowBook (User user, Book book){
		manager.userBorrow(user, book);
	}
	
	public ObservableList<User> showUserList (){		
		ArrayList<User> list = manager.userList();		
		
		 return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<Book> showBookList (){
		ArrayList<Book> list = manager.bookList();
		
		return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<Book> showBorrowList (){
		ArrayList<Book> list = manager.borrowedList();
		
		return FXCollections.observableArrayList(list);
	}
	/**
	 * Manipular listas para apresentação nos paineis, campos e etc
	 * Fazer requisição para gerenciador para obter dados
	 */
	
	
}
