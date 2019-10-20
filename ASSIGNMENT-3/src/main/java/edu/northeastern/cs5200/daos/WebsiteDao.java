package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Website;

public interface WebsiteDao {

	public void createWebsiteForDeveloper(int developerId, Website website);

	public Collection<Website> findAllWebsites();

	public Collection<Website> findWebsitesForDeveloper(int developerId);

	public Website findWebsiteById(int websiteId);

	public Website findWebsiteByName(String websiteName);

	public int updateWebsite(int websiteId, Website website);

	public int deleteWebsite(int websiteId);

}
