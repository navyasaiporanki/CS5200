package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Phones;
import edu.northeastern.cs5200.models.User;

public class UserImpl implements UserDao {

	private static UserImpl instance;

	public static UserImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new UserImpl();
		return instance;

	}

	@Override
	public void createUser(User user) {
		String insertPerson = "insert into person(id, username, password, first_name, last_name, email, dob) "
				+ "values (?, ?,?,?,?,?,?);";

		String insertUser = "insert into user(id, user_agreement) values (?, ?)";

		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPerson);

			//System.out.println("user id " + user.getId());
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setDate(7, user.getDob());

			// System.out.println("user id " + p);

			preparedStatement.executeUpdate();

			//System.out.println("person updated");
			preparedStatement = conn.prepareStatement(insertUser);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setBoolean(2, user.isUserAgreement());
			preparedStatement.executeUpdate();
			//System.out.println("user inserted");

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
	public Collection<User> findAllUsers() {

		String fetchUsers = "select person.id, username, password, first_name, last_name, email, dob, user_agreement \r\n"
				+ "from person join user on person.id =  user.id;";

		java.sql.Connection conn;
		Statement statement = null;
		ResultSet resultSet = null;
		Collection<User> userList = new ArrayList<User>();

		try {
			conn = Connection.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(fetchUsers);

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				Date dob = resultSet.getDate("dob");
				boolean agreement = resultSet.getBoolean("user_agreement");

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

				User userRetrieved = new User(agreement, id, firstName, lastName, username, password, email, dob,
						phoneList, addressList);

				userList.add(userRetrieved);

			}

			resultSet.close();

		} catch (Exception ex) {
			System.out.println("exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		return userList;
	}

	@Override
	public User findUserrById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
