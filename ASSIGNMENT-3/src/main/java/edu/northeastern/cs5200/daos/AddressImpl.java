package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Person;

import edu.northeastern.cs5200.models.Address;

public class AddressImpl implements AddressDao {

	private static AddressImpl instance;

	public static AddressImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new AddressImpl();
		return instance;

	}

	@Override
	public void insertAddress(Person person) {

		String insertAddress = "insert into address(id, street1, street2, city, state, zip, address.primary) values(?,?,?,?,?,?,?);";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertAddress);

			Collection<Address> addressList = person.getAddress();

			for (Address p : addressList) {
				int id = p.getId();
				String street1 = p.getStreet1();
				String street2 = p.getStreet2();
				String city = p.getCity();
				String state = p.getState();
				String zip = p.getZip();
				boolean primary = p.isPrimary();

				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, street1);
				preparedStatement.setString(3, street2);
				preparedStatement.setString(4, city);
				preparedStatement.setString(5, state);
				preparedStatement.setString(6, zip);
				preparedStatement.setBoolean(7, primary);

				preparedStatement.executeUpdate();
			}
			//System.out.println("Done with inserting all the address!");
			preparedStatement.close();
		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void deleteAddress(int id, boolean primary) {
		// TODO Auto-generated method stub

		String deleteAddress = "delete from address where id = ? and address.primary = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deleteAddress);

			preparedStatement.setInt(1, id);
			preparedStatement.setBoolean(2, primary);
			preparedStatement.executeUpdate();
			//System.out.println("Deleted");
			preparedStatement.close();
		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void insertAddress(int id, String street1, String street2, String city, String state, String zip,
			boolean primary) {

		String insertAddress = "insert into address(id, street1, street2, city, state, zip, address.primary) values(?,?,?,?,?,?,?);";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertAddress);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, street1);
			preparedStatement.setString(3, street2);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, state);
			preparedStatement.setString(6, zip);
			preparedStatement.setBoolean(7, primary);

			preparedStatement.executeUpdate();

			preparedStatement.close();
		} catch (Exception e) {

			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

}
