package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.CommentsDTO;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.CommentsService;
import com.devsuperior.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;
	
	@PutMapping
	public MovieDTO saveComments(@RequestBody CommentsDTO dto){
		MovieDTO movieDTO = commentsService.saveComments(dto);
		return movieDTO;
	}
	
	
}
