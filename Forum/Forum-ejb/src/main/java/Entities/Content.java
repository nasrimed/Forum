package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Content
 *
 */
@Entity

public class Content implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String genre;
	private String description;
	private String trailer;
	private Date dateContent;
	@OneToMany(mappedBy="content")
	private List<FC> fcs;
	
	@ManyToOne 
	private Category category;
	
	@OneToMany(mappedBy="content")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy="content")
	private List<Comment> comments;
	
	@OneToMany(mappedBy="content")
	private List<Award>awards;
	
	
	
	
	public List<FC> getFcs() {
		return fcs;
	}
	public void setFcs(List<FC> fcs) {
		this.fcs = fcs;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Award> getAwards() {
		return awards;
	}
	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	private static final long serialVersionUID = 1L;

	public Content() {
		super();
	}   
	public Date getDateContent() {
		return dateContent;
	}
	public void setDateContent(Date dateContent) {
		this.dateContent = dateContent;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getTrailer() {
		return this.trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
   
}
