package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.sql.Date;

public class Developer extends Person {
	
	private String developerKey;
	private int id;
	private Collection<Website> websites;
	
	
	
	
	public Collection<Website> getWebsites() {
		return websites;
	}


	public void setWebsites(Collection<Website> websites) {
		this.websites = websites;
	}


	public Developer(String developerKey, int developerId, String firstName, String lastName) {
	
		super(developerId, firstName, lastName);
		
		this.developerKey  = developerKey;
		this.id = developerId;
	}

	
	public Developer(String developerKey, int developerId, String firstName, String lastName,String userName,
			String password, String email, Date dob ) {
		
		super(developerId, firstName, lastName, userName,password, email, dob);
		
		this.developerKey  = developerKey;
		this.id = developerId;

	}
	
	public Developer(String developerKey, int developerId, String firstName, String lastName, 
			String userName,String password, String email, Date dob, Collection<Phones> phones, 
			Collection<Address> address) {
		
		super(developerId, firstName, lastName, userName,password, email, dob,phones,address);
		
		this.developerKey  = developerKey;
		this.id = developerId;

	}


	public String getDeveloperKey() {
		return developerKey;
	}


	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
