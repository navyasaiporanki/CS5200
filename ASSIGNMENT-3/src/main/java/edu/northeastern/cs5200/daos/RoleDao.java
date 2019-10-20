package edu.northeastern.cs5200.daos;

public interface RoleDao {

	public void assignWebsiteRole(int developerId, int websiteId, int roleId);

	public void assignPageRole(int developerId, int pageId, int roleId);

	public void deleteWebsiteRole(int developerId, int websiteId, int roleId);

	public void deletePageRole(int developerId, int pageId, int roleId);

}
