package edu.northeastern.cs5200.models;

public class YoutubeWidget extends Widget{


	private int id;
	private String url;
	private boolean shareable;
	private boolean expandable;
	private Page page;
	private int pageId;
	
	
	public int getPageId() {
		return pageId;
	}


	public void setPageId(int pageId) {
		this.pageId = pageId;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}
	public YoutubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, 
			String url, boolean shareable, boolean expandable, int pageId) {
		super(id, name, width, height, cssClass, cssStyle, text, order, pageId);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
		// TODO Auto-generated constructor stub
	}
	public YoutubeWidget(String name, int width, int height, String cssClass, String cssStyle, 
			String text, int order,
			String url, boolean shareable, boolean expandable, int pageId) {
		super(name, width, height, cssClass, cssStyle, text, order,pageId);
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isShareable() {
		return shareable;
	}
	public void setShareable(boolean shareable) {
		this.shareable = shareable;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	
	
	
	
	
}
