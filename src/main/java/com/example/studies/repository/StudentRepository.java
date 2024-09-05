package com.example.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studies.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
