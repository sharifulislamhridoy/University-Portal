/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Attandance;
import com.mycompany.universityprotal.model.Courses;
import com.mycompany.universityprotal.model.Result;
import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.repository.CoursesRepository;
import com.mycompany.universityprotal.repository.ResultRepository;
import com.mycompany.universityprotal.repository.StudentaccountRepository;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
public class ResultController {

    @Autowired
    StudentaccountRepository studentaccountRepository;
    @Autowired
    ResultRepository resultRepository;
    
      @Autowired
    CoursesRepository coursesRepository;

    @RequestMapping(value = "/resultView", method = RequestMethod.GET)
    public ModelAndView save(ModelMap map) {

        List<Studentaccount> allStudent = studentaccountRepository.viewAll();
           List<Courses> allCoursesResult = coursesRepository.viewAll();
        map.addAttribute("allStudent", allStudent);
        map.addAttribute("allCoursesResult", allCoursesResult);
        return new ModelAndView("result");
    }
    
    
    @RequestMapping(value = "/onChangeResultProcess", method = RequestMethod.POST)
    public ModelAndView onChangeAttandance(HttpServletRequest request, ModelMap map2) {


        Map<String, String[]> map = request.getParameterMap();
//         List<Studentaccount> allStudent = studentaccountRepository.viewAll();
//        List<Courses> allCourses = coursesRepository.viewAll();

           List<Courses> allCoursesResult = coursesRepository.viewAll();

        
//        map2.addAttribute("allStudent", allStudent);
//        map2.addAttribute("allCourses", allCourses);
 map2.addAttribute("allCoursesResult", allCoursesResult);
        String Byname = map.get("CoursesResultNameById")[0];
        System.out.println(Byname+"........................");
        List<Studentaccount> allStudent = studentaccountRepository.selectByCourseName(Byname);
        map2.addAttribute("allStudent", allStudent);
//         for (int i = 0; i < allStudentById.size(); i++) {
//            System.out.println(allStudentById.get(i).getCoursesName()+ "   ..............................");
//        }

        return new ModelAndView("result");
    }
    
    
    
    
        @RequestMapping(value = "/allResultView", method = RequestMethod.GET)
    public ModelAndView showResult(ModelMap map) {

        List<Result> allResult = resultRepository.viewAll();
        map.addAttribute("allResult", allResult);
        return new ModelAndView("result-view");
    }
    
    
    
    
    

    @RequestMapping(value = "/saveResulr", method = RequestMethod.POST)
    public String attandance(HttpServletRequest request) {
        System.out.println("hit by resultController");
        Map<String, String[]> map = request.getParameterMap();

        String[] student_id = (String[]) map.get("student_id[]");
        String[] student_name = (String[]) map.get("student_name[]");
        String[] faculty_name = (String[]) map.get("faculty_name[]");
        String[] courses_name = (String[]) map.get("courses_name[]");
        String[] coursesCode_name = (String[]) map.get("coursesCode_name[]");
        String[] coursesCradit_name = (String[]) map.get("coursesCradit_name[]");
        String[] coursesPrice_name = (String[]) map.get("coursesPrice_name[]");
        String[] batch_name = (String[]) map.get("batch_name[]");
        String[] classTest = (String[]) map.get("classTest[]");
        String[] midTrem = (String[]) map.get("midTrem[]");
        String[] finalTest = (String[]) map.get("finalTest[]");

        for (int i = 0; i < student_id.length; i++) {
            System.out.println(".............     " + classTest[i]);
            System.out.println(".............     " + midTrem[i]);
            System.out.println(".............     " + faculty_name[i]);
            System.out.println(".............     " + student_name[i]);

            System.out.println(".............     " + courses_name[i]);
            System.out.println(".............     " + coursesCode_name[i]);
            System.out.println(".............     " + coursesCradit_name[i]);
            System.out.println(".............     " + coursesPrice_name[i]);
            System.out.println(".............     " + batch_name[i]);
            System.out.println(".............     " + coursesCradit_name[i]);

            int clterm = Integer.parseInt(classTest[i]);
            int finaltest = Integer.parseInt(finalTest[i]);
            int midt = Integer.parseInt(midTrem[i]);
            int totalNumber = clterm + finaltest + midt;
            String gp = "";
            Result result = new Result();
            result.setStudentsId(student_id[i]);
            result.setName(student_name[i]);
            result.setFacultyName(faculty_name[i]);

            result.setCoursesName(courses_name[i]);
            result.setCourseCode(coursesCode_name[i]);
            result.setBatchName(batch_name[i]);
            result.setClassTest(clterm);
            result.setMidTerm(midt);
            result.setFinalExm(finaltest);
            result.setTotal(totalNumber);

            if (totalNumber >= 80) {
               gp="A";
            } else if (totalNumber >= 70 && totalNumber < 80) {
                gp="A-";
                System.out.print("A-");
            } else if (totalNumber >= 60 && totalNumber < 70) {
               gp="B";
                System.out.print("B");
            } else if (totalNumber >= 50 && totalNumber < 60) {
                gp="C";
                System.out.print("C");
            } else if (totalNumber >= 40 && totalNumber < 50) {
                gp="D";
                System.out.print("D");
            } else {
               gp="F";
                System.out.println("F");
            }
            result.setGreatPoint(gp);
            resultRepository.save(result);
        }
        System.out.println("------------------------------------");
        return "redirect:/allResultView";
    }

}
