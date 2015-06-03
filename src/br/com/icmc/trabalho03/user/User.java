package br.com.icmc.trabalho03.user;

import br.com.icmc.trabalho03.book.Book;

public abstract class User {
	public int borrowID = 0;
	private int ID;
	private UserRelationship type;
	private String name;
	private int document;	
	private int returnTime = 0;
	private int borrowNumberLimit = 0;	
	
	private int borrowedBooks = 0;
	
	public User (int ID, UserRelationship type, String name, int document) {
		this.borrowID = 0;
		this.ID = ID;
		this.type = type;
		this.name = name;
		this.document = document;		
		this.borrowedBooks = 0;
	}

	/**
	 * Funções Set dos atributos ************************************************************
	 * @return
	 */	
	
	public void setBorrowID (int id){
		this.borrowID = id;
	}
	
	public void setBorrow (int quantity){
		this.borrowedBooks = quantity;
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
	
	public int getBorrowID(){
		return borrowID;
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
	
	public int getBorrowedBooks (){
		return borrowedBooks;
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
	
	public boolean borrowBook (Book book){		
		
		//Caso não tenha excedido o limite de empréstimos registrar emprestimo
		
		if(canBorrow(book)){	
			System.out.println("livro ta ocupado?: "+book);
			borrowID++;				
			borrowedBooks++;
			return true;
		}
		
		//Caso contrário avisar usuário a excedencia
		
		else {
			//TODO PopUp message "Book can't be borrowed" and show why
			
		}
		return false;
	}
	
	public boolean returnBook (){
		
		//Registra-se a devolução
		borrowedBooks--;
		return true;
	}
	
	public void suspensionCalculate (){
		
		//TODO refazer
		
	}
	
	public String toString(){
		String csvFormat = "";
		
		csvFormat += this.borrowID + ",";
		csvFormat += this.ID + ",";
		csvFormat += this.type + ",";
		csvFormat += this.name + ",";
		csvFormat += this.document + ",";
		csvFormat += this.borrowedBooks;
		
		return csvFormat;
	}
	
}
