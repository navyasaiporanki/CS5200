package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;

import edu.northeastern.cs5200.Connection;

public class PriviledgeImpl implements PriviledgeDao {

	private static PriviledgeDao instance;

	public static PriviledgeDao getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new PriviledgeImpl();
		return instance;

	}

	@Override
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		// TODO Auto-generated method stub
		String insertWebsitePriviledge = "insert into website_priviledge(developer_id, website_id, priviledge) values(?, ? , ?)";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsitePriviledge);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, websiteId);
			preparedStatement.setString(3, priviledge);

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		// TODO Auto-generated method stub

		String insertPagePriviledge = "insert into page_priviledge(developer_id, page_id, priviledge) values(?, ? , ?)";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPagePriviledge);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, pageId);
			preparedStatement.setString(3, priviledge);

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		// TODO Auto-generated method stub

		String deleteWebsitePriviledge = "delete from website_priviledge where developer_id = ? and website_id = ? and priviledge = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deleteWebsitePriviledge);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, websiteId);
			preparedStatement.setString(3, priviledge);
			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		// TODO Auto-generated method stub

		String deletePagePriviledge = "delete from page_priviledge where developer_id = ? and page_id = ? and priviledge = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deletePagePriviledge);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, pageId);
			preparedStatement.setString(3, priviledge);
			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

}
