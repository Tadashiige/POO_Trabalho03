package br.com.icmc.trabalho03;

import java.util.ArrayList;
import java.util.Date;

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
	private ListView<Book> borrowList = null;
	
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
	public void setBorrowList(ListView<Book> list){
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
	public ListView<Book> getBorrowList(){
		return this.borrowList;
	}	
	
	/**
	 * ----------------- END SETS -----------------------------------------------
	 */
	
	public void updateTime (String date){
		
		String newDate = manager.timeSetup(date);
		this.actualTime.setText(newDate);
	}
	
	public void signUpUser (String name, UserRelationship type, int document){		
		manager.userSignup(type, name, document);
	}
	
	public void signUpBook (String name, String typeBook){
		BookType type;
		if(typeBook == "TextBook")
			type = BookType.TextBook;
		else 
			type = BookType.General;
		
		manager.bookSignup(type, name);
	}

	public void showUserBorrowList (){		

	}
	
	public void showUserList (){		
		ArrayList<User> list = manager.userList();		
		
		ObservableList<User> userList = FXCollections.observableArrayList(list);
		
		this.userList.setItems(userList);
	}
	/**
	 * Manipular listas para apresentação nos paineis, campos e etc
	 * Fazer requisição para gerenciador para obter dados
	 */
	
	
}
