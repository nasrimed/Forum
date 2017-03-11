package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Category;
import Entities.Content;


@Remote
public interface ContentServicesRemote {
	
	void addContent(String title, String genre, String description,String trailer, Date date, Category category);

	

	Content findContentById(Integer id);
	
	void deleteContent(Content content);



	void deleteContentById(Integer id);



	void updateContent(Content content);



	List<Content> findAllContents();



	Category findCategoryById(int id);




	List<Content> findContentByCategory(Category category);




}
