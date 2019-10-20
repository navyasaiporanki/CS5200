package edu.northeastern.cs5200.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class PageImpl implements PageDao {

	private static PageImpl instance;

	public static PageImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new PageImpl();
		return instance;

	}

	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		// TODO Auto-generated method stub
		String insertPage = "insert into page(id, title, description, created, updated, views, website_id) "
				+ "values(?,?,?,?,?,?,?)";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(insertPage);
			preparedStatement.setInt(1, page.getId());
			preparedStatement.setString(2, page.getTitle());
			preparedStatement.setString(3, page.getDescription());
			preparedStatement.setDate(4, page.getCreated());
			preparedStatement.setDate(5, page.getUpdated());
			preparedStatement.setInt(6, page.getViews());

			// int websiteIdRetrieved =
			// WebsiteDao.getInstance().findWebsiteById(websiteId).getId();
			preparedStatement.setInt(7, websiteId);

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("Exception  " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
	}

	@Override
	public Collection<Page> findAllPages() {
		// TODO Auto-generated method stub

		String getPages = "select id, title, description, created, updated, views, website_id from page";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Collection<Page> pagesList = new ArrayList<Page>();
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getPages);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int views = resultSet.getInt("views");
				int website_id = resultSet.getInt("website_id");

				// Website web = WebsiteDao.getInstance().findWebsiteById(website_id);
				Page p = new Page(id, title, description, created, updated, views, website_id);
				p.setWebsiteId(website_id);
				pagesList.add(p);

			}

			resultSet.close();
			for (Page p : pagesList) {
				int localWebsite_id = p.getWebsiteId();
				Website web = WebsiteImpl.getInstance().findWebsiteById(localWebsite_id);
				p.setWebsite(web);
			}
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		return pagesList;
	}

	@Override
	public Page findPageById(int pageId) {
		// TODO Auto-generated method stub
		String getPages = "select id, title, description, created, updated, views, website_id from page "
				+ "where id = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Page page = null;
		int website_id = 0;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getPages);
			preparedStatement.setInt(1, pageId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int views = resultSet.getInt("views");
				website_id = resultSet.getInt("website_id");

				// Website web = WebsiteDao.getInstance().findWebsiteById(website_id);
				page = new Page(id, title, description, created, updated, views, website_id);
				// page.setWebsite(web);

			}
			preparedStatement.close();
			resultSet.close();
			Website web = WebsiteImpl.getInstance().findWebsiteById(website_id);
			page.setWebsite(web);
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		// return pagesList;
		return page;
	}

	public Page findPageByName(String pageName) {
		// TODO Auto-generated method stub
		String getPages = "select id, title, description, created, updated, views, website_id from page "
				+ "where title = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Page page = null;
		int website_id = 0;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getPages);
			preparedStatement.setString(1, pageName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int views = resultSet.getInt("views");
				website_id = resultSet.getInt("website_id");

				// Website web = WebsiteDao.getInstance().findWebsiteById(website_id);
				page = new Page(id, title, description, created, updated, views, website_id);
				// page.setWebsite(web);

			}
			preparedStatement.close();
			resultSet.close();
			Website web = WebsiteImpl.getInstance().findWebsiteById(website_id);
			page.setWebsite(web);
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		// return pagesList;
		return page;
	}

	@Override
	public Collection<Page> findPagesForWebsite(int websiteId) {
		// TODO Auto-generated method stub
		String getPages = "select id, title, description, created, updated, views, website_id from page "
				+ "where website_id = ?";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Collection<Page> pagesList = new ArrayList<Page>();
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getPages);
			preparedStatement.setInt(1, websiteId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String description = resultSet.getString("description");
				Date created = resultSet.getDate("created");
				Date updated = resultSet.getDate("updated");
				int views = resultSet.getInt("views");
				int website_id = resultSet.getInt("website_id");

				// Website web = WebsiteDao.getInstance().findWebsiteById(website_id);
				Page page = new Page(id, title, description, created, updated, views, website_id);
				// page.setWebsite(web);
				pagesList.add(page);

			}
			resultSet.close();
			preparedStatement.close();
			for (Page p : pagesList) {
				int localWebsite_id = p.getWebsiteId();
				Website web = WebsiteImpl.getInstance().findWebsiteById(localWebsite_id);
				p.setWebsite(web);
			}

		} catch (Exception ex) {

		} finally {
			Connection.closeConnection();
		}
		// return pagesList;
		return pagesList;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		// TODO Auto-generated method stub
		String updatePage = "update page set title = ?, description = ?, created = ?, updated = ?, views = ?, website_id = ? where id = ?";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(updatePage);

			preparedStatement.setString(1, page.getTitle());
			preparedStatement.setString(2, page.getDescription());
			preparedStatement.setDate(3, page.getCreated());
			preparedStatement.setDate(4, page.getUpdated());
			preparedStatement.setInt(5, page.getViews());
			int getWebsiteId = page.getWebsite().getId();
			preparedStatement.setInt(6, getWebsiteId);
			preparedStatement.setInt(7, pageId);
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
	public int deletePage(int pageId) {
		// TODO Auto-generated method stub
		String deletePage = "delete from page where id = ?";
		java.sql.Connection conn = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deletePage);
			preparedStatement.setInt(1, pageId);
			result = preparedStatement.executeUpdate();

			preparedStatement.close();

		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return result;
	}

}