package com.example.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studies.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
