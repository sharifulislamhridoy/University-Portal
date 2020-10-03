/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.University;
import com.mycompany.universityprotal.service.I_ClassroutineService;
import com.mycompany.universityprotal.service.I_UniversityService;
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
public class UniversityRepository implements I_UniversityService{
    
    @Autowired
    SessionFactory sessionFactory;
    

   @Override
    public University save(University university) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(university);
        t.commit();
        s.close();
        return university;
    }

    @Override
    public List<University> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<University> university = s.createQuery("from University").list();
        t.commit();
        s.close();
        return university;
    }

    @Override
    public void update(University university) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(university);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        University university = (University) s.get(University.class, id);
        s.delete(university);
        t.commit();
        s.close();
    }

    @Override
    public University getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        University university = (University) s.get(University.class, id);
        t.commit();
        s.close();
        return university;
    }
    
    
    
}
