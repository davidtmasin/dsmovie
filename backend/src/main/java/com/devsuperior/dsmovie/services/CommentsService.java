package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.CommentsDTO;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Comments;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.CommentsRepository;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

@Service
public class CommentsService {
	
	@Autowired
	private MovieRepository movieRepositoryCS;
	
	@Autowired
	private UserRepository userRepositoryCS;
	
	@Autowired
	private CommentsRepository commentsRepositoryCS;
	
	@Transactional
	public MovieDTO saveComments(CommentsDTO dtoComments) {
		User user = userRepositoryCS.findByEmail(dtoComments.getEmail());
		
		//Se não existir o usuário, será criado e salvo no BD
		if(user == null) {
			user = new User();
			user.setEmail(dtoComments.getEmail());
			user = userRepositoryCS.saveAndFlush(user);			
		}
		
		Movie movie = movieRepositoryCS.findById(dtoComments.getMovieIdComments()).get();
		
		Comments comments = new Comments();
		comments.setMovieComment(movie);
		comments.setUserComment(user);
		comments.setComment(dtoComments.getComments());
		
		comments = commentsRepositoryCS.saveAndFlush(comments);
		
//		double sum = 0.0;
//		for (Score s : movie.getScores()) {
//			sum = sum +s.getValue();
//		}
//		
//		double avg = sum / movie.getScores().size();
//		
//		movie.setScore(avg);
//		movie.setCount(movie.getScores().size());
//		
//		movie = movieRepositoryCS.save(movie);
		
//		movie = movieRepositoryCS.save(movie.getComments())
//		
		return new MovieDTO(movie);
	}
	
}
