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
public class Accounthead {

    @Id
    private int code;
    private String headName;
    private String purpose;
    private String type;
    private String baseFee;
    private String eLStatus;

    public Accounthead(int code, String headName, String purpose, String type, String baseFee, String eLStatus) {
        this.code = code;
        this.headName = headName;
        this.purpose = purpose;
        this.type = type;
        this.baseFee = baseFee;
        this.eLStatus = eLStatus;
    }

    public Accounthead() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(String baseFee) {
        this.baseFee = baseFee;
    }

    public String geteLStatus() {
        return eLStatus;
    }

    public void seteLStatus(String eLStatus) {
        this.eLStatus = eLStatus;
    }
    
    

}
