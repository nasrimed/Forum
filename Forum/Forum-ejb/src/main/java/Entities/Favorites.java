package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorites
 *
 */
@Entity

public class Favorites implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    @OneToOne
    private User user;
    
    @OneToMany(mappedBy="favorites")
    private List<Content> contents;

	private static final long serialVersionUID = 1L;

	public Favorites() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}
