package com.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
