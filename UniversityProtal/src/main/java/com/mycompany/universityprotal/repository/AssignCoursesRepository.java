/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Assigncourses;
import com.mycompany.universityprotal.service.I_AssignCoursesService;
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
public class AssignCoursesRepository implements I_AssignCoursesService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Assigncourses save(Assigncourses assigncourses) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(assigncourses);
        t.commit();
        s.close();
        return assigncourses;
    }

    public List<Assigncourses> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Assigncourses> courses = s.createQuery("FROM Assigncourses WHERE  coursesName='" + name + "'").list();
        t.commit();
        s.close();
        return courses;
    }

    public List<Assigncourses> selectByCourseId(String id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Assigncourses> courses = s.createQuery("FROM Assigncourses WHERE  studentsId='" + id + "'").list();
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public List<Assigncourses> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Assigncourses> assigncourses = s.createQuery("from Assigncourses").list();
        t.commit();
        s.close();
        return assigncourses;
    }

    @Override
    public void update(Assigncourses assigncourses) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(assigncourses);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Assigncourses assigncourses = (Assigncourses) s.get(Assigncourses.class, id);
        s.delete(assigncourses);
        t.commit();
        s.close();
    }

    @Override
    public Assigncourses getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Assigncourses assigncourses = (Assigncourses) s.get(Assigncourses.class, id);
        t.commit();
        s.close();
        return assigncourses;
    }
}
