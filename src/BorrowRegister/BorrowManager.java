package BorrowRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BorrowManager {
	/**
	 * SignUp book
	 * borrow
	 * return
	 * list
	 */
	
	private ArrayList<BorrowRegister> borrowList;
	
	public BorrowManager() {		
		borrowList = BorrowFile.loadFile();		
	}
	
	public void registNewBorrow (int ID, int bookID, int userID){
		System.out.println("Registro ID "+ID+" efetuado: user "+userID+" book "+bookID);
		
		List<BorrowRegister> str = borrowList
			.stream()
			.filter(borrow -> 
					borrow.getUser() == userID &&
					borrow.getBook() == bookID &&
					borrow.getReturnIt() == null
					)
			.collect(Collectors.toList());
			
		if(str.isEmpty() == true)
			borrowList.add(new BorrowRegister(ID, userID, bookID));
		
		BorrowFile.writeFile(borrowList);
	}
	
	public void registReturn (int userID, int bookID){
		borrowList
				.stream()
				.filter(borrowR ->
						borrowR.getUser() == userID &&
						borrowR.getBook() == bookID &&
						borrowR.getReturnIt() == null
						)
				.limit(1)
				.forEach(borrowR -> borrowR.setReturnIt());
		
		BorrowFile.writeFile(borrowList);
	}
	
	public ArrayList<BorrowRegister> getBorrowList (){
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.filter(borrow -> borrow.getReturnIt() == null)
				.collect(Collectors.toList())
			);
	}
	
	public ArrayList<BorrowRegister> findBorrowId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<BorrowRegister>();
		
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.filter(borrow -> Integer.toString(borrow.getID()).equals(ID))
				.limit(1)
				.collect(Collectors.toList())
		);
	}

	public ArrayList<BorrowRegister> findBorrowUserId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<BorrowRegister>();
		
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.filter(borrow -> 
					Integer.toString(borrow.getUser()).equals(ID) &&
					borrow.getReturnIt() == null)
				.collect(Collectors.toList())
		);
	}

	public ArrayList<BorrowRegister> getBorrowUserId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<BorrowRegister>();
		System.out.println("busca list user: "+ID);
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.peek(book -> System.out.println("user regist: "+book.getUser()))
				.filter(borrow -> 
						Integer.toString(borrow.getUser()).equals(ID) &&
						borrow.getReturnIt() == null)				
				.collect(Collectors.toList())
		);
	}

	public ArrayList<BorrowRegister> findBorrowBookId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<BorrowRegister>();
		
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.filter(borrow -> Integer.toString(borrow.getBook()).equals(ID) && borrow.getReturnIt() == null)
				.collect(Collectors.toList())
		);
	}

	public ArrayList<BorrowRegister> getBorrowBookId (String ID){
		
		if(ID.length() == 0)
			return new ArrayList<BorrowRegister>();
		
		return new ArrayList<BorrowRegister> (borrowList
				.stream()
				.filter(borrow -> Integer.toString(borrow.getBook()).equals(ID))
				.collect(Collectors.toList())
		);
	}
}
