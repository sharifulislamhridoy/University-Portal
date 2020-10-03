/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Semester;
import com.mycompany.universityprotal.repository.SemesterRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_SemesterController;
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
@RequestMapping(value = "/api/s1")
public class SemesterController implements I_SemesterController {

    @Autowired
    SemesterRepository semesterRepository;

    @Override
    public Semester create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/semester")
    public Semester save(@RequestBody Semester t) {
        return semesterRepository.save(t);
    }

    @Override
    public ResponseEntity<Semester> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/semester/{id}")
    public ResponseEntity<Semester> update(@PathVariable("id") Integer id, @RequestBody Semester t) {
        Semester currentSemester = semesterRepository.getById(id);
        if (currentSemester == null) {
            return new ResponseEntity<Semester>(HttpStatus.NOT_FOUND);
        }//semesterId, semesterName, batchName, facultyName, departmentName
        currentSemester.setSemesterId(t.getSemesterId());
        currentSemester.setSemesterName(t.getSemesterName());
        currentSemester.setBatchName(t.getBatchName());
        currentSemester.setDepartmentName(t.getDepartmentName());
        currentSemester.setFacultyName(t.getDepartmentName());

        semesterRepository.update(currentSemester);
        return new ResponseEntity<Semester>(currentSemester, HttpStatus.OK);
    }

    @Override
    @GetMapping("/semester")
    public List<Semester> getAll() {
        return semesterRepository.viewAll();
    }

    @Override
    @DeleteMapping("/semester/{id}")
    public ResponseEntity<Semester> delete(@PathVariable("id") Integer id) {
        Semester category = semesterRepository.getById(id);

        if (category == null) {
            return new ResponseEntity<Semester>(HttpStatus.NOT_FOUND);
        }
        semesterRepository.delete(id);
        return new ResponseEntity<Semester>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/semester/{id}")
    public ResponseEntity<Semester> getById(@PathVariable("id") Integer id) {
        Semester semester = semesterRepository.getById(id);
        if (semester == null) {
            return new ResponseEntity<Semester>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Semester>(semester, HttpStatus.OK);
        }
    }
}
