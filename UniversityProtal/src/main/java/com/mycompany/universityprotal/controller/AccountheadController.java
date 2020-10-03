/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Accounthead;
import com.mycompany.universityprotal.repository.AccountheadRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_AccountheadController;
import java.util.List;
import static javafx.scene.input.KeyCode.I;
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
public class AccountheadController implements I_AccountheadController{
    
    @Autowired
    AccountheadRepository accountheadRepository;
    
      @Override
    public Accounthead create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/accounthead")
    public Accounthead save(@RequestBody Accounthead accounthead) {
        return accountheadRepository.save(accounthead);
    }

    @Override
    public ResponseEntity<Accounthead> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/accounthead/{id}")
    public ResponseEntity<Accounthead> update(@PathVariable("id") Integer id, @RequestBody Accounthead accounthead) {
        Accounthead courentAccounthead = accountheadRepository.getById(id);
        if (courentAccounthead == null) {
            return new ResponseEntity<Accounthead>(HttpStatus.NOT_FOUND);
        }
        courentAccounthead.setCode(accounthead.getCode());
        courentAccounthead.setHeadName(accounthead.getHeadName());
        courentAccounthead.setPurpose(accounthead.getPurpose());
        courentAccounthead.setType(accounthead.getType());
        courentAccounthead.setBaseFee(accounthead.getBaseFee());
        courentAccounthead.seteLStatus(accounthead.geteLStatus());

        accountheadRepository.update(courentAccounthead);
        return new ResponseEntity<Accounthead>(courentAccounthead, HttpStatus.OK);
    }

    @Override
    @GetMapping("/accounthead")
    public List<Accounthead> getAll() {
        return accountheadRepository.viewAll();
    }
    
 
//    @GetMapping("/accounthead/getByName/{name}")
//    public List<Accounthead> getAllByname(@PathVariable("name") String name) {
//        return accountheadRepository.selectByCourseName(name);
//    }

    @Override
    @DeleteMapping("/accounthead/{id}")
    public ResponseEntity<Accounthead> delete(@PathVariable("id") Integer id) {
        Accounthead accounthead = accountheadRepository.getById(id);
        if (accounthead == null) {
            return new ResponseEntity<Accounthead>(HttpStatus.NOT_FOUND);
        }
        accountheadRepository.delete(id);
        return new ResponseEntity<Accounthead>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/accounthead/{id}")
    public ResponseEntity<Accounthead> getById(@PathVariable("id") Integer id) {
        Accounthead accounthead = accountheadRepository.getById(id);
        if (accounthead == null) {
            return new ResponseEntity<Accounthead>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Accounthead>(accounthead, HttpStatus.OK);
        }

    }
   
//    @GetMapping("/accounthead/getAccountheadName/{name}")
//    public ResponseEntity<Accounthead> getByCourseName(@PathVariable("name") String name) {
//        List<Accounthead> accounthead = accountheadRepository.selectByCourseName(name);
//        if (accounthead == null) {
//            return new ResponseEntity<Accounthead>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<Accounthead>((Accounthead) accounthead, HttpStatus.OK);
//        }
//
//    }
    
    
}
