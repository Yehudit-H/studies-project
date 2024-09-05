package com.example.studies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.studies.model.IStudentCountInCourse;
import com.example.studies.model.StudentCourses;

public interface StudentCoursesRepository extends JpaRepository<StudentCourses, String> {
    @Query(value = "SELECT c.course_name AS courseName, count(sc.course_id) AS amountStudents FROM student_courses sc LEFT JOIN courses c ON sc.course_id = c.id GROUP BY sc.course_id",
            nativeQuery = true)
    List<IStudentCountInCourse> countAmountStudentsByCourse();
}
