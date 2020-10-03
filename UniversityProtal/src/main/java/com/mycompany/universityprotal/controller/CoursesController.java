/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Courses;
import com.mycompany.universityprotal.repository.CoursesRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_CoursesController;
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
public class CoursesController implements I_CoursesController {

    @Autowired
    CoursesRepository coursesRepository;

    @Override
    public Courses create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/courses")
    public Courses save(@RequestBody Courses courses) {
        return coursesRepository.save(courses);
    }

    @Override
    public ResponseEntity<Courses> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/courses/{id}")
    public ResponseEntity<Courses> update(@PathVariable("id") Integer id, @RequestBody Courses courses) {
        Courses courentCourses = coursesRepository.getById(id);
        if (courentCourses == null) {
            return new ResponseEntity<Courses>(HttpStatus.NOT_FOUND);
        }
        courentCourses.setId(courses.getId());
        courentCourses.setCoursesName(courses.getCoursesName());
        courentCourses.setCourseCode(courses.getCourseCode());
        courentCourses.setCourseCradit(courses.getCourseCradit());
        courentCourses.setCoursePrice(courses.getCoursePrice());
        courentCourses.setSemesterName(courses.getSemesterName());
        courentCourses.setBatchName(courses.getBatchName());
        courentCourses.setDepartmentName(courses.getDepartmentName());
        courentCourses.setFacultyName(courses.getFacultyName());

        coursesRepository.update(courentCourses);
        return new ResponseEntity<Courses>(courentCourses, HttpStatus.OK);
    }

    @Override
    @GetMapping("/courses")
    public List<Courses> getAll() {
        return coursesRepository.viewAll();
    }
    
 
    @GetMapping("/courses/getByName/{name}")
    public List<Courses> getAllByname(@PathVariable("name") String name) {
        return coursesRepository.selectByCourseName(name);
    }

    @Override
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Courses> delete(@PathVariable("id") Integer id) {
        Courses courses = coursesRepository.getById(id);
        if (courses == null) {
            return new ResponseEntity<Courses>(HttpStatus.NOT_FOUND);
        }
        coursesRepository.delete(id);
        return new ResponseEntity<Courses>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/courses/{id}")
    public ResponseEntity<Courses> getById(@PathVariable("id") Integer id) {
        Courses courses = coursesRepository.getById(id);
        if (courses == null) {
            return new ResponseEntity<Courses>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Courses>(courses, HttpStatus.OK);
        }

    }
   
    @GetMapping("/courses/getCoursesName/{name}")
    public ResponseEntity<Courses> getByCourseName(@PathVariable("name") String name) {
        List<Courses> courses = coursesRepository.selectByCourseName(name);
        if (courses == null) {
            return new ResponseEntity<Courses>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Courses>((Courses) courses, HttpStatus.OK);
        }

    }

}
