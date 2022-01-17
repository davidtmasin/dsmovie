package com.devsuperior.dsmovie.dto;

public class CommentsDTO {
	private Long movieIdComments;
	private String email;
	private String comments;
	
	public CommentsDTO() {}

	public Long getMovieIdComments() {
		return movieIdComments;
	}

	public void setMovieIdComments(Long movieIdComments) {
		this.movieIdComments = movieIdComments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
