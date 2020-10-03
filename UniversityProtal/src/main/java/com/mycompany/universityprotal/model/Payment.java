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

public class Payment {

    @Id
    private int id;
    private String studentsId;
    private String name;
    private String facultyName;
    private String departmentName;
    private String batchName;
    private String semesterName;
    private String headName;
    private String purpose;
    private String type;
    private int basefee;
    private String method;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date datePayment;
    private String acINfo;
    private String pass;

    public Payment() {
    }

    public Payment(int id, String studentsId, String name, String facultyName, String departmentName, String batchName, String semesterName, String headName, String purpose, String type, int basefee, String method, Date datePayment, String acINfo, String pass) {
        this.id = id;
        this.studentsId = studentsId;
        this.name = name;
        this.facultyName = facultyName;
        this.departmentName = departmentName;
        this.batchName = batchName;
        this.semesterName = semesterName;
        this.headName = headName;
        this.purpose = purpose;
        this.type = type;
        this.basefee = basefee;
        this.method = method;
        this.datePayment = datePayment;
        this.acINfo = acINfo;
        this.pass = pass;
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

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBasefee() {
        return basefee;
    }

    public void setBasefee(int basefee) {
        this.basefee = basefee;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }



    public String getAcINfo() {
        return acINfo;
    }

    public void setAcINfo(String acINfo) {
        this.acINfo = acINfo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
