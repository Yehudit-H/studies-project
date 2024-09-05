package com.example.studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studies.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, String> {
}
