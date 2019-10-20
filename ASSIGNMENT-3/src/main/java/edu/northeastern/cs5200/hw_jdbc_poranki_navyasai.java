package edu.northeastern.cs5200;

import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;

import edu.northeastern.cs5200.daos.AddressImpl;
import edu.northeastern.cs5200.daos.DeveloperImpl;
import edu.northeastern.cs5200.daos.PageImpl;

import edu.northeastern.cs5200.daos.PhoneImpl;

import edu.northeastern.cs5200.daos.RoleImpl;
import edu.northeastern.cs5200.daos.UserImpl;

import edu.northeastern.cs5200.daos.WebsiteImpl;

import edu.northeastern.cs5200.daos.WidgetImpl;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.HeadingWidget;
import edu.northeastern.cs5200.models.HtmlWidget;
import edu.northeastern.cs5200.models.ImageWidget;
import edu.northeastern.cs5200.models.Page;

import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;
import edu.northeastern.cs5200.models.YoutubeWidget;

public class hw_jdbc_poranki_navyasai {

	public static void main(String[] args) {

		DeveloperImpl developerInstance = DeveloperImpl.getInstance();
		UserImpl userInstance = UserImpl.getInstance();
		PhoneImpl phoneInstance = PhoneImpl.getInstance();
		AddressImpl addressInstance = AddressImpl.getInstance();
		WebsiteImpl websiteInstance = WebsiteImpl.getInstance();
		PageImpl pageInstance = PageImpl.getInstance();
		WidgetImpl widgetInstance = WidgetImpl.getInstance();

		// 1
		// a
		Developer alice = new Developer("4321rewq", 12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com",
				new Date(Calendar.getInstance().getTime().getTime()), null, null);

		developerInstance.createDeveloper(alice);

		// b
		Developer bob = new Developer("5432trew", 23, "Bob", "Marley", "bob", "bob", "bob@marley.com",
				new Date(Calendar.getInstance().getTime().getTime()), null, null);

		developerInstance.createDeveloper(bob);

		// c
		Developer charlie = new Developer("6543ytre", 34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com",
				new Date(Calendar.getInstance().getTime().getTime()), null, null);

		developerInstance.createDeveloper(charlie);

		// d
		User dan = new User(false, 45, "Dan", "Martin", "dan", "dan", "dan@martin.com",
				new Date(Calendar.getInstance().getTime().getTime()), null, null);

		userInstance.createUser(dan);

		// e
		User ed = new User(false, 56, "Ed", "Karaz", "ed", "ed", "ed@kar.com",
				new Date(Calendar.getInstance().getTime().getTime()), null, null);

		userInstance.createUser(ed);

		// Inserting Phone numbers

		phoneInstance.insertPhone(12, "123-234-3456", true);
		phoneInstance.insertPhone(12, "234-345-4566", false);

		phoneInstance.insertPhone(23, "345-456-5677", true);

		phoneInstance.insertPhone(34, "321-432-5435", true);
		phoneInstance.insertPhone(34, "432-432-5433", false);
		phoneInstance.insertPhone(34, "543-543-6544", false);

		// Inserting Address for the users

		addressInstance.insertAddress(12, "123 Adam St.", null, "Alton", "MA", "01234", true);
		addressInstance.insertAddress(12, "Birch St.", null, "Boston", "MA", "02345", false);

		addressInstance.insertAddress(23, "345 Charles St.", null, "Chelms", "MA", "03445", true);
		addressInstance.insertAddress(23, "456 Down St.", null, "Dalton", "MA", "04566", false);
		addressInstance.insertAddress(23, "543 East St.", null, "Everett", "MA", "03445", false);

		addressInstance.insertAddress(34, "654 Frank St.", null, "Foulton", "MA", "04322", true);

		// 2 Inserting values in to website
		// a

		int alice_userId = alice.getId();
		Website facebook = new Website(123, "Facebook", "an online social media and social networking service",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 1234234, alice_userId);

		websiteInstance.createWebsiteForDeveloper(alice_userId, facebook);

		// b

		int bob_userId2 = bob.getId();
		Website twitter = new Website(234, "Twitter", "an online news and social networking service",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 4321543, bob_userId2);

		websiteInstance.createWebsiteForDeveloper(bob_userId2, twitter);

		// c

		int charlie_userId3 = charlie.getId();

		Website wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 3456654, charlie_userId3);

		websiteInstance.createWebsiteForDeveloper(charlie_userId3, wikipedia);

		// d

		Website cnn = new Website(456, "CNN", "an American basic cable and satellite television news channel",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 6543345, alice_userId);

		websiteInstance.createWebsiteForDeveloper(alice_userId, cnn);

		// e

		Website cnet = new Website(567, "CNET",
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 5433455, bob_userId2);

		websiteInstance.createWebsiteForDeveloper(bob_userId2, cnet);

		// f

		Website gizmodo = new Website(678, "Gizmodo",
				"a design, technology, science and science fiction website that also writes articles on politic",
				new Date(Calendar.getInstance().getTime().getTime()),
				new Date(Calendar.getInstance().getTime().getTime()), 4322345, charlie_userId3);

		websiteInstance.createWebsiteForDeveloper(charlie_userId3, gizmodo);

		// 3 Inserting into pages

		Date dateCreated = Date.valueOf("2019-09-04");
		Date updatedPage = new Date(Calendar.getInstance().getTime().getTime());

		// a

