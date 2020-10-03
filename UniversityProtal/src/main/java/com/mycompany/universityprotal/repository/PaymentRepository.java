/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Payment;
import com.mycompany.universityprotal.service.I_PaymentService;
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
public class PaymentRepository implements I_PaymentService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Payment save(Payment ppayment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(ppayment);
        t.commit();
        s.close();
        return ppayment;
    }

    @Override
    public List<Payment> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> ppayment = s.createQuery("from Payment").list();
        t.commit();
        s.close();
        return ppayment;
    }

    @Override
    public void update(Payment ppayment) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(ppayment);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment ppayment = (Payment) s.get(Payment.class, id);
        s.delete(ppayment);
        t.commit();
        s.close();
    }

    public List<Payment> selectByCourseName(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> courses = s.createQuery("FROM Payment WHERE  name='" + name + "'").list();
        t.commit();
        s.close();
        return courses;
    }

    public List<Payment> selectByStudentId(String name) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Payment> courses = s.createQuery("FROM Payment WHERE  studentsId='" + name + "'").list();
        t.commit();
        s.close();
        return courses;
    }

    @Override
    public Payment getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Payment ppayment = (Payment) s.get(Payment.class, id);
        t.commit();
        s.close();
        return ppayment;
    }

}
