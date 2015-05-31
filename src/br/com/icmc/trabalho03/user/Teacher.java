package br.com.icmc.trabalho03.user;

public class Teacher extends User{

	public Teacher(int ID, UserRelationship type, String name, int document) {
		super(ID, type, name, document);
		setBorrowNumberLimit(6);
		setReturnTime(60);
	}

}
