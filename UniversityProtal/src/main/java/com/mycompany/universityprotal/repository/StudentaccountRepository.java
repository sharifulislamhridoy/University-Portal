/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Studentaccount;
import com.mycompany.universityprotal.service.I_StudentaccountService;
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
public class StudentaccountRepository implements I_StudentaccountService{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Studentaccount save(Studentaccount studentaccount) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(studentaccount);
        t.commit();
        s.close();
        return studentaccount;
    }

    @Override
    public List<Studentaccount> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Studentaccount> categoryList = s.createQuery("from Studentaccount").list();
        t.commit();
        s.close();
        return categoryList;
    }
    
     public List<Studentaccount> selectByCourseId(String id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Studentaccount> courses = s.createQuery("FROM Studentaccount WHERE  studentsId='" + id + "'").list();
        t.commit();
        s.close();
        return courses;
    }
          public List<Studentaccount> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Studentaccount> courses = s.createQuery("FROM Studentaccount WHERE  coursesName='" + name + "'").list();
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public void update(Studentaccount studentaccount) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(studentaccount);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Studentaccount cm = (Studentaccount) s.get(Studentaccount.class, id);
        s.delete(cm);
        t.commit();
        s.close();
    }

    @Override
    public Studentaccount getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Studentaccount cm = (Studentaccount) s.get(Studentaccount.class, id);
        t.commit();
        s.close();
        return cm;
    }
    
}
