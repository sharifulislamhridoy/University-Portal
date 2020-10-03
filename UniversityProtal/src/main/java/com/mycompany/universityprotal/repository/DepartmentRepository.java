/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Department;
import com.mycompany.universityprotal.service.I_DepartmentService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author shari
 */

@Repository
public class DepartmentRepository  implements I_DepartmentService{
    
    
     @Autowired
    SessionFactory sessionFactory;

    @Override
    public Department save(Department department) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(department);
        t.commit();
        s.close();
        return department;
    }

    @Override
    public List<Department> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Department> department = s.createQuery("from Department").list();
        t.commit();
        s.close();
        return department;
    }

    
       public List<Department> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Department> courses = s.createQuery("SELECT departmentName FROM Department WHERE  facultyName='"+name+"'").list();
        t.commit();
        s.close();
        return courses;
    }
    
    @Override
    public void update(Department department) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(department);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Department department = (Department) s.get(Department.class, id);
        s.delete(department);
        t.commit();
        s.close();
    }

    @Override
    public Department getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Department department = (Department) s.get(Department.class, id);
        t.commit();
        s.close();
        return department;
    }
}
