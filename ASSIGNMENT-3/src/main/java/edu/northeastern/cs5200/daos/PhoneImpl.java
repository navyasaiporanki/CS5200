package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;

import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Person;
import edu.northeastern.cs5200.models.Phones;

public class PhoneImpl implements PhoneDao {

	private static PhoneImpl instance;

	public static PhoneImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new PhoneImpl();
		return instance;

	}

	@Override
	public void insertPhone(Person person) {

		String insertPhone = "insert into phone(id,phones,phone.primary) values(?, ? , ?)";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPhone);

			Collection<Phones> phoneList = person.getPhones();

			for (Phones p : phoneList) {
				int id = p.getId();
				String phones = p.getPhone();
				boolean primary = p.isPrimary();

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, phones);
				preparedStatement.setBoolean(3, primary);

				preparedStatement.executeUpdate();
			}

		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void insertPhone(int id, String phoneNumber, boolean primary) {
		// TODO Auto-generated method stub

		String insertPhone = "insert into phone(id,phones,phone.primary) values(?, ? , ?)";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPhone);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setBoolean(3, primary);

			preparedStatement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public int updatePhone(int id, String phoneNumber, boolean primary) {
		// TODO Auto-generated method stub

		int result = 0;
		String insertPhone = "update phone set phones = ? where id = ?  and phone.primary = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPhone);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, phoneNumber);
			preparedStatement.setBoolean(3, primary);

			result = preparedStatement.executeUpdate();

		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return result;
	}

}
