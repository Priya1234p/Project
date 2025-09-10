package com.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentservice.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
