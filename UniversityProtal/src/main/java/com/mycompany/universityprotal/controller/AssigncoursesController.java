/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Assigncourses;
import com.mycompany.universityprotal.repository.AssignCoursesRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_AssignCoursesController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shari
 */
@RestController
@RequestMapping(value = "/api/v1")
public class AssigncoursesController implements I_AssignCoursesController{
   
    @Autowired
    AssignCoursesRepository  assignCoursesRepository;
    
  
    

    @Override
     @PostMapping("/assigncourses")
    public Assigncourses save(@RequestBody Assigncourses t) {
      return assignCoursesRepository.save(t);
    }

    @Override
    public ResponseEntity<Assigncourses> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/assigncourses/{id}")
    public ResponseEntity<Assigncourses> update(@PathVariable("id") Integer id,@RequestBody  Assigncourses t) {
     Assigncourses courentDepartment = assignCoursesRepository.getById(id);
        if (courentDepartment == null) {
            return new ResponseEntity<Assigncourses>(HttpStatus.NOT_FOUND);
        }//dep_Id, departmentName, facultyName, status
        courentDepartment.setAssignid(courentDepartment.getAssignid());
        courentDepartment.setFacultyName(courentDepartment.getFacultyName());
        courentDepartment.setDepartmentName(courentDepartment.getDepartmentName());
        courentDepartment.setBatchName(courentDepartment.getBatchName());
        courentDepartment.setSemesterName(courentDepartment.getSemesterName());
        courentDepartment.setCoursesName(courentDepartment.getCoursesName());
        courentDepartment.setCourseCode(courentDepartment.getCourseCode());
        courentDepartment.setCourseCradit(courentDepartment.getCourseCradit());
        courentDepartment.setCoursePrice(courentDepartment.getCoursePrice());
        courentDepartment.setProfessorName(courentDepartment.getProfessorName());
        courentDepartment.setEmail(courentDepartment.getEmail());
        courentDepartment.setDesignation(courentDepartment.getDesignation());
        courentDepartment.setPhone(courentDepartment.getPhone());
    

        assignCoursesRepository.update(courentDepartment);
        return new ResponseEntity<Assigncourses>(courentDepartment, HttpStatus.OK);
    }

    @Override
    @GetMapping("/assigncourses")
    public List<Assigncourses> getAll() {
        return assignCoursesRepository.viewAll();
    }
      @GetMapping("/assigncourses/getByName/{name}")
    public List<Assigncourses> getAllByname(@PathVariable("name") String name) {
        return assignCoursesRepository.selectByCourseName(name);
    }
      @GetMapping("/assigncourses/getById/{id}")
    public List<Assigncourses> getAllByid(@PathVariable("id") String id) {
        return assignCoursesRepository.selectByCourseId(id);
    }

   @Override
    @DeleteMapping("/assigncourses/{dep_Id}")
    public ResponseEntity<Assigncourses> delete(@PathVariable("dep_Id") Integer id) {
        Assigncourses department = assignCoursesRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Assigncourses>(HttpStatus.NOT_FOUND);
        }assignCoursesRepository.delete(id);
        return new ResponseEntity<Assigncourses>(HttpStatus.NO_CONTENT);
    }

      @Override
    @GetMapping("/assigncourses/{id}")
    public ResponseEntity<Assigncourses> getById(@PathVariable("id") Integer id) {
        Assigncourses department = assignCoursesRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Assigncourses>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Assigncourses>(department, HttpStatus.OK);
        }

    }

    @Override
    public Assigncourses create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
