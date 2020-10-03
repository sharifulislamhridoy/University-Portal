/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Semester;
import com.mycompany.universityprotal.service.I_SemesterService;
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
public class SemesterRepository implements I_SemesterService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Semester save(Semester student) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(student);
        t.commit();
        s.close();
        return student;
    }

    @Override
    public List<Semester> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Semester> categoryList = s.createQuery("from Semester").list();
        t.commit();
        s.close();
        return categoryList;
    }

    @Override
    public void update(Semester student) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(student);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Semester cm = (Semester) s.get(Semester.class, id);
        s.delete(cm);
        t.commit();
        s.close();
    }

    @Override
    public Semester getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Semester cm = (Semester) s.get(Semester.class, id);
        t.commit();
        s.close();
        return cm;
    }
    
}
