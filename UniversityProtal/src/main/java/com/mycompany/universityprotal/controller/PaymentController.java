/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Payment;
import com.mycompany.universityprotal.repository.PaymentRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_PaymentController;
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
public class PaymentController implements I_PaymentController{
    @Autowired
   PaymentRepository  paymentRepository;
   
    @Override
     @PostMapping("/payment")
    public Payment save(@RequestBody Payment t) {
      return paymentRepository.save(t);
    }

    @Override
    public ResponseEntity<Payment> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/payment/{id}")
    public ResponseEntity<Payment> update(@PathVariable("id") Integer id,@RequestBody  Payment t) {
     Payment courentDepartment = paymentRepository.getById(id);
        if (courentDepartment == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }
        courentDepartment.setId(courentDepartment.getId());
        courentDepartment.setFacultyName(courentDepartment.getFacultyName());
        courentDepartment.setDepartmentName(courentDepartment.getDepartmentName());
        courentDepartment.setBatchName(courentDepartment.getBatchName());
        courentDepartment.setSemesterName(courentDepartment.getSemesterName());
        courentDepartment.setStudentsId(courentDepartment.getStudentsId());
        courentDepartment.setName(courentDepartment.getName());
        courentDepartment.setHeadName(courentDepartment.getHeadName());
        courentDepartment.setPurpose(courentDepartment.getPurpose());
        courentDepartment.setType(courentDepartment.getType());
        courentDepartment.setBasefee(courentDepartment.getBasefee());
        courentDepartment.setMethod(courentDepartment.getMethod());
        courentDepartment.setDatePayment(courentDepartment.getDatePayment());
        courentDepartment.setAcINfo(courentDepartment.getAcINfo());
        courentDepartment.setPass(courentDepartment.getPass());
    

        paymentRepository.update(courentDepartment);
        return new ResponseEntity<Payment>(courentDepartment, HttpStatus.OK);
    }

    
    
    @Override
    @GetMapping("/payment")
    public List<Payment> getAll() {
        return paymentRepository.viewAll();
    }
      
    
    @GetMapping("/payment/getByName/{name}")
    public List<Payment> getAllByname(@PathVariable("name") String name) {
        return paymentRepository.selectByCourseName(name);
    }
     @GetMapping("/payment/getById/{name}")
    public List<Payment> getAllById(@PathVariable("name") String name) {
        return paymentRepository.selectByStudentId(name);
    }


   @Override
    @DeleteMapping("/payment/{dep_Id}")
    public ResponseEntity<Payment> delete(@PathVariable("dep_Id") Integer id) {
        Payment department = paymentRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        }paymentRepository.delete(id);
        return new ResponseEntity<Payment>(HttpStatus.NO_CONTENT);
    }

      @Override
    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getById(@PathVariable("id") Integer id) {
        Payment department = paymentRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Payment>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Payment>(department, HttpStatus.OK);
        }

    }

    @Override
    public Payment create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
