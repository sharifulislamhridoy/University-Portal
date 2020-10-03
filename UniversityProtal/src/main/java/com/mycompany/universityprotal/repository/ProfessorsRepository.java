/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Professors;
import com.mycompany.universityprotal.model.Students;
import com.mycompany.universityprotal.service.I_ProfessorsService;
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
public class ProfessorsRepository implements I_ProfessorsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Professors save(Professors professors) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(professors);
        t.commit();
        s.close();
        return professors;
    }

    @Override
    public List<Professors> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Professors> professors = s.createQuery("from Professors").list();
        t.commit();
        s.close();
        return professors;
    }

    @Override
    public void update(Professors professors) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(professors);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Professors professors = (Professors) s.get(Professors.class, id);
        s.delete(professors);
        t.commit();
        s.close();
    }
        public List<Professors> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Professors> courses = s.createQuery("FROM Professors WHERE  name='"+name+"'").list();
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public Professors getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Professors professors = (Professors) s.get(Professors.class, id);
        t.commit();
        s.close();
        return professors;
    }

}
