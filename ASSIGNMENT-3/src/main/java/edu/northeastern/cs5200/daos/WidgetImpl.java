package edu.northeastern.cs5200.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YoutubeWidget;

public class WidgetImpl implements WidgetDao {

	private static WidgetImpl instance;

	public static WidgetImpl getInstance() {

		if (instance != null) {
			return instance;
		}

		instance = new WidgetImpl();
		return instance;

	}

	private final String insertYoutubeWithId = "insert into widget (id, widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, url, shareable, expandable, page_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String insertYoutube = "insert into widget (widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, url, shareable, expandable, page_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String insertHtmlWithId = "insert into widget (id, widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, html, page_id) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String insertHtml = "insert into widget (widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, html, page_id) values(?,?,?,?,?,?,?,?,?,?)";

	private final String insertHeadingWithId = "insert into widget (id, widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, size, page_id) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String insertHeading = "insert into widget (widget.name, dtype, widget.text, width, height, css_class, css_style, widget.order, size, page_id) values(?,?,?,?,?,?,?,?,?,?)";

	private final String insertImageWithId = "insert into widget (id, widget.name, dtype, widget.text, width,height, css_class, css_style, widget.order,src, page_id) values(?,?,?,?,?,?,?,?,?,?,?)";
	private final String insertImage = "insert into widget (widget.name, dtype, widget.text, width,height, css_class, css_style, widget.order,src, page_id) values(?,?,?,?,?,?,?,?,?,?)";

	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		// TODO Auto-generated method stub

		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();

			if (widget.getId() > 0) {

				if (widget instanceof YoutubeWidget) {
					preparedStatement = conn.prepareStatement(insertYoutubeWithId);
					preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(2, widget.getName());
					preparedStatement.setString(3, "youtube");
					preparedStatement.setString(4, widget.getText());
					preparedStatement.setInt(5, widget.getWidth());
					preparedStatement.setInt(6, widget.getHeight());
					preparedStatement.setString(7, widget.getCssClass());
					preparedStatement.setString(8, widget.getCssStyle());
					preparedStatement.setInt(9, widget.getOrder());
					preparedStatement.setString(10, ((YoutubeWidget) widget).getUrl());
					preparedStatement.setBoolean(11, ((YoutubeWidget) widget).isShareable());
					preparedStatement.setBoolean(12, ((YoutubeWidget) widget).isExpandable());
					preparedStatement.setInt(13, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				} else if (widget instanceof HtmlWidget) {
					preparedStatement = conn.prepareStatement(insertHtmlWithId);
					preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(2, widget.getName());
					preparedStatement.setString(3, "html");
					preparedStatement.setString(4, widget.getText());
					preparedStatement.setInt(5, widget.getWidth());
					preparedStatement.setInt(6, widget.getHeight());
					preparedStatement.setString(7, widget.getCssClass());
					preparedStatement.setString(8, widget.getCssStyle());
					preparedStatement.setInt(9, widget.getOrder());
					preparedStatement.setString(10, ((HtmlWidget) widget).getHtml());
					preparedStatement.setInt(11, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				} else if (widget instanceof HeadingWidget) {
					preparedStatement = conn.prepareStatement(insertHeadingWithId);
					preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(2, widget.getName());
					preparedStatement.setString(3, "heading");
					preparedStatement.setString(4, widget.getText());
					preparedStatement.setInt(5, widget.getWidth());
					preparedStatement.setInt(6, widget.getHeight());
					preparedStatement.setString(7, widget.getCssClass());
					preparedStatement.setString(8, widget.getCssStyle());
					preparedStatement.setInt(9, widget.getOrder());
					preparedStatement.setInt(10, ((HeadingWidget) widget).getSize());
					preparedStatement.setInt(11, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				} else if (widget instanceof ImageWidget) {
					preparedStatement = conn.prepareStatement(insertImageWithId);
					preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(2, widget.getName());
					preparedStatement.setString(3, "heading");
					preparedStatement.setString(4, widget.getText());
					preparedStatement.setInt(5, widget.getWidth());
					preparedStatement.setInt(6, widget.getHeight());
					preparedStatement.setString(7, widget.getCssClass());
					preparedStatement.setString(8, widget.getCssStyle());
					preparedStatement.setInt(9, widget.getOrder());
					preparedStatement.setString(10, ((ImageWidget) widget).getSrc());
					preparedStatement.setInt(11, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				}

			} else {

				if (widget instanceof YoutubeWidget) {
					preparedStatement = conn.prepareStatement(insertYoutube);
					// preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(1, widget.getName());
					preparedStatement.setString(2, "youtube");
					preparedStatement.setString(3, widget.getText());
					preparedStatement.setInt(4, widget.getWidth());
					preparedStatement.setInt(5, widget.getHeight());
					preparedStatement.setString(6, widget.getCssClass());
					preparedStatement.setString(7, widget.getCssStyle());
					preparedStatement.setInt(8, widget.getOrder());
					preparedStatement.setString(9, ((YoutubeWidget) widget).getUrl());
					preparedStatement.setBoolean(10, ((YoutubeWidget) widget).isShareable());
					preparedStatement.setBoolean(11, ((YoutubeWidget) widget).isExpandable());
					preparedStatement.setInt(12, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				}

				else if (widget instanceof HtmlWidget) {
					preparedStatement = conn.prepareStatement(insertHtml);
					// preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(1, widget.getName());
					preparedStatement.setString(2, "html");
					preparedStatement.setString(3, widget.getText());
					preparedStatement.setInt(4, widget.getWidth());
					preparedStatement.setInt(5, widget.getHeight());
					preparedStatement.setString(6, widget.getCssClass());
					preparedStatement.setString(7, widget.getCssStyle());
					preparedStatement.setInt(8, widget.getOrder());
					preparedStatement.setString(9, ((HtmlWidget) widget).getHtml());
					preparedStatement.setInt(10, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				} else if (widget instanceof HeadingWidget) {
					preparedStatement = conn.prepareStatement(insertHeading);
					// preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(1, widget.getName());
					preparedStatement.setString(2, "heading");
					preparedStatement.setString(3, widget.getText());
					preparedStatement.setInt(4, widget.getWidth());
					preparedStatement.setInt(5, widget.getHeight());
					preparedStatement.setString(6, widget.getCssClass());
					preparedStatement.setString(7, widget.getCssStyle());
					preparedStatement.setInt(8, widget.getOrder());
					preparedStatement.setInt(9, ((HeadingWidget) widget).getSize());
					preparedStatement.setInt(10, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				} else if (widget instanceof ImageWidget) {
					preparedStatement = conn.prepareStatement(insertImage);
					// preparedStatement.setInt(1, widget.getId());
					preparedStatement.setString(1, widget.getName());
					preparedStatement.setString(2, "heading");
					preparedStatement.setString(3, widget.getText());
					preparedStatement.setInt(4, widget.getWidth());
					preparedStatement.setInt(5, widget.getHeight());
					preparedStatement.setString(6, widget.getCssClass());
					preparedStatement.setString(7, widget.getCssStyle());
					preparedStatement.setInt(8, widget.getOrder());
					preparedStatement.setString(9, ((ImageWidget) widget).getSrc());
					preparedStatement.setInt(10, pageId);
					preparedStatement.executeUpdate();
					//System.out.println("executed");
				}
				preparedStatement.close();
			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

	}

	@Override
	public Collection<Widget> findAllWidgets() {
		// TODO Auto-generated method stub
		String getAllWidgets = "select * from widget;";
		java.sql.Connection conn;
		// PreparedStatement preparedStatement = null;
		Statement statement = null;
		ResultSet resultSetWidget;
		Collection<Widget> widgetList = new ArrayList<Widget>();
		try {
			conn = Connection.getConnection();
			// preparedStatement = conn.prepareStatement(getAllWidgets);
			// resultSet = preparedStatement.executeQuery();
			statement = conn.createStatement();
			resultSetWidget = statement.executeQuery(getAllWidgets);

			while (resultSetWidget.next()) {

				int id = resultSetWidget.getInt("id");
				String name = resultSetWidget.getString("name");
				String dtype = resultSetWidget.getString("dtype");
				String text = resultSetWidget.getString("text");
				int width = resultSetWidget.getInt("width");
				int height = resultSetWidget.getInt("height");
				String cssClass = resultSetWidget.getString("css_class");
				String cssStyle = resultSetWidget.getString("css_style");
				int order = resultSetWidget.getInt("order");
				int size = resultSetWidget.getInt("size");
				String html = resultSetWidget.getString("html");
				String src = resultSetWidget.getString("src");
				String url = resultSetWidget.getString("url");
				boolean shareable = resultSetWidget.getBoolean("shareable");
				boolean expandable = resultSetWidget.getBoolean("expandable");
				int pageId = resultSetWidget.getInt("page_id");
				//System.out.println("id " + id);

				// Page p = PageDao.getInstance().findPageById(pageId);
				if (dtype.equalsIgnoreCase("youtube")) {
					YoutubeWidget y = new YoutubeWidget(name, width, height, cssClass, cssStyle, text, order, url,
							shareable, expandable, pageId);
					y.setPageId(pageId);
					widgetList.add(y);
				}
				if (dtype.equalsIgnoreCase("heading")) {

					HeadingWidget h = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, size,
							pageId);
					h.setPageId(pageId);
					widgetList.add(h);

				} else if (dtype.equalsIgnoreCase("html")) {
					HtmlWidget htmlWidget = new HtmlWidget(name, width, height, cssClass, cssStyle, text, order, html,
							pageId);
					htmlWidget.setPageId(pageId);
					widgetList.add(htmlWidget);

				} else if (dtype.equalsIgnoreCase("image")) {
					ImageWidget image = new ImageWidget(name, width, height, cssClass, cssStyle, text, order, src,
							pageId);
					image.setPageId(pageId);
					widgetList.add(image);
				}
			}
			resultSetWidget.close();

			for (Widget widget : widgetList) {
				int getPageId = widget.getPageId();
				Page p = PageImpl.getInstance().findPageById(getPageId);
				widget.setPage(p);
			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return widgetList;
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		// TODO Auto-generated method stub
		String getAllWidgets = "select * from widget where id = ?;";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		// Statement statement = null;
		ResultSet resultSetWidget;
		int pageId = 0;
		Widget widget = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getAllWidgets);
			preparedStatement.setInt(1, widgetId);
			resultSetWidget = preparedStatement.executeQuery();

			while (resultSetWidget.next()) {

				int id = resultSetWidget.getInt("id");
				String name = resultSetWidget.getString("name");
				String dtype = resultSetWidget.getString("dtype");
				String text = resultSetWidget.getString("text");
				int width = resultSetWidget.getInt("width");
				int height = resultSetWidget.getInt("height");
				String cssClass = resultSetWidget.getString("css_class");
				String cssStyle = resultSetWidget.getString("css_style");
				int order = resultSetWidget.getInt("order");
				int size = resultSetWidget.getInt("size");
				String html = resultSetWidget.getString("html");
				String src = resultSetWidget.getString("src");
				String url = resultSetWidget.getString("url");
				boolean shareable = resultSetWidget.getBoolean("shareable");
				boolean expandable = resultSetWidget.getBoolean("expandable");
				pageId = resultSetWidget.getInt("page_id");
				//System.out.println("id " + id);

				// Page p = PageDao.getInstance().findPageById(pageId);
				if (dtype.equalsIgnoreCase("youtube")) {
					widget = new YoutubeWidget(name, width, height, cssClass, cssStyle, text, order, url, shareable,
							expandable, pageId);
					// widgetList.add(y);
					widget.setPageId(pageId);
				}
				if (dtype.equalsIgnoreCase("heading")) {

					widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, size, pageId);

				} else if (dtype.equalsIgnoreCase("html")) {
					widget = new HtmlWidget(name, width, height, cssClass, cssStyle, text, order, html, pageId);
					// htmlWidget.setPage(p);
					// widgetList.add(htmlWidget);

				} else if (dtype.equalsIgnoreCase("image")) {
					widget = new ImageWidget(name, width, height, cssClass, cssStyle, text, order, src, pageId);
					// image.setPage(p);
					// widgetList.add(image);
				}
			}

			resultSetWidget.close();

			Page p = PageImpl.getInstance().findPageById(pageId);
			widget.setPage(p);
			// Connection.closeConnection();

		} catch (Exception ex) {
			System.out.println("exception" + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return widget;

	}

	@Override
	public Collection<Widget> findWidgetsForPage(int pageId) {
		// TODO Auto-generated method stub
		String getAllWidgets = "select * from widget where page_id = ?;";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		ResultSet resultSetWidget;
		Collection<Widget> widgetList = new ArrayList<Widget>();
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getAllWidgets);
			preparedStatement.setInt(1, pageId);
			resultSetWidget = preparedStatement.executeQuery();

			while (resultSetWidget.next()) {

				int id = resultSetWidget.getInt("id");
				String name = resultSetWidget.getString("name");
				String dtype = resultSetWidget.getString("dtype");
				String text = resultSetWidget.getString("text");
				int width = resultSetWidget.getInt("width");
				int height = resultSetWidget.getInt("height");
				String cssClass = resultSetWidget.getString("css_class");
				String cssStyle = resultSetWidget.getString("css_style");
				int order = resultSetWidget.getInt("order");
				int size = resultSetWidget.getInt("size");
				String html = resultSetWidget.getString("html");
				String src = resultSetWidget.getString("src");
				String url = resultSetWidget.getString("url");
				boolean shareable = resultSetWidget.getBoolean("shareable");
				boolean expandable = resultSetWidget.getBoolean("expandable");
				// int pageId= resultSetWidget.getInt("page_id");
				//System.out.println("id " + id);

				// Page p = PageDao.getInstance().findPageById(pageId);
				if (dtype.equalsIgnoreCase("youtube")) {
					YoutubeWidget y = new YoutubeWidget(id, name, width, height, cssClass, cssStyle, text, order, url,
							shareable, expandable, pageId);
					y.setPageId(pageId);
					widgetList.add(y);
				}
				if (dtype.equalsIgnoreCase("heading")) {

					HeadingWidget h = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, size,
							pageId);
					h.setPageId(pageId);
					widgetList.add(h);

				} else if (dtype.equalsIgnoreCase("html")) {
					HtmlWidget htmlWidget = new HtmlWidget(id, name, width, height, cssClass, cssStyle, text, order,
							html, pageId);
					htmlWidget.setPageId(pageId);
					widgetList.add(htmlWidget);

				} else if (dtype.equalsIgnoreCase("image")) {
					ImageWidget image = new ImageWidget(id, name, width, height, cssClass, cssStyle, text, order, src,
							pageId);
					image.setPageId(pageId);
					widgetList.add(image);
				}
			}
			resultSetWidget.close();

			for (Widget widget : widgetList) {
				int getPageId = widget.getPageId();
				Page p = PageImpl.getInstance().findPageById(getPageId);
				widget.setPage(p);
			}
		} catch (Exception ex) {
			System.out.println("exception" + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return widgetList;
	}

	@Override
	public int updateWidget(int widgetId, Widget widget) {
		// TODO Auto-generated method stub

		int returnResult = 0;
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		try {
			conn = Connection.getConnection();

			if (widget instanceof YoutubeWidget) {
				String updatewidget = "update widget set widget.name = ?, widget.text = ?, width = ?, "
						+ "height = ?, css_class = ?, css_style = ?, widget.order = ?, url = ? , "
						+ "shareable =?, expandable = ?, page_id = ? where id = ?";
				preparedStatement = conn.prepareStatement(updatewidget);
				preparedStatement.setString(1, widget.getName());
				preparedStatement.setString(2, widget.getText());
				preparedStatement.setInt(3, widget.getWidth());
				preparedStatement.setInt(4, widget.getHeight());
				preparedStatement.setString(5, widget.getCssClass());
				preparedStatement.setString(6, widget.getCssStyle());
				preparedStatement.setInt(7, widget.getOrder());
				preparedStatement.setString(8, ((YoutubeWidget) widget).getUrl());
				preparedStatement.setBoolean(9, ((YoutubeWidget) widget).isShareable());
				preparedStatement.setBoolean(10, ((YoutubeWidget) widget).isExpandable());
				preparedStatement.setInt(11, widget.getPageId());
				preparedStatement.setInt(12, widgetId);

				returnResult = preparedStatement.executeUpdate();
			} else if (widget instanceof HeadingWidget) {
				String updateWidget = "update widget set widget.name = ?, widget.text = ?, width = ?, height = ?, "
						+ "css_class = ?, css_style = ?, widget.order = ?, size = ?, page_id = ? where id = ?";
				preparedStatement = conn.prepareStatement(updateWidget);
				preparedStatement.setString(1, widget.getName());
				preparedStatement.setString(2, widget.getText());
				preparedStatement.setInt(3, widget.getWidth());
				preparedStatement.setInt(4, widget.getHeight());
				preparedStatement.setString(5, widget.getCssClass());
				preparedStatement.setString(6, widget.getCssStyle());
				preparedStatement.setInt(7, widget.getOrder());
				preparedStatement.setInt(8, ((HeadingWidget) widget).getSize());
				preparedStatement.setInt(9, widget.getPageId());
				preparedStatement.setInt(10, widgetId);

				returnResult = preparedStatement.executeUpdate();
			} else if (widget instanceof HtmlWidget) {
				String updateWidget = "update widget set widget.name = ?, widget.text = ?, width = ?, height = ?, "
						+ "css_class = ?, css_style = ?, widget.order = ?, html = ?, page_id = ? where id = ?";
				preparedStatement = conn.prepareStatement(updateWidget);
				preparedStatement.setString(1, widget.getName());
				preparedStatement.setString(2, widget.getText());
				preparedStatement.setInt(3, widget.getWidth());
				preparedStatement.setInt(4, widget.getHeight());
				preparedStatement.setString(5, widget.getCssClass());
				preparedStatement.setString(6, widget.getCssStyle());
				preparedStatement.setInt(7, widget.getOrder());
				preparedStatement.setString(8, ((HtmlWidget) widget).getHtml());
				preparedStatement.setInt(9, widget.getPageId());
				preparedStatement.setInt(10, widgetId);
				returnResult = preparedStatement.executeUpdate();

			} else if (widget instanceof ImageWidget) {
				String updateWidget = "update widget set widget.name = ?, widget.text = ?, width = ?, height = ?, "
						+ "css_class = ?, css_style = ?, widget.order = ?, src = ?, page_id = ? where id = ?";
				preparedStatement = conn.prepareStatement(updateWidget);
				preparedStatement.setString(1, widget.getName());
				preparedStatement.setString(2, widget.getText());
				preparedStatement.setInt(3, widget.getWidth());
				preparedStatement.setInt(4, widget.getHeight());
				preparedStatement.setString(5, widget.getCssClass());
				preparedStatement.setString(6, widget.getCssStyle());
				preparedStatement.setInt(7, widget.getOrder());
				preparedStatement.setString(8, ((ImageWidget) widget).getSrc());
				preparedStatement.setInt(9, widget.getPageId());
				preparedStatement.setInt(10, widgetId);
				returnResult = preparedStatement.executeUpdate();
			}
		} catch (Exception ex) {
			System.out.println("Exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		return returnResult;
	}

	@Override
	public int deleteWidget(int widgetId) {
		// TODO Auto-generated method stub

		int result = 0;
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		String deleteQuery = "delete from widget where id = ?";
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, widgetId);
			result = preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println("exception " + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}
		return result;
	}

	@Override
	public Widget findWidgetByName(String widgetName) {
		// TODO Auto-generated method stub
		String getAllWidgets = "select * from widget where name = ?;";
		java.sql.Connection conn;
		PreparedStatement preparedStatement = null;
		// Statement statement = null;
		ResultSet resultSetWidget;
		int pageId = 0;
		Widget widget = null;
		try {
			conn = Connection.getConnection();
			preparedStatement = conn.prepareStatement(getAllWidgets);
			preparedStatement.setString(1, widgetName);
			resultSetWidget = preparedStatement.executeQuery();

			while (resultSetWidget.next()) {

				int id = resultSetWidget.getInt("id");
				String name = resultSetWidget.getString("name");
				String dtype = resultSetWidget.getString("dtype");
				String text = resultSetWidget.getString("text");
				int width = resultSetWidget.getInt("width");
				int height = resultSetWidget.getInt("height");
				String cssClass = resultSetWidget.getString("css_class");
				String cssStyle = resultSetWidget.getString("css_style");
				int order = resultSetWidget.getInt("order");
				int size = resultSetWidget.getInt("size");
				String html = resultSetWidget.getString("html");
				String src = resultSetWidget.getString("src");
				String url = resultSetWidget.getString("url");
				boolean shareable = resultSetWidget.getBoolean("shareable");
				boolean expandable = resultSetWidget.getBoolean("expandable");
				pageId = resultSetWidget.getInt("page_id");
				//System.out.println("id " + id);

				// Page p = PageDao.getInstance().findPageById(pageId);
				if (dtype.equalsIgnoreCase("youtube")) {
					widget = new YoutubeWidget(name, width, height, cssClass, cssStyle, text, order, url, shareable,
							expandable, pageId);
					// widgetList.add(y);
					widget.setPageId(pageId);
				}
				if (dtype.equalsIgnoreCase("heading")) {

					widget = new HeadingWidget(id, name, width, height, cssClass, cssStyle, text, order, size, pageId);

				} else if (dtype.equalsIgnoreCase("html")) {
					widget = new HtmlWidget(name, width, height, cssClass, cssStyle, text, order, html, pageId);
					// htmlWidget.setPage(p);
					// widgetList.add(htmlWidget);

				} else if (dtype.equalsIgnoreCase("image")) {
					widget = new ImageWidget(name, width, height, cssClass, cssStyle, text, order, src, pageId);
					// image.setPage(p);
					// widgetList.add(image);
				}
			}

			resultSetWidget.close();

			Page p = PageImpl.getInstance().findPageById(pageId);
			widget.setPage(p);
			// Connection.closeConnection();

		} catch (Exception ex) {
			System.out.println("exception" + ex.getMessage());
		} finally {
			Connection.closeConnection();
		}

		return widget;
	}

}
