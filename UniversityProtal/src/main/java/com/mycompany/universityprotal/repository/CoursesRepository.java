/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Courses;
import com.mycompany.universityprotal.model.Professors;
import com.mycompany.universityprotal.service.I_CoursesService;
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
public class CoursesRepository implements I_CoursesService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Courses save(Courses courses) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(courses);
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public List<Courses> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Courses> courses = s.createQuery("from Courses").list();
        t.commit();
        s.close();
        return courses;
    }
    
    public List<Courses> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Courses> courses = s.createQuery("FROM Courses WHERE  coursesName='"+name+"'").list();
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public void update(Courses courses) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(courses);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Courses courses = (Courses) s.get(Courses.class, id);
        s.delete(courses);
        t.commit();
        s.close();
    }

    @Override
    public Courses getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Courses courses = (Courses) s.get(Courses.class, id);
        t.commit();
        s.close();
        return courses;
    }
     public Courses getByName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Courses courses = (Courses) s.get(Courses.class, name);
        t.commit();
        s.close();
        return courses;
    }
    
    
}
