package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Person;

public interface AddressDao {
	
	
	public void insertAddress(Person person);
	
	
	public void insertAddress(int id, String street1, String street2, String city,String state,String zip, boolean primary);
	
	public void deleteAddress(int id, boolean primary);

}
