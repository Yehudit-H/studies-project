package com.example.studies.model;

import java.util.Date;
import java.util.StringJoiner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = StudentCourses.TABLE_NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentCourses {
    public static final String TABLE_NAME = "student_courses";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    private Course course;
    private int hoursStudied;
    private double grade;
    private Date createdDate = new Date();
    private String createdBy = "APP";
    private Date updatedDate = new Date();
    private String updatedBy = "APP";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent() {
        return student.getFirstName() + " " + student.getLastName();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourse() {
        return course.getCourseName();
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getHoursStudied() {
        return hoursStudied;
    }

    public void setHoursStudied(int hoursStudied) {
        this.hoursStudied = hoursStudied;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", StudentCourses.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("student=" + getStudent())
                .add("course=" + getCourse())
                .add("hoursStudied=" + hoursStudied)
                .add("grade=" + grade)
                .add("createdDate=" + createdDate)
                .add("createdBy='" + createdBy + "'")
                .add("updatedDate=" + updatedDate)
                .add("updatedBy='" + updatedBy + "'")
                .toString();
    }
}
