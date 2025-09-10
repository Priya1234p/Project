package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Stop;

public interface StopRepository extends JpaRepository<Stop, Long> {

}
