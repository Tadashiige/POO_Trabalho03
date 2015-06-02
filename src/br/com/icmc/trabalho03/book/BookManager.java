package br.com.icmc.trabalho03.book;

import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.icmc.trabalho03.BorrowRegister;
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
		bookList = BookFile.loadFile();
		ID = BookParser.lastID;
	}
	
	public ArrayList<Book> matchBookId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<Book>();
		
		return new ArrayList<Book> (bookList
				.stream()
				.filter(book -> Integer.toString(book.getID()).matches("(.*)"+ID+"(.*)"))
				.collect(Collectors.toList())
		);
	}

	public ArrayList<Book> matchBookName (String name){

		if(name.length() == 0)
			return new ArrayList<Book>();
		
		return new ArrayList<Book> (bookList
				.stream()
				.filter(book -> book.getName().matches("(.*)"+name+"(.*)"))
				.collect(Collectors.toList())
		);
	}
	
	public void signupBook (BookType type, String name){
		ID++;
		Book book;
		switch(type){
			case General:
				book = new Book(ID, type, name);
				break;
			case TextBook:
				book = new TextBook(ID, type, name);
				break;
			default:
				ID--;
				//TODO popup message "Book type undefined";
				return;
		}
		book.setUserList(new ArrayList<BorrowRegister>());
		bookList.add(book);
		BookFile.writeFile(bookList);
	}
	
	public void borrowIt (int ID, User user){
		bookList.get(ID-1).borrowIt(user);
		BookFile.writeFile(bookList);
	}
	
	public void returnIt (int bookID){
		bookList.get(bookID).returnIt();
		BookFile.writeFile(bookList);
	}
	
	public ArrayList<Book> getBookList (){
		return bookList;
	}
	
	public ArrayList<Book> getBorrowedList (){
		ArrayList<Book> borrowList = new ArrayList<Book>();
		
		return borrowList;
	}
}
