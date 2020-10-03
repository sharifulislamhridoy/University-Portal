/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.repository.StudentaccountRepository;
import com.mycompany.universityprotal.repository.StudentsRepository;
import java.util.HashMap;
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
 * @author Shariful
 */
@Controller
//@RequestMapping("/attandance")
public class IndexController {
@Autowired
StudentsRepository studentsRepository;



     @RequestMapping(value = "/")
    public String create() {
        return "index";
    }
    
 
    
    
//     @RequestMapping(value = "/save" ,method = RequestMethod.POST)
//    public String attandance( HttpServletRequest request) {
//       System.out.println("hit by ");
//      Map<String, String[]> map =request.getParameterMap();
//
//       String[] student_name = (String[]) map.get("student_name[]");
//       
//         for (int i = 0; i < student_name.length; i++) {
//             System.out.println(student_name[i] + " ................");
//             
//             Students s = new Students();
//             s.setName(student_name[i]);
//             
//             
//             if(sdfsdfsd){
//             s.setstatus('P')
//             }
//             sessionFac.save(s)
//             
//         }
//       
//       return null;
//    }
}
