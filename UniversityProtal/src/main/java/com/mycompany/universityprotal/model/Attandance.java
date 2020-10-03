/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author shari
 */
@Entity
public class Attandance {

    @Id
    private int id;
    private String studentsId;
    private String name;
    private String facultyName;
    private String departmentName;
    private String batchName;
    private String coursesName;
    private String courseCode;
    private String professorName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String starus;

    public Attandance() {
    }

    public Attandance(int id, String studentsId, String name, String facultyName, String departmentName, String batchName, String coursesName, String courseCode, String professorName, Date date, String starus) {
        this.id = id;
        this.studentsId = studentsId;
        this.name = name;
        this.facultyName = facultyName;
        this.departmentName = departmentName;
        this.batchName = batchName;
        this.coursesName = coursesName;
        this.courseCode = courseCode;
        this.professorName = professorName;
        this.date = date;
        this.starus = starus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(String studentsId) {
        this.studentsId = studentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStarus() {
        return starus;
    }

    public void setStarus(String starus) {
        this.starus = starus;
    }
    
    

}
