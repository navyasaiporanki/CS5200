package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Role;

public class RoleImpl implements RoleDao {

	private static RoleImpl instance;

	public static RoleImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new RoleImpl();
		return instance;

	}
	
	PriviledgeImpl priviledgeInstance = PriviledgeImpl.getInstance();

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
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "update");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "update");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");

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
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "create");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "read");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "update");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "create");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "read");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "update");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("writer")) {
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "create");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "read");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("editor")) {
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "create");
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "read");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				priviledgeInstance.assignPagePriviledge(developerId, pageId, "create");
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
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "update");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "update");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "create");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "read");
				priviledgeInstance.deleteWebsitePriviledge(developerId, websiteId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				priviledgeInstance.assignWebsitePriviledge(developerId, websiteId, "read");

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
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "create");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "read");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "update");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("admin")) {
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "create");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "read");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "update");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "delete");
			} else if (roleName.equalsIgnoreCase("editor")) {
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "read");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("writer")) {
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "create");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "read");
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "update");
			} else if (roleName.equalsIgnoreCase("reviewer")) {
				priviledgeInstance.deletePagePriviledge(developerId, pageId, "read");

			}

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

}
