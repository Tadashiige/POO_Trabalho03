package br.com.icmc.trabalho03.user;

import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.icmc.trabalho03.BorrowRegister;
import br.com.icmc.trabalho03.book.Book;

public abstract class User {
	public int borrowID = 0;
	private int ID;
	private UserRelationship type;
	private String name;
	private int document;
	private ArrayList<BorrowRegister> borrowList;
	private int returnTime = 0;
	private int borrowNumberLimit = 0;	
	
	private int borrowedBooks = 0;
	
	public User (int ID, UserRelationship type, String name, int document) {
		this.ID = ID;
		this.type = type;
		this.name = name;
		this.document = document;		
	}

	/**
	 * Funções Set dos atributos ************************************************************
	 * @return
	 */	
	
	public void setBorrowList (ArrayList<BorrowRegister> borrowList){
		this.borrowList = borrowList;
	}
	
	public void setReturnTime (int time){
		this.returnTime = time;
	}
	
	public void setBorrowNumberLimit (int limit){
		this.borrowNumberLimit = limit;
	}

	/**
	 * --------------------------------------- END SETs ------------------------------------
	 * @param book
	 */
	
	/**
	 * Funções Get dos atributos ************************************************************
	 * @return
	 */
	
	public int getID (){
		return ID;
	}
	
	public UserRelationship getType (){
		return type;
	}
	
	public String getName (){
		return name;
	}
	
	public int getDocument (){
		return document;
	}
	
	public ArrayList<BorrowRegister> getBorrowList (){
		return borrowList;
	}
	
	public int getReturnTime (){
		return returnTime;
	}
	
	public int getBorrowNumberLimit (){
		return borrowNumberLimit;
	}
	
	/**
	 * --------------------------------------- END GETs --------------------------------------------------
	 * @param book
	 */
	
	public boolean canBorrow (Book book) {
		if (borrowedBooks < borrowNumberLimit && book.canBeBorrowed(this))
			return true;
		
		return false;
	}
	
	public void borrowBook (Book book){
		
		if(borrowList == null){
			this.borrowList = new ArrayList<BorrowRegister>();
		}
		
		//Caso não tenha excedido o limite de empréstimos registrar emprestimo
		
		if(canBorrow(book)){
		
			System.out.println(this.toString() + book);
			borrowID++;
			BorrowRegister newBorrow = new BorrowRegister(borrowID, book);
			borrowList.add(newBorrow);			
			borrowedBooks++;
		}
		
		//Caso contrário avisar usuário a excedencia
		
		else {
			//TODO PopUp message "Book can't be borrowed" and show why
			
		}
	}
	
	public void returnBook (int ID){
		
		//Registra-se a devolução segundo o ID dado
		borrowList
			.stream()
			.filter(item -> item.getBook().getID() == ID)
			.limit(1)
			.map(item -> item.getBook())
			.forEach(book -> book.returnIt());
	}
	
	public void suspensionCalculate (){
		
		//TODO refazer
		
	}
	
	public String toString(){
		String csvFormat = "";
		
		csvFormat += this.ID + ",";
		csvFormat += this.type + ",";
		csvFormat += this.name + ",";
		csvFormat += this.document;
		
		return csvFormat;
	}
	
	public String toWrite(){
		String csvFormat = toString();
		
		csvFormat += borrowList
				.stream()
				.map(borrow -> borrow.toString())
				.collect(Collectors.joining(";"));
		
		return csvFormat;
	}
}
