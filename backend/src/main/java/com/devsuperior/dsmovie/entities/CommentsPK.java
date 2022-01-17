package com.devsuperior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentsPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movieComment;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userComment;
	
	
	public CommentsPK() {}


	public Movie getMovieComment() {
		return movieComment;
	}


	public void setMovieComment(Movie movieComment) {
		this.movieComment = movieComment;
	}


	public User getUserComment() {
		return userComment;
	}


	public void setUserComment(User userComment) {
		this.userComment = userComment;
	}


	
	
}
