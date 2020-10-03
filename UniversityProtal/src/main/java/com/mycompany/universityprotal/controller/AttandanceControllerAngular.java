/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Attandance;
import com.mycompany.universityprotal.repository.AttandanceRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_AttandanceController;
import java.util.Date;
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
public class AttandanceControllerAngular implements I_AttandanceController {

    @Autowired
    AttandanceRepository attandanceRepository;

    @Override
    public Attandance create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/attandance")
    public Attandance save(@RequestBody Attandance t) {
        return attandanceRepository.save(t);
    }

    @Override
    public ResponseEntity<Attandance> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/attandance/{id}")
    public ResponseEntity<Attandance> update(@PathVariable("id") Integer id, @RequestBody Attandance t) {
        Attandance currentAttandance = attandanceRepository.getById(id);
        if (currentAttandance == null) {
            return new ResponseEntity<Attandance>(HttpStatus.NOT_FOUND);
        }
        currentAttandance.setId(t.getId());
        currentAttandance.setStudentsId(t.getStudentsId());
        currentAttandance.setName(t.getName());
        currentAttandance.setFacultyName(t.getFacultyName());
        currentAttandance.setDepartmentName(t.getDepartmentName());
        currentAttandance.setBatchName(t.getBatchName());
        currentAttandance.setCoursesName(t.getCoursesName());
        currentAttandance.setCourseCode(t.getCourseCode());
        currentAttandance.setProfessorName(t.getProfessorName());
        currentAttandance.setStarus(t.getStarus());

        attandanceRepository.update(currentAttandance);
        return new ResponseEntity<Attandance>(currentAttandance, HttpStatus.OK);
    }

    @Override
    @GetMapping("/attandance")
    public List<Attandance> getAll() {
        return attandanceRepository.viewAll();
    }

    @Override
    @DeleteMapping("/attandance/{id}")
    public ResponseEntity<Attandance> delete(@PathVariable("id") Integer id) {
        Attandance category = attandanceRepository.getById(id);

        if (category == null) {
            return new ResponseEntity<Attandance>(HttpStatus.NOT_FOUND);
        }
        attandanceRepository.delete(id);
        return new ResponseEntity<Attandance>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/attandance/getById/{id}")
    public List<Attandance> getAllById(@PathVariable("id") String id) {
        return attandanceRepository.selectByStudentId(id);
    }

    @Override
    @GetMapping("/attandance/{id}")
    public ResponseEntity<Attandance> getById(@PathVariable("id") Integer id) {
        Attandance semester = attandanceRepository.getById(id);
        if (semester == null) {
            return new ResponseEntity<Attandance>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Attandance>(semester, HttpStatus.OK);
        }
    }

}
