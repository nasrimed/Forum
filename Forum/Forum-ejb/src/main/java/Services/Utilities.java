package Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Admin;
import Entities.Category;
import Entities.Moderator;
import Entities.TypeCategory;
import Entities.User;




/**
 * Session Bean implementation class Utilities
 */
@Singleton
@LocalBean
@Startup
public class Utilities {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public Utilities() {
	}

	@PostConstruct
	public void initDb() {
		Admin admin=new Admin();
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setUsername("admin");
		admin.setPassword("admin");
		Date naissanceadmin;
		try {
			naissanceadmin = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			admin.setDateOfBirth(naissanceadmin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		admin.setEmail("admin@esprit.tn");
		admin.setRole("admin");
		admin.setEnabled(true);
		admin.setResponsibleOf("All");
		Moderator moderator=new Moderator();
		moderator.setFirstName("moderator");
		moderator.setLastName("moderator");
		moderator.setUsername("moderator");
		moderator.setPassword("moderator");
		Date naissancemod;
		try {
			naissancemod = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator.setDateOfBirth(naissancemod);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator.setEmail("moderator@esprit.tn");
		moderator.setRole("moderator");
		moderator.setResponsibleOf("Movies");
		moderator.setEnabled(true);
		Moderator moderator1=new Moderator();
		moderator1.setFirstName("moderator1");
		moderator1.setLastName("moderator1");
		moderator1.setUsername("moderator1");
		moderator1.setPassword("moderator1");
		Date naissancemod1;
		try {
			naissancemod1 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator1.setDateOfBirth(naissancemod1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator1.setEmail("moderator1@esprit.tn");
		moderator1.setRole("moderator");
		moderator1.setResponsibleOf("Games");
		moderator1.setEnabled(true);
		Moderator moderator2=new Moderator();
		moderator2.setFirstName("moderator2");
		moderator2.setLastName("moderator2");
		moderator2.setUsername("moderator2");
		moderator2.setPassword("moderator2");
		Date naissancemod2;
		try {
			naissancemod2 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator2.setDateOfBirth(naissancemod2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moderator2.setEmail("moderator2@esprit.tn");
		moderator2.setRole("moderator");
		moderator2.setResponsibleOf("TV");
		moderator2.setEnabled(true);

		Moderator moderator3=new Moderator();
		moderator3.setFirstName("moderator3");
		moderator3.setLastName("moderator3");
		moderator3.setUsername("moderator3");
		moderator3.setPassword("moderator3");
		Date naissancemod3;
		try {
			naissancemod3 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			moderator3.setDateOfBirth(naissancemod3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		moderator3.setEmail("moderator3@esprit.tn");
		moderator3.setRole("moderator");
		moderator3.setResponsibleOf("Music");
		moderator3.setEnabled(true);
		User user =new User();
		user.setFirstName("Makni");
		user.setLastName("Ali");
		user.setUsername("alimakni");
		user.setPassword("M11015485");
		Date naissance;
		try {
			naissance = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			user.setDateOfBirth(naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		user.setRole("User");
		user.setEmail("ali.makni@esprit.tn");
		user.setEnabled(true);
		
		User user1 =new User();
		user1.setFirstName("Attallah");
		user1.setLastName("Marween");
		user1.setUsername("marweenattallah");
		user1.setPassword("Matt");
		Date naissance1;
		try {
			naissance1 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-07");
			user1.setDateOfBirth(naissance1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		user1.setRole("User");
		user1.setEmail("marween.attallah@esprit.tn");
		user1.setEnabled(true);
		
		entityManager.persist(admin);
		entityManager.persist(moderator);
		entityManager.persist(moderator1);
		entityManager.persist(moderator2);
		entityManager.persist(moderator3);
		entityManager.persist(user);
		entityManager.persist(user1);
	////////////////////////////////////////////////////////////
	
		Category category1 =new Category();
		category1.setDescription("ALL MOVIES");
		category1.setTypeCategory(TypeCategory.MOVIES);
		
		Category category2 =new Category();
		category2.setDescription("ALL TV");
		category2.setTypeCategory(TypeCategory.TV);

		
		Category category3 =new Category();
		category3.setDescription("ALL GAMES");
		category3.setTypeCategory(TypeCategory.GAMES);
		
		
		Category category4 =new Category();
		category4.setDescription("ALL MUSIC");
		category4.setTypeCategory(TypeCategory.MUSIC);
		
		
		entityManager.persist(category1);
		entityManager.persist(category2);
		entityManager.persist(category3);
		entityManager.persist(category4);
	}
}