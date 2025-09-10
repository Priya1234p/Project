package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {}

