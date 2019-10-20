package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Person;

public interface PhoneDao {

	public void insertPhone(Person person);

	public void insertPhone(int id, String phoneNumber, boolean primary);

	public int updatePhone(int id, String phoneNumber, boolean primary);

}
