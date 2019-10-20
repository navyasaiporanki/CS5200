package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.User;

public interface UserDao {

	public void createUser(User user);

	public Collection<User> findAllUsers();

	public User findUserrById(int userId);

	public User findUserByUsername(String username);

	public User findUserByCredentials(String username, String password);

	public int updateUser(int userId, User user);

	public int deleteUser(int userId);

}
