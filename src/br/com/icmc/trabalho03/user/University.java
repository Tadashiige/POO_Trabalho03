package br.com.icmc.trabalho03.user;

public class University extends User {

	public University(int ID, UserRelationship type, String name, int document) {
		super(ID, type, name, document);
		setBorrowNumberLimit(4);
		setReturnTime(15);
	}

}
