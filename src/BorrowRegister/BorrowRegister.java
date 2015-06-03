package BorrowRegister;

import java.util.Date;

import br.com.icmc.trabalho03.LibraryManager;

public class BorrowRegister {
	private int ID;
	private int bookID;
	private int userID;
	private Date borrowIt;
	private Date returnIt = null;	
	
	//construtor
	
	public BorrowRegister (int ID, int book, int user){		
		this.ID = ID;		
		this.bookID = book;
		this.userID = user;
		this.borrowIt = new Date(LibraryManager.systemDate.getTime());		
	}
	
	public void setBorrowIt (Date borrowIt){
		this.borrowIt = borrowIt;
	}
	
	public void setReturnIt (){
		this.returnIt = new Date(LibraryManager.systemDate.getTime());
	}
	
	public void setReturnIt (Date returnIt){
		this.returnIt = returnIt;
	}
	
	public int getID (){
		return ID;
	}
	
	public int getBook (){
		return bookID;
	}
	
	public int getUser (){
		return userID;
	}
	
	public Date getBorrowIt (){
		return borrowIt;
	}
	
	public Date getReturnIt () {
		return returnIt;
	}
	
	public String toString(){
		String csv = "";
		
		csv += this.ID + ",";
		csv += this.bookID + ",";
		csv += this.userID + ",";		
		csv += this.borrowIt.getTime() + ",";
		if(this.returnIt != null)
			csv += this.returnIt.getTime();
		else
			csv += this.returnIt;
		
		return csv;
	}
}
