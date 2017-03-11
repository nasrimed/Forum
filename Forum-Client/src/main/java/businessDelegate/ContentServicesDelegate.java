package businessDelegate;

import java.util.Date;
import java.util.List;

import Entities.Category;
import Entities.Content;
import ServiceLocator.ServiceLocator;
import Services.ContentServicesRemote;

public class ContentServicesDelegate {

	private static String jndiName = "Forum-ear/Forum-ejb/ContentServices!Services.ContentServicesRemote";

	public static ContentServicesRemote getProxy() {
		return (ContentServicesRemote) ServiceLocator.getInstance().getRemoteProxy(jndiName);
	}

	public static void addContent(String title, String genre, String description, String trailer, Date date,
			Category category) {
		getProxy().addContent(title, genre, description, trailer, date, category);
	}
	
	public static void updateContent(Content content) {
		getProxy().updateContent(content);
	}
	

	public static Content findContentById(Integer id) {
		return getProxy().findContentById(id);
	}
	
	

	public static Category findCategoryById(Integer id) {
		return getProxy().findCategoryById(id);
	}

	public static void deleteContent(Content content) {

		getProxy().deleteContent(content);
	}

	public static void deleteContentById(Integer id) {

		getProxy().deleteContentById(id);

	}

	public static List<Content> findAllContents() {

		return getProxy().findAllContents();
	}

	public static List<Content> findContentByCategory(Category category) {
		
		return getProxy().findContentByCategory(category);
	}

}