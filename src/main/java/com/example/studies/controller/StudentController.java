package com.example.studies.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studies.model.Student;
import com.example.studies.model.StudentCourses;
import com.example.studies.repository.StudentRepository;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping(path = "/add")
    public Student addNewStudent(@RequestBody Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @PutMapping(path = "/editInformation/{id}")
    public ResponseEntity<Student> editStudentInformation(@PathVariable String id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Student updatedStudent = existingStudent.get();

        Optional.ofNullable(student.getFirstName()).ifPresent(updatedStudent::setFirstName);
        Optional.ofNullable(student.getLastName()).ifPresent(updatedStudent::setLastName);
        Optional.ofNullable(student.getPhone()).ifPresent(updatedStudent::setPhone);
        Optional.ofNullable(student.getAddress()).ifPresent(updatedStudent::setAddress);
        Optional.ofNullable(student.getUpdatedDate()).ifPresent(updatedStudent::setUpdatedDate);
        Optional.ofNullable(student.getUpdatedBy()).ifPresent(updatedStudent::setUpdatedBy);

        studentRepository.save(updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping(path = "/studentByIdWithCoursesList/{studentId}")
    public Pair<Student, Set<StudentCourses>> getStudentByIdWithCoursesList(@PathVariable String studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(foundStudent -> Pair.of(foundStudent, foundStudent.getStudentCourses())).orElse(null);
    }

}
