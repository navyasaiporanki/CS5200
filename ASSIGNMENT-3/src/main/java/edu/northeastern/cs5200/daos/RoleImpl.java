package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Role;

public class RoleImpl implements RoleDao {

	private static RoleImpl instance;

	public static RoleDao getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new RoleImpl();
		return instance;

	}

	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub

		String insertWebsiteRole = "insert into website_role(developer_id, website_id, role) values(?, ? , ?)";
		String roleName = Role.getById(roleId);
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertWebsiteRole);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, websiteId);
			preparedStatement.setString(3, roleName);

			preparedStatement.executeUpdate();

			if (roleName.equalsIgnoreCase("owner")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "update");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "update");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");

			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		String insertPageRole = "insert into page_role(developer_id, page_id, role) values(?, ? , ?)";
		String roleName = Role.getById(roleId);
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPageRole);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, pageId);
			preparedStatement.setString(3, roleName);

			preparedStatement.executeUpdate();

			if (roleName.equalsIgnoreCase("owner")) {
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "update");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "update");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("writer")) {
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("editor")) {
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "read");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				PriviledgeImpl.getInstance().assignPagePriviledge(developerId, pageId, "create");
			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		// TODO Auto-generated method stub
		String deleteWebsiteRole = "delete from website_role where developer_id = ? and website_id = ? and role = ?";
		String roleName = Role.getById(roleId);
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deleteWebsiteRole);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, websiteId);
			preparedStatement.setString(3, roleName);

			preparedStatement.executeUpdate();

			if (roleName.equalsIgnoreCase("owner")) {
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "update");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "update");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "create");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "read");
				PriviledgeImpl.getInstance().deleteWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				PriviledgeImpl.getInstance().assignWebsitePriviledge(developerId, websiteId, "read");

			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

	@Override
	public void deletePageRole(int developerId, int pageId, int roleId) {
		// TODO Auto-generated method stub
		String deletePageRole = "delete from page_role where developer_id = ? and page_id = ? and role = ?";
		String roleName = Role.getById(roleId);
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deletePageRole);
			preparedStatement.setInt(1, developerId);
			preparedStatement.setInt(2, pageId);
			preparedStatement.setString(3, roleName);

			preparedStatement.executeUpdate();

			if (roleName.equalsIgnoreCase("owner")) {
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "update");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "update");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "create");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "read");
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				PriviledgeImpl.getInstance().deletePagePriviledge(developerId, pageId, "read");

			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

}
