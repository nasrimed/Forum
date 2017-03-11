package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Category;
import Entities.Content;
import javax.persistence.Query;

/**
 * Session Bean implementation class ContentServices
 */
@Stateless
public class ContentServices implements ContentServicesRemote, ContentServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ContentServices() {
	}

	

	@Override
	public void addContent(String title, String genre, String description, String trailer,Date date, Category category) {
		// TODO Auto-generated method stub
		Content content=new Content(title, genre, description, trailer, date, category);
		entityManager.persist(content);
	}



	@Override
	public Content findContentById(Integer id) {
		return entityManager.find(Content.class, id);
	}



	@Override
	public void deleteContent(Content content) {
		entityManager.remove(entityManager.merge(content));
		
	}

	@Override
	public void deleteContentById(Integer id) {
		entityManager.remove(findContentById(id));
	}


	@Override
	public void updateContent(Content content) {
		entityManager.merge(content);

	}
	
	@Override
	public List<Content> findAllContents() {
		return entityManager.createQuery("select c from Content c ").getResultList();
	}
	
	
	@Override
	public List<Content> findContentByCategory(Category category) {
		return (List<Content>) entityManager.createQuery("select c from Content c where c.category=:cat").setParameter("cat", category);
		//query.setParameter("cat", category);
		//return query;
		
	 
 
	}



	@Override
	public Category findCategoryById(int id) {
		return entityManager.find(Category.class, id);
		
	}









	//@Override
	//public Category findCategoryById(int id) {
		//return entityManager.find(Category.class, id);
		
	//}

	






/*	@Override
	public void deleteContent(Content content) {
		entityManager.remove(entityManager.merge(content));
	}

	@Override
	public void updateContent(Content content) {
		entityManager.merge(content);
	
	}

	@Override
	public Player findPlayerById(Integer id) {
		return entityManager.find(Player.class, id);
	}

	@Override
	public Team findTeamById(Integer id) {
		return entityManager.find(Team.class, id);
	}

	@Override
	public void deletePlayer(Player player) {
		entityManager.remove(entityManager.merge(player));
	}

	@Override
	public List<Team> findAllTeams() {
		return entityManager.createQuery("select t from Team t ").getResultList();
	}*/

}
