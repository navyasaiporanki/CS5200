package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

public class Person {

	
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date dob;
	private Collection<Phones> phones;
	private Collection<Address> address;
	
	
	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.username = firstName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = firstName;
		this.email = firstName + '@' + lastName;
		this.dob = null;
		
		this.phones =  new ArrayList<Phones>();
		Phones phone = new Phones(id, "123-345-456", false);
		this.phones.add(phone);
		
		this.address = new ArrayList<Address>();
		Address address = new Address(id, "Default Street 1", null, "Default city", "Default state",
				"Default Zip", true);
		this.address.add(address);
		
	}
	
	
	public Person(int id, String firstName, String lastName, String userName,
			String password, String email, Date dob) {
		this.id = id;
		this.username = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = firstName + '@' + lastName;
		this.dob = dob;
		this.phones = new ArrayList<Phones>();
		this.address = new ArrayList<Address>();
	}
	
	
	public Person(int id, String firstName, String lastName, String userName,
			String password, String email, Date dob, Collection<Phones> phones, Collection<Address> address) {
		this.id = id;
		this.username = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = firstName + '@' + lastName;
		this.dob = dob;
		this.phones = phones;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Collection<Phones> getPhones() {
		return phones;
	}


	public void setPhones(Collection<Phones> phones) {
		this.phones = phones;
	}


	public Collection<Address> getAddress() {
		return address;
	}


	public void setAddress(Collection<Address> address) {
		this.address = address;
	}


public  String  toString() {
	return this.getId() + " " + this.getUsername() + " " + this.getEmail();
	
}
	
	
	
	
	
	
}
