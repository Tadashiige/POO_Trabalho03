package br.com.icmc.trabalho03.book;

public class BookParser {
	public static int lastID = 0;
	
	public static Book parse(String csv){		
		String[] csvSplit = csv.split(",");		
		int ID = Integer.parseInt(csvSplit[0]);
		BookType type = BookType.valueOf(csvSplit[1]);
		String name = csvSplit[2];			
		
		boolean borrowed = (csvSplit[3].equals("true"))?true:false;
		
		System.out.println(borrowed + csvSplit[3]);
		
		Book book;
		
		switch(type){
			case General:
				book = new Book(ID, type, name);
				break;
			case TextBook:
				book = new TextBook(ID, type, name);
				break;
			default:
				book = null;
				break;
		}
		
		lastID = ID;		
		if(borrowed)
			book.setBorrow();
		
		return book;
	}
}
