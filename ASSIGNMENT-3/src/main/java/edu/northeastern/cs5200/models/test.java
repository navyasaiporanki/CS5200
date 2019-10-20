package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

import edu.northeastern.cs5200.daos.PageImpl;

public class test {
	
	public static void main(String[] args) {
		
		  Collection<Page> pageListWiki =
		  PageImpl.getInstance().findPagesForWebsite(345);
		  
		  Date startDate = new Date(1000); int pageWebsiteWiki = 0;
		  
		  for(Page pageWiki : pageListWiki) {
		  
		  Date fromTable = pageWiki.getUpdated();
		  
		  if(fromTable.after(startDate)) { startDate = pageWiki.getUpdated();
		  pageWebsiteWiki = pageWiki.getId(); } }
		  
		  PageImpl.getInstance().deletePage(pageWebsiteWiki);
		 
	}

}
