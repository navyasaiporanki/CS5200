package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phones;

public class DeveloperImpl implements DeveloperDao {

	private static DeveloperImpl instance;

	public static DeveloperImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new DeveloperImpl();
		return instance;

	}

	private final String insertPerson = "insert into person(id, username, password, first_name, last_name, email, dob) "
			+ "values (?, ?,?,?,?,?,?);";

	private final String insertDeveloper = "insert into developer(id, developer_key) values (?, ?)";

	@Override
	public void createDeveloper(Developer developer) {
		// TODO Auto-generated method stub
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPerson);

			//System.out.println("user id " + developer.getId());
			preparedStatement.setInt(1, developer.getId());
			preparedStatement.setString(2, developer.getUsername());
			preparedStatement.setString(3, developer.getPassword());
			preparedStatement.setString(4, developer.getFirstName());
			preparedStatement.setString(5, developer.getLastName());
			preparedStatement.setString(6, developer.getEmail());
			preparedStatement.setDate(7, developer.getDob());

			// System.out.println("user id " + p);

			preparedStatement.executeUpdate();

			//System.out.println("person updated");
			preparedStatement = conn.prepareStatement(insertDeveloper);
			preparedStatement.setInt(1, developer.getId());
			preparedStatement.setString(2, developer.getDeveloperKey());
			preparedStatement.executeUpdate();
			//System.out.println("developer updated");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception " + e.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public Collection<Developer> findAllDevelopers() {
		// TODO Auto-generated method stub
		String fetchEmployees = "select developer.id, username, password, first_name, last_name, email, dob, developer.developer_key \r\n"
				+ "from person join developer on person.id =  developer.id;";

		java.sql.Connection conn;
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<Developer> developerList = new ArrayList<Developer>();

		try {
			conn = Connection.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(fetchEmployees);

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dob = resultSet.getDate("dob");
				String developerKey = resultSet.getString("developer_key");

				String fetchPhones = "select phones, phone.primary from phone where id  = ?;";

				PreparedStatement preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchPhones);
				preparedStatement.setInt(1, id);

				ResultSet phoneResults = preparedStatement.executeQuery();

				Collection<Phones> phoneList = new ArrayList<Phones>();
				while (phoneResults.next()) {

					String phones = phoneResults.getString("phones");
					boolean primary = phoneResults.getBoolean("primary");

					Phones phoneObj = new Phones(id, phones, primary);
					phoneList.add(phoneObj);
				}

				String fetchAddress = "select id, street1, street2, city, state, zip, address.primary from address where id = ?;";

				// PreparedStatement preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchAddress);
				preparedStatement.setInt(1, id);

				ResultSet addressResults = preparedStatement.executeQuery();

				Collection<Address> addressList = new ArrayList<Address>();
				while (addressResults.next()) {

					String street1 = addressResults.getString("street1");
					String street2 = addressResults.getString("street2");
					String city = addressResults.getString("city");
					String state = addressResults.getString("state");
					String zip = addressResults.getString("zip");
					boolean primary = addressResults.getBoolean("primary");

					Address addressObj = new Address(id, street1, street2, city, state, zip, primary);
					addressList.add(addressObj);
				}

				Developer developerRetrieved = new Developer(developerKey, id, firstName, lastName, username, password,
						email, dob, phoneList, addressList);

				developerList.add(developerRetrieved);

			}

			resultSet.close();

		} catch (Exception ex) {
			System.out.println("exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		return developerList;
	}

	@Override
	public Developer findDeveloperById(int developerId) {
		// TODO Auto-generated method stub

		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Developer developerRetrieved = null;

		try {

			String findDeveloperById = "select developer.id, username, password, first_name, last_name, email, dob, developer.developer_key \r\n"
					+ "from person join developer on person.id =  developer.id where developer.id = ?;";
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(findDeveloperById);

			preparedStatement.setInt(1, developerId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dob = resultSet.getDate("dob");
				String developerKey = resultSet.getString("developer_key");

				String fetchPhones = "select phones, phone.primary from phone where id  = ?;";

				// preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchPhones);
				preparedStatement.setInt(1, developerId);

				ResultSet phoneResults = preparedStatement.executeQuery();

				Collection<Phones> phoneList = new ArrayList<Phones>();
				while (phoneResults.next()) {

					String phones = phoneResults.getString("phones");
					boolean primary = phoneResults.getBoolean("primary");

					Phones phoneObj = new Phones(id, phones, primary);
					phoneList.add(phoneObj);
				}

				String fetchAddress = "select id, street1, street2, city, state, zip, address.primary from address where id = ?;";

				// PreparedStatement preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchAddress);
				preparedStatement.setInt(1, developerId);

				ResultSet addressResults = preparedStatement.executeQuery();

				Collection<Address> addressList = new ArrayList<Address>();
				while (addressResults.next()) {

					String street1 = addressResults.getString("street1");
					String street2 = addressResults.getString("street2");
					String city = addressResults.getString("city");
					String state = addressResults.getString("state");
					String zip = addressResults.getString("zip");
					boolean primary = addressResults.getBoolean("primary");

					Address addressObj = new Address(id, street1, street2, city, state, zip, primary);
					addressList.add(addressObj);
				}

				developerRetrieved = new Developer(developerKey, id, firstName, lastName, username, password, email,
						dob, phoneList, addressList);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return developerRetrieved;
	}

	@Override
	public Developer findDeveloperByUsername(String username) {
		// TODO Auto-generated method stub

		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Developer developerRetrieved = null;

		try {

			String findDeveloperById = "select developer.id, username, password, first_name, last_name, email, dob, developer.developer_key \r\n"
					+ "from person join developer on person.id =  developer.id where username = ?;";
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(findDeveloperById);

			preparedStatement.setString(1, username);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String usernameReceived = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dob = resultSet.getDate("dob");
				String developerKey = resultSet.getString("developer_key");

				String fetchPhones = "select phones, phone.primary from phone where id  = ?;";

				// preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchPhones);
				preparedStatement.setInt(1, id);

				ResultSet phoneResults = preparedStatement.executeQuery();

				Collection<Phones> phoneList = new ArrayList<Phones>();
				while (phoneResults.next()) {

					String phones = phoneResults.getString("phones");
					boolean primary = phoneResults.getBoolean("primary");

					Phones phoneObj = new Phones(id, phones, primary);
					phoneList.add(phoneObj);
				}

				String fetchAddress = "select id, street1, street2, city, state, zip, address.primary from address where id = ?;";

				// PreparedStatement preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchAddress);
				preparedStatement.setInt(1, id);

				ResultSet addressResults = preparedStatement.executeQuery();

				Collection<Address> addressList = new ArrayList<Address>();
				while (addressResults.next()) {

					String street1 = addressResults.getString("street1");
					String street2 = addressResults.getString("street2");
					String city = addressResults.getString("city");
					String state = addressResults.getString("state");
					String zip = addressResults.getString("zip");
					boolean primary = addressResults.getBoolean("primary");

					Address addressObj = new Address(id, street1, street2, city, state, zip, primary);
					addressList.add(addressObj);
				}

				developerRetrieved = new Developer(developerKey, id, firstName, lastName, usernameReceived, password,
						email, dob, phoneList, addressList);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return developerRetrieved;

	}

	@Override
	public Developer findDeveloperByCredentials(String username, String password) {
		// TODO Auto-generated method stub

		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Developer developerRetrieved = null;

		try {

			String findDeveloperById = "select developer.id, username, password, first_name, last_name, email, dob, developer.developer_key \r\n"
					+ "from person join developer on person.id =  developer.id where username = ? and password = ?;";
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(findDeveloperById);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String usernameReceived = resultSet.getString("username");
				String passwordReceived = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dob = resultSet.getDate("dob");
				String developerKey = resultSet.getString("developer_key");

				String fetchPhones = "select phones, phone.primary from phone where id  = ?;";

				// preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchPhones);
				preparedStatement.setInt(1, id);

				ResultSet phoneResults = preparedStatement.executeQuery();

				Collection<Phones> phoneList = new ArrayList<Phones>();
				while (phoneResults.next()) {

					String phones = phoneResults.getString("phones");
					boolean primary = phoneResults.getBoolean("primary");

					Phones phoneObj = new Phones(id, phones, primary);
					phoneList.add(phoneObj);
				}

				String fetchAddress = "select id, street1, street2, city, state, zip, address.primary from address where id = ?;";

				// PreparedStatement preparedStatement = null;
				preparedStatement = conn.prepareStatement(fetchAddress);
				preparedStatement.setInt(1, id);

				ResultSet addressResults = preparedStatement.executeQuery();

				Collection<Address> addressList = new ArrayList<Address>();
				while (addressResults.next()) {

					String street1 = addressResults.getString("street1");
					String street2 = addressResults.getString("street2");
					String city = addressResults.getString("city");
					String state = addressResults.getString("state");
					String zip = addressResults.getString("zip");
					boolean primary = addressResults.getBoolean("primary");

					Address addressObj = new Address(id, street1, street2, city, state, zip, primary);
					addressList.add(addressObj);
				}

				developerRetrieved = new Developer(developerKey, id, firstName, lastName, usernameReceived,
						passwordReceived, email, dob, phoneList, addressList);
			}

			resultSet.close();
			preparedStatement.close();

		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return developerRetrieved;
	}

	@Override
	public int updateDeveloper(int developerId, Developer developer) {
		// TODO Auto-generated method stub

		String updateDeveloper = "update person set username = ?, password = ?, first_name = ?, last_name = ?, email = ?,\r\n"
				+ "dob = ? where id = ?; ";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(updateDeveloper);

			//System.out.println("user id " + developer.getId());
			preparedStatement.setString(1, developer.getUsername());
			preparedStatement.setString(2, developer.getPassword());
			preparedStatement.setString(3, developer.getFirstName());
			preparedStatement.setString(4, developer.getLastName());
			preparedStatement.setString(5, developer.getEmail());
			preparedStatement.setDate(6, developer.getDob());
			// preparedStatement.setInt(7, developer.getId());
			preparedStatement.setInt(7, developerId);

			// System.out.println("user id " + p);

			returnValue = preparedStatement.executeUpdate();

			String updateKey = "update developer set developer_key = ? where id = ? ;";
			preparedStatement = conn.prepareStatement(updateKey);
			preparedStatement.setString(1, developer.getDeveloperKey());
			preparedStatement.setInt(2, developerId);
			returnValue = preparedStatement.executeUpdate();

			// resultSet.close();
			preparedStatement.close();
		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return returnValue;
	}

	@Override
	public int deleteDeveloper(int developerId) {
		// TODO Auto-generated method stub
		String deleteDeveloper = "delete from person where id = ? ";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		int returnValue = 0;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deleteDeveloper);

			preparedStatement.setInt(1, developerId);

			returnValue = preparedStatement.executeUpdate();

			preparedStatement.close();
		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return returnValue;
	}

}
