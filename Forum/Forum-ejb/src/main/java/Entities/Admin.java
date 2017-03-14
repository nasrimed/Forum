package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity

public class Admin extends Moderator implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}
	
	@OneToMany(mappedBy="admin")
	private List<Cast> casts;

	@OneToMany(mappedBy="admin")
	private List<Content> contents;
	
	public List<Cast> getCasts() {
		return casts;
	}

	public void setCasts(List<Cast> casts) {
		this.casts = casts;
	}

   
}
