package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Website;

public class WebsiteImpl implements WebsiteDao {

	private static WebsiteImpl instance;

	public static WebsiteImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new WebsiteImpl();
		return instance;

	}

	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		// TODO Auto-generated method stub

		String insertWebsite = "insert into website(id, name, description, created, updated, visits, developer_id) values \r\n"
				+ "(?,?,?,?,?,?,?);";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsite);
			preparedStatement.setInt(1, website.getId());
			preparedStatement.setString(2, website.getName());
			preparedStatement.setString(3, website.getDescription());
			preparedStatement.setDate(4, website.getCreated());
			preparedStatement.setDate(5, website.getUpdated());
			preparedStatement.setInt(6, website.getVisits());
			preparedStatement.setInt(7, developerId);

			preparedStatement.executeUpdate();
			//System.out.println("Executed!");
		} catch (Exception ex) {
			System.out.println("Exception! " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public Collection<Website> findAllWebsites() {
		// TODO Auto-generated method stub

		String insertWebsite = "select id, name, description, created, updated, visits, developer_id from website;";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		Collection<Website> websiteList = new ArrayList<Website>();
		ResultSet resultSet;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsite);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int visits = resultSet.getInt("visits");
				int developerId = resultSet.getInt("developer_id");
				// Developer d = DeveloperDao.getInstance().findDeveloperById(developerId);

				Website w = new Website(id, name, description, created, updated, visits, developerId);
				// w.setDeveloper(d);
				websiteList.add(w);
			}

			resultSet.close();
			preparedStatement.close();

			for (Website w : websiteList) {
				int developerId = w.getDeveloperId();
				Developer d = DeveloperImpl.getInstance().findDeveloperById(developerId);
				w.setDeveloper(d);
			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return websiteList;
	}

	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		// TODO Auto-generated method stub
		String insertWebsite = "select id, name, description, created, updated, visits, developer_id from website where developer_id = ?;";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		Collection<Website> websiteList = new ArrayList<Website>();
		ResultSet resultSet;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsite);
			preparedStatement.setInt(1, developerId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int visits = resultSet.getInt("visits");
				// int developerIdRet = resultSet.getInt("developer_id");
				// Developer d = DeveloperDao.getInstance().findDeveloperById(developerId);

				Website w = new Website(id, name, description, created, updated, visits, developerId);
				// w.setDeveloper(d);
				websiteList.add(w);
			}

			resultSet.close();
			preparedStatement.close();
			for (Website w : websiteList) {
				Developer d = DeveloperImpl.getInstance().findDeveloperById(developerId);
				w.setDeveloper(d);
			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return websiteList;
	}

	@Override
	public Website findWebsiteById(int websiteId) {
		// TODO Auto-generated method stub
		String insertWebsite = "select id, name, description, created, updated, visits, developer_id from website where id = ?;";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		Website website = null;
		ResultSet resultSet;
		int developerId = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsite);
			preparedStatement.setInt(1, websiteId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int visits = resultSet.getInt("visits");
				developerId = resultSet.getInt("developer_id");
				// Developer d = DeveloperDao.getInstance().findDeveloperById(developerId);

				website = new Website(id, name, description, created, updated, visits, developerId);
				website.setDeveloperId(developerId);

			}

			resultSet.close();
			preparedStatement.close();

			Developer d = DeveloperImpl.getInstance().findDeveloperById(developerId);
			website.setDeveloper(d);
		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return website;
	}

	@Override
	public int updateWebsite(int websiteId, Website website) {
		// TODO Auto-generated method stub
		String updateWebsite = "update website set name = ?, description = ?, created = ?, updated = ?, visits = ?, developer_id = ? where id = ?";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(updateWebsite);

			preparedStatement.setString(1, website.getName());
			preparedStatement.setString(2, website.getDescription());
			preparedStatement.setDate(3, website.getCreated());
			preparedStatement.setDate(4, website.getUpdated());
			preparedStatement.setInt(5, website.getVisits());
			int getDeveloperId = website.getDeveloper().getId();
			preparedStatement.setInt(6, getDeveloperId);
			preparedStatement.setInt(7, websiteId);
			result = preparedStatement.executeUpdate();

			preparedStatement.close();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return result;
	}

	@Override
	public int deleteWebsite(int websiteId) {
		// TODO Auto-generated method stub
		String updateWebsite = "delete from website where id = ?";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(updateWebsite);
			preparedStatement.setInt(1, websiteId);
			result = preparedStatement.executeUpdate();

			preparedStatement.close();

		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return result;

	}

	@Override
	public Website findWebsiteByName(String websiteName) {
		// TODO Auto-generated method stub
		String insertWebsite = "select id, name, description, created, updated, visits, developer_id from website where name = ?;";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		Website website = null;
		ResultSet resultSet;
		int developerId = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsite);
			preparedStatement.setString(1, websiteName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int visits = resultSet.getInt("visits");
				developerId = resultSet.getInt("developer_id");
				// Developer d = DeveloperDao.getInstance().findDeveloperById(developerId);

				website = new Website(id, name, description, created, updated, visits, developerId);
				website.setDeveloperId(developerId);

			}

			resultSet.close();
			preparedStatement.close();

			Developer d = DeveloperImpl.getInstance().findDeveloperById(developerId);
			website.setDeveloper(d);
		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}

		return website;
	}

}