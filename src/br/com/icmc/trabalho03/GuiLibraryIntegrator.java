package br.com.icmc.trabalho03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import BorrowRegister.BorrowRegister;
import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.book.BookType;
import br.com.icmc.trabalho03.user.User;
import br.com.icmc.trabalho03.user.UserRelationship;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GuiLibraryIntegrator {
	private LibraryManager manager;		
	
	public GuiLibraryIntegrator(LibraryManager manager){
		this.manager = manager;		
	}
		
	public User findUser (String doc){		
		return manager.findUser(doc);				
	}

	public ObservableList<BorrowRegister> getUserBorrowList (User user){
		ArrayList<BorrowRegister> list = manager.getBorrowUserList(user);
		
		if(list.isEmpty())
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
		manager.borrowBook(user, book);
	}
	
	public ObservableList<User> showUserList (){		
		ArrayList<User> list = manager.userList();		
		
		 return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<Book> showBookList (){
		ArrayList<Book> list = manager.bookList();
		
		return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<Book> showBorrowList (String bookID, String bookName){
		ArrayList<Book> list = manager.borrowedList(bookID, bookName);				
		
		return FXCollections.observableArrayList(list);
	}
	/**
	 * Manipular listas para apresentação nos paineis, campos e etc
	 * Fazer requisição para gerenciador para obter dados
	 */
	
	
}
