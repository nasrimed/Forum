package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Moderator
 *
 */
@Entity

public class Moderator extends User implements Serializable {

	
	
	
	@OneToMany(mappedBy="moderator")
	private List<Content> contents;
	private static final long serialVersionUID = 1L;

	public Moderator() {
		super();
	}

	

	public List<Content> getContent() {
		return contents;
	}

	public void setContent(List<Content> contents) {
		this.contents = contents;
	}

	

  
	
	
   
}
