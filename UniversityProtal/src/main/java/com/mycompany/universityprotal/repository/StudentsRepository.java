/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.service.I_StudentsService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

/**
 *
 * @author shariful islam
 */
@Repository
public class StudentsRepository implements I_StudentsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Students save(Students student) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(student);
        t.commit();
        s.close();
        return student;
    }

    @Override
    public List<Students> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Students> categoryList = s.createQuery("from Students").list();
        t.commit();
        s.close();
        return categoryList;
    }
 
     public List<Students> selectByStudentId(String id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Students> student = s.createQuery("FROM Students WHERE  studentsId='"+id+"'").list();
        t.commit();
        s.close();
        return student;
    }


    @Override
    public void update(Students student) {
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
        Students cm = (Students) s.get(Students.class, id);
        s.delete(cm);
        t.commit();
        s.close();
    }

    @Override
    public Students getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Students cm = (Students) s.get(Students.class, id);
        t.commit();
        s.close();
        return cm;
    }
}
