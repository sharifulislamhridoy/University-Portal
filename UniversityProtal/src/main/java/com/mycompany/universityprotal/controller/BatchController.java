/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Batch;
import com.mycompany.universityprotal.repository.BatchRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_BatchController;
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
public class BatchController implements  I_BatchController{
    @Autowired
    BatchRepository batchRepository;
    
    
     @Override
    public Batch create() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping("/batch")
    public Batch saveWithImage(@RequestBody Batch batch) {
        
        return batchRepository.save(batch);
    }

    @Override
    public ResponseEntity<Batch> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @GetMapping("/batch")
    public List<Batch> getAll() {
        return batchRepository.viewAll();
    }

    @Override
    @DeleteMapping("/batch/{id}")
    public ResponseEntity<Batch> delete(@PathVariable("id") Integer id) {
        Batch batch = batchRepository.getById(id);

        if (batch == null) {
            return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
        }
        batchRepository.delete(id);
        return new ResponseEntity<Batch>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/batch/{id}")
    public ResponseEntity<Batch> getById(@PathVariable("id") Integer id) {
        Batch batch = batchRepository.getById(id);
        if (batch == null) {
            return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Batch>(batch, HttpStatus.OK);
        }
    }

    @Override
    @PutMapping("/batch/{id}")
    public ResponseEntity<Batch> update(@PathVariable("id") Integer id, @RequestBody Batch batch) {
        Batch currentBatch = batchRepository.getById(id);
        if (currentBatch == null) {
            return new ResponseEntity<Batch>(HttpStatus.NOT_FOUND);
        }
        currentBatch.setBatchId(batch.getBatchId());
        currentBatch.setBatchName(batch.getBatchName());
        currentBatch.setFacultyName(batch.getFacultyName());
        currentBatch.setDepartmentName(batch.getDepartmentName());
        currentBatch.setStatus(batch.getStatus());
    
        batchRepository.update(currentBatch);
        return new ResponseEntity<Batch>(currentBatch, HttpStatus.OK);
    }

    @Override
    public Batch save(Batch t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
