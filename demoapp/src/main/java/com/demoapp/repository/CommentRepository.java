package com.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
