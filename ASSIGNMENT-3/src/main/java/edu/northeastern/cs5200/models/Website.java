package edu.northeastern.cs5200.models;

import java.util.Collection;
import java.sql.Date;

public class Website {

	
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int visits;
	private int developerId;
	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}


	private Developer developer;
	private Collection<Page> pages;
	
	
	public Website(int id, String name, String description, Date created, Date updated,
			int visits) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		
	}
	
	public Website(int id, String name, String description, Date created, Date updated,
			int visits, int developerId) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		this.developerId = developerId;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}


	public int getVisits() {
		return visits;
	}


	public void setVisits(int visits) {
		this.visits = visits;
	}


	public Developer getDeveloper() {
		return developer;
	}


	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


	public Collection<Page> getPages() {
		return pages;
	}


	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}
	
	
	
	
}
