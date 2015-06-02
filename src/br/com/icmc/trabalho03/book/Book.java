package br.com.icmc.trabalho03.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import br.com.icmc.trabalho03.BorrowRegister;
import br.com.icmc.trabalho03.LibraryManager;
import br.com.icmc.trabalho03.user.User;

public class Book {
	public int borrowID = 0;
	private int ID;
	private BookType type;
	private String name;	
	private ArrayList<BorrowRegister> userList;
	
	public Book (int ID, BookType type, String name) {
		this.ID = ID;
		this.type = type;
		this.name = name;		
	}
	
	public void setUserList (ArrayList<BorrowRegister> userList){
		this.userList = userList;
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
		if(userList.size() == 0 || this.userList.get(userList.size()-1).getReturnIt() != null)
			return true;
		return false;
	}
	
	public void borrowIt (User user) {

		if(userList == null){
			setUserList(new ArrayList<BorrowRegister>());
		}
		
		//Caso o usuário esteja apto a retirar um livro registrar o usuário requisitante
		
		if(user.canBorrow(this)){
						
			borrowID++;
			BorrowRegister newBorrow = new BorrowRegister(borrowID, user);
			userList.add(newBorrow);
			System.out.println("Book "+this+" "+userList);
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
	
	public String toString(){
		String csvFormat = "";
		
		csvFormat += this.ID + ",";
		csvFormat += this.type + ",";
		csvFormat += this.name;	
		
		return csvFormat;
	}
	
	public String toWrite(){
		String csvFormat = toString();
		
		
		csvFormat += userList
				.stream()
				.map(borrow -> borrow.toString())
				.collect(Collectors.joining(";"));
		
		return csvFormat;
	}
}
