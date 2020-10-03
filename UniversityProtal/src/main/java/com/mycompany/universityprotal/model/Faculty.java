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
public class Faculty {

    @Id
    private int fact_id;
    private String facultyName;
     public Faculty() {
    }

    public Faculty(int fact_id, String facultyName) {
        this.fact_id = fact_id;
        this.facultyName = facultyName;
    }

    public int getFact_id() {
        return fact_id;
    }

    public void setFact_id(int fact_id) {
        this.fact_id = fact_id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

   
    
    
    
    
}
