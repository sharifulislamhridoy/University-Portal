/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Batch;
import com.mycompany.universityprotal.service.I_BatchService;
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
public class BatchRepository implements I_BatchService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Batch save(Batch batch) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(batch);
        t.commit();
        s.close();
        return batch;
    }

    @Override
    public List<Batch> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Batch> batch = s.createQuery("from Batch").list();
        t.commit();
        s.close();
        return batch;
    }

    @Override
    public void update(Batch batch) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(batch);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Batch batch = (Batch) s.get(Batch.class, id);
        s.delete(batch);
        t.commit();
        s.close();
    }

    @Override
    public Batch getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Batch batch = (Batch) s.get(Batch.class, id);
        t.commit();
        s.close();
        return batch;
    }
}