		Page home = new Page(123, "Home", "Landing page", dateCreated, updatedPage, 123434, cnet.getId());

		pageInstance.createPageForWebsite(cnet.getId(), home);

		// b
		Page about = new Page(234, "About", "Website description", dateCreated, updatedPage, 234545, gizmodo.getId());

		pageInstance.createPageForWebsite(gizmodo.getId(), about);

		// c
		Page contact = new Page(345, "Contact", "Addresses, phones, and contact info", dateCreated, updatedPage, 567878,
				wikipedia.getId());

		pageInstance.createPageForWebsite(wikipedia.getId(), contact);

		// d
		Page preferences = new Page(456, "Preferences", "Where users can configure their preferences", dateCreated,
				updatedPage, 456776, cnn.getId());

		pageInstance.createPageForWebsite(cnn.getId(), preferences);

		// e
		Page profile = new Page(567, "Profile", "Users can configure their personal information", dateCreated,
				updatedPage, 567878, cnet.getId());

		pageInstance.createPageForWebsite(cnet.getId(), profile);

		// 4 Updating the widgets

		// a

		int p1Id = home.getId();
		HeadingWidget heading = new HeadingWidget("head123", 0, 0, null, null, "Welcome", 0, 0, p1Id);

		widgetInstance.createWidgetForPage(p1Id, heading);

		// b

		int p2Id = about.getId();

		HtmlWidget html = new HtmlWidget("post234", 0, 0, null, null, "<p>Lorem</p>", 0, null, p2Id);
		widgetInstance.createWidgetForPage(p2Id, html);

		// b

		int p3Id = contact.getId();
		HeadingWidget heading1 = new HeadingWidget("head345", 0, 0, null, null, "Hi", 1, 0, p3Id);
		widgetInstance.createWidgetForPage(p3Id, heading1);

		// d
		HtmlWidget html1 = new HtmlWidget("intro456", 0, 0, null, null, "<h1>Hi</h1>", 2, null, p3Id);
		widgetInstance.createWidgetForPage(p3Id, html1);

		// e
		ImageWidget image = new ImageWidget("image345", 50, 100, null, null, null, 3, "/img/567.png", p3Id);
		widgetInstance.createWidgetForPage(p3Id, image);

		// f

		int p6Id = preferences.getId();
		YoutubeWidget youtube = new YoutubeWidget("video456", 400, 300, null, null, null, 0,
				"https://youtu.be/h67VX51QXiQ", false, false, p6Id);

		widgetInstance.createWidgetForPage(p6Id, youtube);

		// Updates

		// a

		int userId = charlie.getId();
		String phoneNumber = "333-444-5555";
		if (phoneInstance.updatePhone(userId, phoneNumber, true) == 0) {
			phoneInstance.insertPhone(userId, phoneNumber, true);
		}

		// b

		Widget widget = widgetInstance.findWidgetByName("head345");
		int pageId = widget.getPage().getId();

		Collection<Widget> widgetList = WidgetImpl.getInstance().findWidgetsForPage(pageId);

		for (Widget w : widgetList) {

			if (w.getName().equalsIgnoreCase("head345")) {
				w.setOrder(3);
			} else {

				w.setOrder(w.getOrder() - 1);
			}
			WidgetImpl.getInstance().updateWidget(w.getId(), w);

		}

		// c

		Collection<Page> pageList = pageInstance.findPagesForWebsite(cnet.getId());

		for (Page page : pageList) {

			page.setTitle("CNET-" + page.getTitle());
			pageInstance.updatePage(page.getId(), page);

		}

		// d

		for (Page page : pageList) {

			if (page.getTitle().equalsIgnoreCase("home") || page.getTitle().equalsIgnoreCase("cnet-home")) {
				int userIdCharlie = charlie_userId3;
				int userIdAlice = alice_userId;

				// editor - alice 4 role id //writer - charlie 3 role id

				int page_Id_Update = page.getId();

				RoleImpl.getInstance().deletePageRole(userIdAlice, page_Id_Update, 4);
				RoleImpl.getInstance().deletePageRole(userIdCharlie, page_Id_Update, 3);

				RoleImpl.getInstance().assignPageRole(userIdCharlie, page_Id_Update, 4);
				RoleImpl.getInstance().assignPageRole(userIdAlice, page_Id_Update, 3);
			}

		}

		// deletes

		// a

		AddressImpl.getInstance().deleteAddress(alice_userId, true);

		// b

		Collection<Widget> contactWidgetList = widgetInstance.findWidgetsForPage(contact.getId());

		int widgetId = 0;
		int orderWidget = 0;

		for (Widget w : contactWidgetList) {

			if (w.getOrder() > orderWidget) {
				widgetId = w.getId();
				orderWidget = w.getOrder();

			}

		}

		widgetInstance.deleteWidget(widgetId);

		//System.out.println("Deleted ");

		// c

		Collection<Page> pageListWiki = pageInstance.findPagesForWebsite(wikipedia.getId());

		Date startDate = new Date(1000);
		int pageWebsiteWiki = 0;

		for (Page pageWiki : pageListWiki) {

			Date fromTable = pageWiki.getUpdated();

			if (fromTable.after(startDate)) {
				startDate = pageWiki.getUpdated();
				pageWebsiteWiki = pageWiki.getId();
			}
		}

		pageInstance.deletePage(pageWebsiteWiki);

		// d
		websiteInstance.deleteWebsite(cnet.getId());

		System.out.println("Executed all methods");

	}

}
