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
public class Department {
  

    @Id
    private int dep_Id;
    private String departmentName;
    private String facultyName;
    private String status;

    public Department() {
    }

    public Department(int dep_Id, String departmentName, String facultyName, String status) {
        this.dep_Id = dep_Id;
        this.departmentName = departmentName;
        this.facultyName = facultyName;
        this.status = status;
    }

  
    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getDep_Id() {
        return dep_Id;
    }

    public void setDep_Id(int dep_Id) {
        this.dep_Id = dep_Id;
    }
   
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
