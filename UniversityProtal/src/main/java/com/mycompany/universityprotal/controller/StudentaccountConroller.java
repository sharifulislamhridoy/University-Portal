/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.repository.StudentaccountRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_StudentccountController;
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
public class StudentaccountConroller implements I_StudentccountController{
    
    @Autowired
    StudentaccountRepository studentaccountRepository;
    
    @Override
    public Studentaccount create() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping("/studentaccount")
    public Studentaccount saveWithImage(@RequestBody Studentaccount professors) {
        
        return studentaccountRepository.save(professors);
    }

    @Override
    public ResponseEntity<Studentaccount> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GetMapping("/studentaccount")
    public List<Studentaccount> getAll() {
        return studentaccountRepository.viewAll();
    }

    @Override
    @DeleteMapping("/studentaccount/{id}")
    public ResponseEntity<Studentaccount> delete(@PathVariable("id") Integer id) {
        Studentaccount professors = studentaccountRepository.getById(id);

        if (professors == null) {
            return new ResponseEntity<Studentaccount>(HttpStatus.NOT_FOUND);
        }
        studentaccountRepository.delete(id);
        return new ResponseEntity<Studentaccount>(HttpStatus.NO_CONTENT);
    }
    
      @GetMapping("/studentaccount/getById/{id}")
    public List<Studentaccount> getAllByid(@PathVariable("id") String id) {
        return studentaccountRepository.selectByCourseId(id);
    }

    @Override
    @GetMapping("/studentaccount/{id}")
    public ResponseEntity<Studentaccount> getById(@PathVariable("id") Integer id) {
        Studentaccount professor = studentaccountRepository.getById(id);
        if (professor == null) {
            return new ResponseEntity<Studentaccount>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Studentaccount>(professor, HttpStatus.OK);
        }
    }
    


    @Override
    @PutMapping("/studentaccount/{id}")
    public ResponseEntity<Studentaccount> update(@PathVariable("id") Integer id, @RequestBody Studentaccount professors) {
        Studentaccount currentStudentaccount = studentaccountRepository.getById(id);
        if (currentStudentaccount == null) {
            return new ResponseEntity<Studentaccount>(HttpStatus.NOT_FOUND);
        }
        currentStudentaccount.setId(professors.getId());
        currentStudentaccount.setStudentsId(professors.getStudentsId());
        currentStudentaccount.setName(professors.getName());
        currentStudentaccount.setFacultyName(professors.getFacultyName());
        currentStudentaccount.setDepartmentName(professors.getDepartmentName());
        currentStudentaccount.setBatchName(professors.getBatchName());
        currentStudentaccount.setSemesterName(professors.getSemesterName());
        currentStudentaccount.setCoursesName(professors.getCoursesName());
        currentStudentaccount.setCourseCode(professors.getCourseCode());
        currentStudentaccount.setCourseCradit(professors.getCourseCradit());
        currentStudentaccount.setCoursePrice(professors.getCoursePrice());
        currentStudentaccount.setProfessorName(professors.getProfessorName());     
        studentaccountRepository.update(currentStudentaccount);
        return new ResponseEntity<Studentaccount>(currentStudentaccount, HttpStatus.OK);
    }

    @Override
    public Studentaccount save( Studentaccount t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
