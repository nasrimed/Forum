package Entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity

public class Moderator extends User implements Serializable {

	
	private String responsibleOf;
	
	@OneToOne(mappedBy="moderator")
	private Category category;
	private static final long serialVersionUID = 1L;

	public Moderator() {
		super();
	}

	public String getResponsibleOf() {
		return responsibleOf;
	}

	public void setResponsibleOf(String responsibleOf) {
		this.responsibleOf = responsibleOf;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}   
	
	
   
}
