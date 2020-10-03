/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Result;
import com.mycompany.universityprotal.repository.ResultRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_ResultController;
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
public class ResultControllerAngular implements I_ResultController{
    
       @Autowired
       ResultRepository resultRepository;
       
       
    @Override
    public Result create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/result")
    public Result save(@RequestBody Result t) {
        return resultRepository.save(t);
    }

    @Override
    public ResponseEntity<Result> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/result/{id}")
    public ResponseEntity<Result> update(@PathVariable("id") Integer id, @RequestBody Result t) {
        Result currentResult = resultRepository.getById(id);
        if (currentResult == null) {
            return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
        }//semesterId, semesterName, batchName, facultyName, departmentName
        currentResult.setId(t.getId());
        currentResult.setStudentsId(t.getStudentsId());
        currentResult.setName(t.getName());
        currentResult.setFacultyName(t.getFacultyName());
        currentResult.setDepartmentName(t.getDepartmentName());
        currentResult.setBatchName(t.getBatchName());
        currentResult.setCoursesName(t.getCoursesName());
        currentResult.setCourseCode(t.getCourseCode());
        currentResult.setClassTest(t.getClassTest());
        currentResult.setMidTerm(t.getMidTerm());
        currentResult.setFinalExm(t.getFinalExm());
        currentResult.setTotal(t.getTotal());
        currentResult.setGreatPoint(t.getGreatPoint());

        resultRepository.update(currentResult);
        return new ResponseEntity<Result>(currentResult, HttpStatus.OK);
    }

    @Override
    @GetMapping("/result")
    public List<Result> getAll() {
        return resultRepository.viewAll();
    }

    @Override
    @DeleteMapping("/result/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") Integer id) {
        Result category = resultRepository.getById(id);

        if (category == null) {
            return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
        }
        resultRepository.delete(id);
        return new ResponseEntity<Result>(HttpStatus.NO_CONTENT);
    }
    
        @GetMapping("/result/getById/{id}")
    public List<Result> getAllByid(@PathVariable("id") String id) {
        return resultRepository.selectByStudentId(id);
    }

    @Override
    @GetMapping("/result/{id}")
    public ResponseEntity<Result> getById(@PathVariable("id") Integer id) {
        Result semester = resultRepository.getById(id);
        if (semester == null) {
            return new ResponseEntity<Result>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Result>(semester, HttpStatus.OK);
        }
    }
}
