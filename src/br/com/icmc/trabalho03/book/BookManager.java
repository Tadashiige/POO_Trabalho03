package br.com.icmc.trabalho03.book;

import java.util.ArrayList;

import br.com.icmc.trabalho03.user.User;

public class BookManager {
	/**
	 * SignUp book
	 * borrow
	 * return
	 * list
	 */
	private static int ID = 0;
	private ArrayList<Book> bookList;
	
	public BookManager (){
		//TODO
	}
	
	public void signupBook (BookType type, String name){
		ID++;
		switch(type){
			case General:
				bookList.add(new Book(ID, type, name));
			case TextBook:
				bookList.add(new TextBook(ID, type, name));
			default:
				ID--;
				//TODO popup message "Book type undefined";
		}
	}
	
	public void borrowIt (int ID, User user){
		bookList.get(ID).borrowIt(user);
	}
	
	public void returnIt (int bookID){
		bookList.get(bookID).returnIt();
	}
	
	public ArrayList<Book> getBookList (){
		return bookList;
	}
	
	public ArrayList<Book> getBorrowedList (){
		//TODO
		return null;
	}
}
