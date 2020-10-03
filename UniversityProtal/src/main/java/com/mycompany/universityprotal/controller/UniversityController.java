/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.University;
import com.mycompany.universityprotal.repository.UniversityRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_UniversityController;
import com.mycompany.universityprotal.web.ControllerImpliment.I_UsersController;
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
public class UniversityController implements I_UniversityController{
  
    @Autowired
    UniversityRepository universityRepository;
    
    
    @Override
    public University create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/university")
    public University save(@RequestBody University university) {
        return universityRepository.save(university);
    }

    @Override
    public ResponseEntity<University> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/university/{id}")
    public ResponseEntity<University> update(@PathVariable("id") Integer id, @RequestBody University university) {
        University courentUniversity = universityRepository.getById(id);
        if (courentUniversity == null) {
            return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
        }//university_id, u_name, u_address, u_phone, u_logo
        courentUniversity.setUniversity_id(university.getUniversity_id());
        courentUniversity.setU_name(university.getU_name());
        courentUniversity.setU_address(university.getU_address());
        courentUniversity.setU_phone(university.getU_address());
        courentUniversity.setU_logo(university.getU_logo());
      
        

        universityRepository.update(courentUniversity);
        return new ResponseEntity<University>(courentUniversity, HttpStatus.OK);
    }

    @Override
    @GetMapping("/university")
    public List<University> getAll() {
        return universityRepository.viewAll();
    }

    @Override
    @DeleteMapping("/university/{id}")
    public ResponseEntity<University> delete(@PathVariable("id") Integer id) {
        University university = universityRepository.getById(id);
        if (university == null) {
            return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
        }
        universityRepository.delete(id);
        return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/university/{id}")
    public ResponseEntity<University> getById(@PathVariable("id") Integer id) {
        University university = universityRepository.getById(id);
        if (university == null) {
            return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<University>(university, HttpStatus.OK);
        }

    }

}
