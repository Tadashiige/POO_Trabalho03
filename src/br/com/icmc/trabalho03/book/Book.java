package br.com.icmc.trabalho03.book;

import br.com.icmc.trabalho03.user.User;

public class Book {	
	private int ID;
	private BookType type;
	private String name;	
	private boolean borrowed;
	
	public Book (int ID, BookType type, String name) {
		this.ID = ID;
		this.type = type;
		this.name = name;	
		this.borrowed = false;
	}
	
	public boolean setBorrow (){
		this.borrowed = true;
		return true;
	}
	
	public boolean setReturn (){
		this.borrowed = false;
		return true;
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
	public boolean isBorrowed (){
		return borrowed;
	}
	
	public boolean canBeBorrowed (User user){
		return !borrowed;
	}
	
	public String toString(){
		String csvFormat = "";
		
		csvFormat += this.ID + ",";
		csvFormat += this.type + ",";
		csvFormat += this.name + ",";
		csvFormat += this.borrowed;
		
		return csvFormat;
	}	
}
