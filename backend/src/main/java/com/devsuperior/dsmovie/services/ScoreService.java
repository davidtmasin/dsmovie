package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepositorySS;
	
	@Autowired
	private UserRepository userRepositorySS;
	
	@Autowired
	private ScoreRepository scoreRepositorySS;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepositorySS.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepositorySS.saveAndFlush(user);			
		}
		
		Movie movie = movieRepositorySS.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepositorySS.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum +s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepositorySS.save(movie);
		
		return new MovieDTO(movie);
	}
	
}
