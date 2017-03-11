package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	private TypeCategory typeCategory;
	
	@OneToMany(mappedBy="category")
	private List<Content> contents;
	
	@ManyToOne
	private Admin admin;
	
	@OneToOne
	private Moderator moderator;
	private static final long serialVersionUID = 1L;

	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Category() {
		super();
	}   
	
	
	public Moderator getModerator() {
		return moderator;
	}
	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public TypeCategory getTypeCategory() {
		return typeCategory;
	}
	public void setTypeCategory(TypeCategory typeCategory) {
		this.typeCategory = typeCategory;
	}
	public Category(String description, TypeCategory typeCategory) {
		super();
		this.description = description;
		this.typeCategory = typeCategory;
	}
	public Category(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Category(Integer id) {
		super();
		this.id = id;
	}
   
}
