package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Widget;

public interface WidgetDao {

	public void createWidgetForPage(int pageId, Widget widget);

	public Collection<Widget> findAllWidgets();

	public Widget findWidgetById(int widgetId);

	public Widget findWidgetByName(String widgetName);

	public Collection<Widget> findWidgetsForPage(int pageId);

	public int updateWidget(int widgetId, Widget widget);

	public int deleteWidget(int widgetId);

}
