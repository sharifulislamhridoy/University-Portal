/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.controller;

import com.mycompany.universityprotal.model.Department;
import com.mycompany.universityprotal.repository.DepartmentRepository;
import com.mycompany.universityprotal.web.ControllerImpliment.I_DepartmentController;
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
public class DepartmentController implements I_DepartmentController{
  
    @Autowired
    DepartmentRepository departmentRepository;
    
    
    
    @Override
    public Department create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PostMapping("/department")
    public Department save(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public ResponseEntity<Department> edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @PutMapping("/department/{id}")
    public ResponseEntity<Department> update(@PathVariable("id") Integer id, @RequestBody Department department) {
        Department courentDepartment = departmentRepository.getById(id);
        if (courentDepartment == null) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }//dep_Id, departmentName, facultyName, status
        courentDepartment.setDep_Id(department.getDep_Id());
        courentDepartment.setDepartmentName(department.getDepartmentName());
        courentDepartment.setFacultyName(department.getFacultyName());
        courentDepartment.setStatus(department.getStatus());
    

        departmentRepository.update(courentDepartment);
        return new ResponseEntity<Department>(courentDepartment, HttpStatus.OK);
    }

    @Override
    @GetMapping("/department")
    public List<Department> getAll() {
        return departmentRepository.viewAll();
    }

    @Override
    @DeleteMapping("/department/{dep_Id}")
    public ResponseEntity<Department> delete(@PathVariable("dep_Id") Integer id) {
        Department department = departmentRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }
        departmentRepository.delete(id);
        return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);
    }
    
      @GetMapping("/department/getByName/{name}")
    public List<Department> getAllByname(@PathVariable("name") String name) {
        return departmentRepository.selectByCourseName(name);
    }

    @Override
    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getById(@PathVariable("id") Integer id) {
        Department department = departmentRepository.getById(id);
        if (department == null) {
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Department>(department, HttpStatus.OK);
        }

    }
    
}
