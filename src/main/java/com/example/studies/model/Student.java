package com.example.studies.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = Student.TABLE_NAME)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
    public static final String TABLE_NAME = "students";

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private double gradeAverage;
    private Date createdDate = new Date();
    private String createdBy = "APP";
    private Date updatedDate = new Date();
    private String updatedBy = "APP";
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonIgnore
    private Set<StudentCourses> studentCourses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
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

    public Set<StudentCourses> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourses> studentCourses) {
        this.studentCourses = studentCourses;
    }

}
