/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author shari
 */
@Entity
public class Studentaccount {

    @Id
    private int id;
    private String studentsId;
    private String name;
    private String facultyName;
    private String departmentName;
    private String batchName;
    private String semesterName;
    private String coursesName;
    private String courseCode;
    private int courseCradit;
    private int coursePrice;
    private String professorName;

    public Studentaccount() {
    }

    public Studentaccount(int id, String studentsId, String name, String facultyName, String departmentName, String batchName, String semesterName, String coursesName, String courseCode, int courseCradit, int coursePrice, String professorName) {
        this.id = id;
        this.studentsId = studentsId;
        this.name = name;
        this.facultyName = facultyName;
        this.departmentName = departmentName;
        this.batchName = batchName;
        this.semesterName = semesterName;
        this.coursesName = coursesName;
        this.courseCode = courseCode;
        this.courseCradit = courseCradit;
        this.coursePrice = coursePrice;
        this.professorName = professorName;
    }

    public int getCourseCradit() {
        return courseCradit;
    }

    public void setCourseCradit(int courseCradit) {
        this.courseCradit = courseCradit;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
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

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
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

}
