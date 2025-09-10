package com.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
