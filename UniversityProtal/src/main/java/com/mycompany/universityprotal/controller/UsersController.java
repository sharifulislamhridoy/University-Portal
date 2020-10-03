/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.model.Users;
import com.mycompany.universityprotal.repository.UserRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_UsersController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shari
 */
@RestController
@RequestMapping(value = "/api/s1")
public class UsersController implements I_UsersController {

    @Autowired
    UserRepository usersReposetory;

    @Override
    public Users create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/users")
    public Users save(@RequestBody Users users) {
        return usersReposetory.save(users);
    }

    @Override
    public ResponseEntity<Users> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity<Users> update(Integer id, Users t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GetMapping("/users")
    public List<Users> getAll() {
        return usersReposetory.viewAll();
    }

    @Override
    public ResponseEntity<Users> delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
     @GetMapping("/users/{id}")
    public ResponseEntity<Users> getById(@PathVariable("id") Integer id) {
      Users students= usersReposetory.getById(id);
      if (students == null) {
            return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Users>(students, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Users> getEmailPassword(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
