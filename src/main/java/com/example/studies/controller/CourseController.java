package com.example.studies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studies.model.Course;
import com.example.studies.repository.CourseRepository;

@RestController
@RequestMapping(path = "/course")
public class CourseController {
    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping(path = "/all")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
