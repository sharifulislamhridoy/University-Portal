/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Professors;
import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.repository.ProfessorsRepository;
import com.mycompany.universityprotal.repository.StudentsRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_ProfessorsController;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author shari
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ProfessorsController implements I_ProfessorsController {

    @Autowired
    ProfessorsRepository professorsRepository;

    @Override
    public Professors create() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping("/professors")
    public Professors saveWithImage(@RequestBody Professors professors) {
        
        return professorsRepository.save(professors);
    }

    @Override
    public ResponseEntity<Professors> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GetMapping("/professors")
    public List<Professors> getAll() {
        return professorsRepository.viewAll();
    }

    @Override
    @DeleteMapping("/professors/{id}")
    public ResponseEntity<Professors> delete(@PathVariable("id") Integer id) {
        Professors professors = professorsRepository.getById(id);

        if (professors == null) {
            return new ResponseEntity<Professors>(HttpStatus.NOT_FOUND);
        }
        professorsRepository.delete(id);
        return new ResponseEntity<Professors>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/professors/{id}")
    public ResponseEntity<Professors> getById(@PathVariable("id") Integer id) {
        Professors professor = professorsRepository.getById(id);
        if (professor == null) {
            return new ResponseEntity<Professors>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Professors>(professor, HttpStatus.OK);
        }
    }
    
     @GetMapping("/professors/getByName/{name}")
    public List<Professors> getAllByname(@PathVariable("name") String name) {
        return professorsRepository.selectByCourseName(name);
    }

    @Override
    @PutMapping("/professors/{id}")
    public ResponseEntity<Professors> update(@PathVariable("id") Integer id, @RequestBody Professors professors) {
        Professors currentProfessors = professorsRepository.getById(id);
        if (currentProfessors == null) {
            return new ResponseEntity<Professors>(HttpStatus.NOT_FOUND);
        }
        currentProfessors.setId(professors.getId());
        currentProfessors.setName(professors.getName());
        currentProfessors.setEmail(professors.getEmail());
        currentProfessors.setJoinDate(professors.getJoinDate());
        currentProfessors.setPassword(professors.getPassword());
        currentProfessors.setDesignation(professors.getDesignation());
        currentProfessors.setDepartment(professors.getDepartment());
        currentProfessors.setGender(professors.getGender());
        currentProfessors.setPhone(professors.getPhone());
        currentProfessors.setBirthDate(professors.getBirthDate());
        currentProfessors.setAddress(professors.getAddress());
        currentProfessors.setImgUrl(professors.getImgUrl());
        currentProfessors.setEducation(professors.getEducation());

        professorsRepository.update(currentProfessors);
        return new ResponseEntity<Professors>(currentProfessors, HttpStatus.OK);
    }

    @Override
    public Professors save(Professors t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
