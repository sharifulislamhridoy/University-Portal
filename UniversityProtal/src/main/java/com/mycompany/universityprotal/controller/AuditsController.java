/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Audits;
import com.mycompany.universityprotal.service.AuditsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shari
 */
@RestController
@RequestMapping(value = "/api/v1")
public class AuditsController {

    @Autowired
    private AuditsService auditsService;

    @GetMapping("/log")
    public List<Audits> getAllCategory() {
        return auditsService.viewAll();

    }

}
