package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comment")
public class Comments {
	
	@EmbeddedId
	private CommentsPK id = new CommentsPK();
	private String comment;
	
	public Comments() {}

	public CommentsPK getId() {
		return id;
	}

	public void setId(CommentsPK id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setMovieComment(Movie movieComment) {
		id.setMovieComment(movieComment);
	}
	
	public void setUserComment(User userComment){
		id.setUserComment(userComment);
	}
	
	
	
}
