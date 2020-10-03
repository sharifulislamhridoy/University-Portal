/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Faculty;
import com.mycompany.universityprotal.service.I_FacultyService;
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
public class FacultyRepository implements I_FacultyService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Faculty save(Faculty faculty) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(faculty);
        t.commit();
        s.close();
        return faculty;
    }

    @Override
    public List<Faculty> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Faculty> faculty = s.createQuery("from Faculty").list();
        t.commit();
        s.close();
        return faculty;
    }

    @Override
    public void update(Faculty faculty) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(faculty);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Faculty faculty = (Faculty) s.get(Faculty.class, id);
        s.delete(faculty);
        t.commit();
        s.close();
    }

    @Override
    public Faculty getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Faculty faculty = (Faculty) s.get(Faculty.class, id);
        t.commit();
        s.close();
        return faculty;
    }

}
