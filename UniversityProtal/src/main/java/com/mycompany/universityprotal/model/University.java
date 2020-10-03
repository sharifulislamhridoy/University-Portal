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
public class University {

    @Id
    private int university_id;
    private String u_name;
    private String u_address;
    private String u_phone;
    private String u_logo;

    public University() {
    }

    public University(int university_id, String u_name, String u_address, String u_phone, String u_logo) {
        this.university_id = university_id;
        this.u_name = u_name;
        this.u_address = u_address;
        this.u_phone = u_phone;
        this.u_logo = u_logo;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(int university_id) {
        this.university_id = university_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public String getU_logo() {
        return u_logo;
    }

    public void setU_logo(String u_logo) {
        this.u_logo = u_logo;
    }

}
