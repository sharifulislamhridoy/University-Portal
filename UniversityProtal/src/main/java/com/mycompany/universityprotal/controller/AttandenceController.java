/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Attandance;
import com.mycompany.universityprotal.model.Courses;
import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.repository.AttandanceRepository;
import com.mycompany.universityprotal.repository.CoursesRepository;
import com.mycompany.universityprotal.repository.StudentaccountRepository;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
//@RequestMapping("/attandance")
public class AttandenceController {

    @Autowired
    AttandanceRepository attandanceRepository;

    @Autowired
    StudentaccountRepository studentaccountRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @RequestMapping(value = "/showAttendance", method = RequestMethod.GET)
    public ModelAndView showAttandance(ModelMap map) {

        List<Attandance> allAttandance = attandanceRepository.viewAll();
        map.addAttribute("allAttandance", allAttandance);
        return new ModelAndView("attendance-view");
    }

    @RequestMapping(value = "/addAttandance", method = RequestMethod.GET)
    public ModelAndView saveAttandance(ModelMap map) {

        List<Studentaccount> allStudent = studentaccountRepository.viewAll();
        List<Courses> allCourses = coursesRepository.viewAll();

        map.addAttribute("allStudent", allStudent);
        map.addAttribute("allCourses", allCourses);
        return new ModelAndView("student-table");
    }

    @RequestMapping(value = "/onChange", method = RequestMethod.POST)
    public ModelAndView onChangeAttandance(HttpServletRequest request, ModelMap map2) {


        Map<String, String[]> map = request.getParameterMap();
         List<Studentaccount> allStudent = studentaccountRepository.viewAll();
        List<Courses> allCourses = coursesRepository.viewAll();

       

        
        map2.addAttribute("allStudent", allStudent);
        map2.addAttribute("allCourses", allCourses);

        String Byname = map.get("CoursesNameById")[0];
        List<Studentaccount> allStudentById = studentaccountRepository.selectByCourseName(Byname);
        map2.addAttribute("allStudentById", allStudentById);
//         for (int i = 0; i < allStudentById.size(); i++) {
//            System.out.println(allStudentById.get(i).getCoursesName()+ "   ..............................");
//        }

        return new ModelAndView("student-table");
    }

//    @RequestMapping(value = "/addAttandanceByCourses", method = RequestMethod.GET)
//    public ModelAndView attandanByCoursesName(ModelMap map) {
//
//        List<Studentaccount> allStudentByCoursesName = studentaccountRepository.viewAll();
//        map.addAttribute("allStudentByCoursesName", allStudentByCoursesName);
//        return new ModelAndView("student-table");
//    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView attandance(HttpServletRequest request) {
        System.out.println("hit by ");

        Map<String, String[]> map = request.getParameterMap();

        String[] student_name = (String[]) map.get("student_name[]");
        String[] student_id = (String[]) map.get("student_id[]");
        String[] faculty_name = (String[]) map.get("faculty_name[]");
        String[] courses_name = (String[]) map.get("courses_name[]");
        String[] coursesCode_name = (String[]) map.get("coursesCode_name[]");
        String[] batch_name = (String[]) map.get("batch_name[]");
        String[] professor_name = (String[]) map.get("professor_name[]");
        String[] attendance_status = (String[]) map.get("attendance_status[]");

        for (int i = 0; i < student_name.length; i++) {

            Attandance atnd = new Attandance();
            boolean containsAttn = Arrays.stream(attendance_status).anyMatch(student_id[i]::equals);

            if (containsAttn) {

                atnd.setStarus("Present");
            } else {

                atnd.setStarus("Absent");

            }

            atnd.setDate(new Date());

            atnd.setName(student_name[i]);
            atnd.setStudentsId(student_id[i]);
            atnd.setFacultyName(faculty_name[i]);
            atnd.setCoursesName(courses_name[i]);
            atnd.setCourseCode(coursesCode_name[i]);
            atnd.setBatchName(batch_name[i]);
            atnd.setDepartmentName("Finance & Banking");
            atnd.setProfessorName(professor_name[i]);
            attandanceRepository.save(atnd);

        }
        return new ModelAndView("redirect:/showAttendance");
    }

}
