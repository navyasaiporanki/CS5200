package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget{
	
	private int id;
	private String html;
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

	public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
			int order, String html,int pageId) {
		super(id, name, width, height, cssClass, cssStyle, text, order,  pageId);
		this.id = id;
		this.html = html;
		// TODO Auto-generated constructor stub
	}

	public HtmlWidget( String name, int width, int height, String cssClass, String cssStyle, String text,
			int order,
			String html, int pageId) {
		super(name, width, height, cssClass, cssStyle, text, order,  pageId);
		this.html = html;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	
	

}
