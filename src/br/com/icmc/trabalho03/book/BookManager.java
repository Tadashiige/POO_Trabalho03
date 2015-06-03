package br.com.icmc.trabalho03.book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
		bookList.add(book);
		BookFile.writeFile(bookList);
	}
	
	public boolean borrowIt (int ID){
		boolean process = bookList.get(ID-1).setBorrow();
		
		BookFile.writeFile(bookList);
		
		return process;
	}
	
	public boolean returnIt (int bookID){
		boolean process = bookList.get(bookID-1).setReturn();
				
		BookFile.writeFile(bookList);
		
		return process;
	}
	
	public ArrayList<Book> getBookList (){
		return bookList;
	}
	
	public ArrayList<Book> getBorrowList(){
		
		return new ArrayList<Book> (bookList
				.stream()
				.filter(book -> book.isBorrowed() == true)
				.collect(Collectors.toList())
			);
		
	}

	public ArrayList<Book> getBorrowList(String bookID, String bookName){
		Set<Book> list = new HashSet<Book>();
		
		list.addAll(matchBookId(bookID));
		list.addAll(matchBookId(bookName));
		
		if(list.isEmpty())
			list.addAll(bookList);
		
		return new ArrayList<Book> (list
				.stream()
				.filter(book -> book.isBorrowed() == true)
				.collect(Collectors.toList())
			);
		
	}
}
