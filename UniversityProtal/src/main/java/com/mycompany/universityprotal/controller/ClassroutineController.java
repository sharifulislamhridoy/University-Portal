/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Classroutine;
import com.mycompany.universityprotal.repository.ClassroutineRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_ClassroutineController;
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
public class ClassroutineController implements I_ClassroutineController{
    
    @Autowired
    ClassroutineRepository classroutineRepository;
    
    
    @Override
    public Classroutine create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/classroutine")
    public Classroutine save(@RequestBody Classroutine classroutine) {
        return classroutineRepository.save(classroutine);
    }

    @Override
    public ResponseEntity<Classroutine> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/classroutine/{id}")
    public ResponseEntity<Classroutine> update(@PathVariable("id") Integer id, @RequestBody Classroutine classroutine) {
        Classroutine courentClassroutine = classroutineRepository.getById(id);
        if (courentClassroutine == null) {
            return new ResponseEntity<Classroutine>(HttpStatus.NOT_FOUND);
        }
        courentClassroutine.setRoutineid(classroutine.getRoutineid());
        courentClassroutine.setBatchid(classroutine.getBatchid());
        courentClassroutine.setDay(classroutine.getDay());
        courentClassroutine.setCourseid(classroutine.getCourseid());
        courentClassroutine.setTeacherid(classroutine.getTeacherid());
        courentClassroutine.setTime(classroutine.getTime());
  

        classroutineRepository.update(courentClassroutine);
        return new ResponseEntity<Classroutine>(courentClassroutine, HttpStatus.OK);
    }

    @Override
    @GetMapping("/classroutine")
    public List<Classroutine> getAll() {
        return classroutineRepository.viewAll();
    }

    @Override
    @DeleteMapping("/classroutine/{id}")
    public ResponseEntity<Classroutine> delete(@PathVariable("id") Integer id) {
        Classroutine classroutine = classroutineRepository.getById(id);
        if (classroutine == null) {
            return new ResponseEntity<Classroutine>(HttpStatus.NOT_FOUND);
        }
        classroutineRepository.delete(id);
        return new ResponseEntity<Classroutine>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/classroutine/{id}")
    public ResponseEntity<Classroutine> getById(@PathVariable("id") Integer id) {
        Classroutine classroutine = classroutineRepository.getById(id);
        if (classroutine == null) {
            return new ResponseEntity<Classroutine>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Classroutine>(classroutine, HttpStatus.OK);
        }

    }
    
}
