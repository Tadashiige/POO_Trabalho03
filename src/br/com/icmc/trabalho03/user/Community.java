package br.com.icmc.trabalho03.user;

public class Community extends User {

	public Community(int ID, UserRelationship type, String name, int document) {
		super(ID, type, name, document);
		setBorrowNumberLimit(2);
		setReturnTime(15);
	}
}
