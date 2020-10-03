/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Attandance;
import com.mycompany.universityprotal.service.I_AttandanceService;
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
public class AttandanceRepository implements I_AttandanceService{
    
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Attandance save(Attandance attandance) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(attandance);
        t.commit();
        s.close();
        return attandance;
    }

    @Override
    public List<Attandance> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Attandance> attandance = s.createQuery("from Attandance").list();
        t.commit();
        s.close();
        return attandance;
    }
    
    public List<Attandance> selectByStudentId(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Attandance> attandance = s.createQuery("FROM Attandance WHERE  studentsId='"+name+"'").list();
        t.commit();
        s.close();
        return attandance;
    }

    @Override
    public void update(Attandance attandance) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(attandance);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Attandance attandance = (Attandance) s.get(Attandance.class, id);
        s.delete(attandance);
        t.commit();
        s.close();
    }

    @Override
    public Attandance getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Attandance attandance = (Attandance) s.get(Attandance.class, id);
        t.commit();
        s.close();
        return attandance;
    }
     public Attandance getByName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Attandance attandance = (Attandance) s.get(Attandance.class, name);
        t.commit();
        s.close();
        return attandance;
    }
    
}
