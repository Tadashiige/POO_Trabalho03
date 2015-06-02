package br.com.icmc.trabalho03;

import java.util.Date;

import br.com.icmc.trabalho03.book.Book;
import br.com.icmc.trabalho03.user.User;

public class BorrowRegister {
	private int ID;
	private Book book;
	private User user;
	private Date borrowIt;
	private Date returnIt = null;	
	
	//construtor chamado pelo User
	
	public BorrowRegister (int ID, Book book){		
		this.ID = ID;		
		this.book = book;
		this.borrowIt = new Date(LibraryManager.systemDate.getTime());		
	}
	
	//Construtor chamado pelo Book
	
	public BorrowRegister (int ID, User user){		
		this.ID = ID;		
		this.user = user;
		this.borrowIt = new Date(LibraryManager.systemDate.getTime());
	}
	
	public void setBorrowIt (Date borrowIt){
		this.borrowIt = borrowIt;
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
	
	public String toString(){
		String csv = "";
		
		csv += this.ID + ":";
		csv += this.user + ":";
		csv += this.book + ":";
		csv += this.borrowIt + ":";
		csv += this.returnIt;
		
		return csv;
	}
}
