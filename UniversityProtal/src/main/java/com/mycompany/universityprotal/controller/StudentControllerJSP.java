/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Attandance;
import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.model.Result;
import com.mycompany.universityprotal.repository.AttandanceRepository;
import com.mycompany.universityprotal.repository.ResultRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shari
 */

@Controller
public class StudentControllerJSP {
    
    @Autowired
    AttandanceRepository attandanceRepository;
   
    
    @Autowired
    ResultRepository resultReposotory;
    
    
    @RequestMapping(value = "/showStudentAttandance", method = RequestMethod.GET)
    public ModelAndView showStudentAttandance(ModelMap map) {

        List<Attandance> allAttendance = attandanceRepository.selectByStudentId("123302236");
        map.addAttribute("allAttendance", allAttendance);
        return new ModelAndView("student-attendance-view");
    }
     @RequestMapping(value = "/showStudentResultView", method = RequestMethod.GET)
    public ModelAndView showStudentResultView(ModelMap map) {

        List<Result> oneStudentResult = resultReposotory.selectByStudentId("123302236");
        map.addAttribute("oneStudentResult", oneStudentResult);
        return new ModelAndView("student-result-view");
    }
    
}
