package com.example.studies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studies.model.Lecture;
import com.example.studies.repository.LectureRepository;

@RestController
@RequestMapping(path = "/lecture")
public class LectureController {
    private final LectureRepository lectureRepository;

    public LectureController(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @GetMapping(path = "/all")
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
}
