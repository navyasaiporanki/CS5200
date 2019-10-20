package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget{
	
	
	private int id;
	private String src;
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
	public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String src,int pageId) {
		super(id, name, width, height, cssClass, cssStyle, text, order,pageId);
		// TODO Auto-generated constructor stub
		this.src = src;
	}
	
	public ImageWidget( String name, int width, int height, String cssClass, String cssStyle, 
			String text, int order, String src, int pageId) {
		super(name, width, height, cssClass, cssStyle, text, order,  pageId);
		// TODO Auto-generated constructor stub
		this.src = src;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	

		
}
