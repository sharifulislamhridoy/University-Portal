/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Classroutine;
import com.mycompany.universityprotal.service.I_ClassroutineService;
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
public class ClassroutineRepository implements I_ClassroutineService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Classroutine save(Classroutine routine) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(routine);
        t.commit();
        s.close();
        return routine;
    }

    @Override
    public List<Classroutine> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Classroutine> routine = s.createQuery("from Classroutine").list();
        t.commit();
        s.close();
        return routine;
    }

    @Override
    public void update(Classroutine routine) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(routine);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Classroutine routine = (Classroutine) s.get(Classroutine.class, id);
        s.delete(routine);
        t.commit();
        s.close();
    }

    @Override
    public Classroutine getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Classroutine routine = (Classroutine) s.get(Classroutine.class, id);
        t.commit();
        s.close();
        return routine;
    }
}
