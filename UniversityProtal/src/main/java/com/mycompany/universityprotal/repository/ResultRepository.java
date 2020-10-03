/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Result;
import com.mycompany.universityprotal.service.I_ResultService;
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
public class ResultRepository implements I_ResultService{
    
    
     @Autowired
    SessionFactory sessionFactory;
    

   @Override
    public Result save(Result result) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(result);
        t.commit();
        s.close();
        return result;
    }

    @Override
    public List<Result> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Result> result = s.createQuery("from Result").list();
        t.commit();
        s.close();
        return result;
    }
    

    @Override
    public void update(Result result) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(result);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Result result = (Result) s.get(Result.class, id);
        s.delete(result);
        t.commit();
        s.close();
    }

    @Override
    public Result getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Result result = (Result) s.get(Result.class, id);
        t.commit();
        s.close();
        return result;
    }
     public List<Result> selectByStudentId(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Result> result = s.createQuery("FROM Result WHERE  studentsId='"+name+"'").list();
        t.commit();
        s.close();
        return result;
    }
    
    
}
