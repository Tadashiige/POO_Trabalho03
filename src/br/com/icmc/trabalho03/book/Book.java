package br.com.icmc.trabalho03.book;

import java.util.ArrayList;

import br.com.icmc.trabalho03.BorrowRegister;
import br.com.icmc.trabalho03.LibraryManager;
import br.com.icmc.trabalho03.user.User;

public class Book {
	private int ID;
	private BookType type;
	private String name;	
	private ArrayList<BorrowRegister> userList;
	
	public Book (int ID, BookType type, String name) {
		this.ID = ID;
		this.type = type;
		this.name = name;		
	}
	

	/**
	 * Funções Get dos atributos ************************************************************
	 * @return
	 */
	
	public int getID (){
		return ID;
	}
	
	public BookType getType (){
		return type;
	}
	
	public String getName (){
		return name;
	}
	
	/**
	 * --------------------------------------- END GETs ------------------------------------
	 * @param book
	 */
	
	public boolean canBeBorrowed (User user){
		return true;
	}
	
	public void borrowIt (User user) {

		//Caso o usuário esteja apto a retirar um livro registrar o usuário requisitante
		
		if(user.canBorrow(this)){
			BorrowRegister newBorrow = new BorrowRegister(user);
			userList.add(newBorrow);			
		}
		
		//Caso contrário avisar usuário a impossibilidade
		
		else {
			//TODO PopUp message "Error: Book can't be borrowed by user"
			
		}
	}
	
	public void returnIt (){
		BorrowRegister returnBook = userList.get(userList.size()-1);

		//Caso o o livro ainda não tenha sido devolvida registrar a devolução
		
		if(returnBook.getReturnIt() == null) {
			returnBook.setReturnIt(LibraryManager.systemDate);
		}

		//Caso contrário avisar usuário a impossibilidade
		
		else {
			//TODO PopUp message "Error: It's Can't return book already returned"
		}
	}
}
