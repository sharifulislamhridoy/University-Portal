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
public class Result {

    @Id
    private int id;
    private String studentsId;
    private String name;
    private String facultyName;
    private String departmentName;
    private String batchName;
    private String coursesName;
    private String courseCode;
    private int classTest;
    private int midTerm;
    private int finalExm;
    private int total;
    private String  greatPoint;

    public Result() {
    }


    public int getClassTest() {
        return classTest;
    }

    public void setClassTest(int classTest) {
        this.classTest = classTest;
    }

    public int getMidTerm() {
        return midTerm;
    }

    public void setMidTerm(int midTerm) {
        this.midTerm = midTerm;
    }

    public int getFinalExm() {
        return finalExm;
    }

    public void setFinalExm(int finalExm) {
        this.finalExm = finalExm;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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


    public String getGreatPoint() {
        return greatPoint;
    }

    public void setGreatPoint(String greatPoint) {
        this.greatPoint = greatPoint;
    }

}
