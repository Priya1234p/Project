package com.As_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.As_project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
