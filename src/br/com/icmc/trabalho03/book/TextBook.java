package br.com.icmc.trabalho03.book;

import br.com.icmc.trabalho03.user.Community;
import br.com.icmc.trabalho03.user.User;

public class TextBook extends Book {

	public TextBook(int ID, BookType type, String name) {
		super(ID, type, name); 
	}

	public boolean canBeBorrowed (User user){
		if(user.getClass() != Community.class)
			return true;
		
		return false;
	}

}
