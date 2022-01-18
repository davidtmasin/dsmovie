package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_comment")
public class Comments {
	
	@EmbeddedId
	private CommentsPK id = new CommentsPK();
	private String comments;
	
	public Comments() {}

	public CommentsPK getId() {
		return id;
	}

	public void setId(CommentsPK id) {
		this.id = id;
	}

	public String getComment() {
		return comments;
	}

	public void setComment(String comments) {
		this.comments = comments;
	}
	
	public void setMovieComment(Movie movieComment) {
		id.setMovieComment(movieComment);
	}
	
	public void setUserComment(User userComment){
		id.setUserComment(userComment);
	}
	
	
	
}
