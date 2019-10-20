package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget{
	
	private int id;
	private int size;
	
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
	/*
	 * public HeadingWidget(int id, String name, int width, int height, String
	 * cssClass, String cssStyle, String text, int order) { super(id, name, width,
	 * height, cssClass, cssStyle, text, order); // TODO Auto-generated constructor
	 * stub }
	 */
	public HeadingWidget(int id, String name, int width, int height, String cssClass, 
			String cssStyle, String text,
			int order, int size, int pageId) {
		super(id, name, width, height, cssClass, cssStyle, text, order, pageId);
        this.size = size;
        this.id = id;
    }
	
	
	public HeadingWidget(String name, int width, int height, String cssClass, 
			String cssStyle, String text,
			int order, int size, int pageId) {
		super(name, width, height, cssClass, cssStyle, text, order, pageId);
        this.size = size;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	
	
	
	

	
	
	
}
