/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Faculty;
import com.mycompany.universityprotal.repository.FacultyRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_Faculty_Controller;
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
public class FacultyController implements I_Faculty_Controller{
    @Autowired
    FacultyRepository facultyRepository;
    
    
    @Override
    public Faculty create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/faculty")
    public Faculty save(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public ResponseEntity<Faculty> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/faculty/{id}")
    public ResponseEntity<Faculty> update(@PathVariable("id") Integer id, @RequestBody Faculty faculty) {
        Faculty courentFaculty = facultyRepository.getById(id);
        if (courentFaculty == null) {
            return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
        }
        courentFaculty.setFact_id(faculty.getFact_id());
        courentFaculty.setFacultyName(faculty.getFacultyName());
     

        facultyRepository.update(courentFaculty);
        return new ResponseEntity<Faculty>(courentFaculty, HttpStatus.OK);
    }

    @Override
    @GetMapping("/faculty")
    public List<Faculty> getAll() {
        return facultyRepository.viewAll();
    }

    @Override
    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<Faculty> delete(@PathVariable("id") Integer id) {
        Faculty faculty = facultyRepository.getById(id);
        if (faculty == null) {
            return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
        }
        facultyRepository.delete(id);
        return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/faculty/{id}")
    public ResponseEntity<Faculty> getById(@PathVariable("id")Integer id) {
        Faculty faculty = facultyRepository.getById(id);
        if (faculty == null) {
            return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
        }

    }
    
}
