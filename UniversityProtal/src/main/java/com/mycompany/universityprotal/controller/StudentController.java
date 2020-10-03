/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.repository.StudentsRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_StudentsController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
 * @author shariful islam
 */
@RestController
@RequestMapping(value = "/api/s1")
public class StudentController implements I_StudentsController {

    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public Students create() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/students")
    public Students save(@RequestBody Students request) {
        return studentsRepository.save(request);
    }

    @Override
    public ResponseEntity<Students> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GetMapping("/students")
    public List<Students> getAll() {
        return studentsRepository.viewAll();
    }

    @Override
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Students> delete(@PathVariable("id") Integer id) {
        Students category = studentsRepository.getById(id);

        if (category == null) {
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }
        studentsRepository.delete(id);
        return new ResponseEntity<Students>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/students/{id}")
    public ResponseEntity<Students> getById(@PathVariable("id") Integer id) {
        Students students = studentsRepository.getById(id);
        if (students == null) {
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Students>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/students/getByName/{id}")
    public List<Students> getAllByname(@PathVariable("id") String id) {
        return studentsRepository.selectByStudentId(id);
    }

    @Override
    @PutMapping("/students/{id}")
    public ResponseEntity<Students> update(@PathVariable("id") Integer id, @RequestBody Students t) {
        Students currentStudents = studentsRepository.getById(id);
        if (currentStudents == null) {
            return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
        }
        currentStudents.setStudentsId(t.getStudentsId());
        currentStudents.setName(t.getName());
        currentStudents.setEmail(t.getEmail());
        currentStudents.setPassword(t.getPassword());
        currentStudents.setGender(t.getGender());
        currentStudents.setPhone(t.getPhone());
        currentStudents.setBirthDate(t.getBirthDate());
        currentStudents.setAddress(t.getAddress());
        currentStudents.setDepartment(t.getDepartment());
        currentStudents.setRegistrationDate(t.getRegistrationDate());
        currentStudents.setImgUrl(t.getImgUrl());

        studentsRepository.update(currentStudents);
        return new ResponseEntity<Students>(currentStudents, HttpStatus.OK);
    }

}
