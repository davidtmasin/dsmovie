package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsmovie.entities.Comments;
import com.devsuperior.dsmovie.entities.CommentsPK;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, CommentsPK>{

}
