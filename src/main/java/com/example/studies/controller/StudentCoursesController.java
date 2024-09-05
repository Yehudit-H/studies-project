package com.example.studies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studies.model.Course;
import com.example.studies.model.IStudentCountInCourse;
import com.example.studies.model.Student;
import com.example.studies.model.StudentCourses;
import com.example.studies.repository.CourseRepository;
import com.example.studies.repository.StudentCoursesRepository;
import com.example.studies.repository.StudentRepository;

@RestController
@RequestMapping(path = "/studentCourses")
public class StudentCoursesController {
    private final StudentCoursesRepository studentCoursesRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository coursesRepository;

    public StudentCoursesController(StudentCoursesRepository studentCoursesRepository,
            StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentCoursesRepository = studentCoursesRepository;
        this.studentRepository = studentRepository;
        this.coursesRepository = courseRepository;
    }

    @GetMapping(path = "/all")
    public List<StudentCourses> getAllStudentCourses() {
        return studentCoursesRepository.findAll();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addStudentCourses(@RequestParam String studentId, @RequestParam int courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = coursesRepository.findById(courseId);

        try {
            StudentCourses studentCourses = new StudentCourses();
            course.ifPresent(studentCourses::setCourse);
            student.ifPresent(studentCourses::setStudent);
            studentCoursesRepository.save(studentCourses);
            return new ResponseEntity<>("New record created successfully: " + studentCourses, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/countStudentsForAllCourses")
    public List<IStudentCountInCourse> getCountStudentsForAllCourses() {
        return studentCoursesRepository.countAmountStudentsByCourse();
    }

}
