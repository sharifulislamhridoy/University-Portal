/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Accounthead;
import com.mycompany.universityprotal.service.I_AccountheadService;
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
public class AccountheadRepository implements I_AccountheadService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Accounthead save(Accounthead routine) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(routine);
        t.commit();
        s.close();
        return routine;
    }

    @Override
    public List<Accounthead> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Accounthead> routine = s.createQuery("from Accounthead").list();
        t.commit();
        s.close();
        return routine;
    }

    @Override
    public void update(Accounthead routine) {
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
        Accounthead routine = (Accounthead) s.get(Accounthead.class, id);
        s.delete(routine);
        t.commit();
        s.close();
    }

    @Override
    public Accounthead getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Accounthead routine = (Accounthead) s.get(Accounthead.class, id);
        t.commit();
        s.close();
        return routine;
    }
}
