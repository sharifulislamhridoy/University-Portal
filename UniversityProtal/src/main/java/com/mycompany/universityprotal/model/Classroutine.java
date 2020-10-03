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
public class Classroutine {

    @Id
    private int routineid;
    private String day;
    private String time;
    private String batchid;
    private String courseid;
    private String teacherid;

    public Classroutine() {
    }

    public Classroutine(int routineid, String day, String time, String batchid, String courseid, String teacherid) {
        this.routineid = routineid;
        this.day = day;
        this.time = time;
        this.batchid = batchid;
        this.courseid = courseid;
        this.teacherid = teacherid;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

   

    public int getRoutineid() {
        return routineid;
    }

    public void setRoutineid(int routineid) {
        this.routineid = routineid;
    }

    
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
