package br.com.icmc.trabalho03;

import java.util.Date;

import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.user.User;

public class BorrowRegister {
	private static int IDBookset = 0;
	private static int IDUserset = 0;
	private int ID;
	private Book book;
	private User user;
	private Date borrowIt;
	private Date returnIt = null;	
	
	//construtor chamado pelo User
	
	public BorrowRegister (Book book){
		this.ID = IDBookset;
		IDBookset++;
		this.book = book;
		this.borrowIt = LibraryManager.systemDate;		
	}
	
	//Construtor chamado pelo Book
	
	public BorrowRegister (User user){
		this.ID = IDUserset;
		IDUserset++;
		this.user = user;
		this.borrowIt = LibraryManager.systemDate;
	}
	
	public void setReturnIt (Date returnIt){
		this.returnIt = returnIt;
	}
	
	public int getID (){
		return ID;
	}
	
	public Book getBook (){
		return book;
	}
	
	public User getUser (){
		return user;
	}
	
	public Date getBorrowIt (){
		return borrowIt;
	}
	
	public Date getReturnIt () {
		return returnIt;
	}
}
