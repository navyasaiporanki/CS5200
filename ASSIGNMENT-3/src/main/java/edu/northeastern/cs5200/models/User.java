package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.sql.Date;

public class User extends Person{

	
	private boolean userAgreement;
	private int id;
	
	
	
	public User(int id, String firstName, String lastName) {
		
		super(id, firstName, lastName);
		
		this.id = id;
		this.userAgreement =  false;
		
	}

	public User(boolean userAgreement, int userId, String firstName, String lastName, 
			String userName,String password, String email, Date dob, Collection<Phones> phones, 
			Collection<Address> address) {
		
		super(userId, firstName, lastName, userName,password, email, dob,phones,address);
		
		this.userAgreement  = userAgreement;
		this.id = userId;

	}

	public boolean isUserAgreement() {
		return userAgreement;
	}



	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
