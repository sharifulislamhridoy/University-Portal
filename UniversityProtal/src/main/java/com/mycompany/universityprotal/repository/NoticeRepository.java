/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Notice;
import com.mycompany.universityprotal.service.I_NoticeService;
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
public class NoticeRepository implements I_NoticeService{
    
     @Autowired
    SessionFactory sessionFactory;
    

   @Override
    public Notice save(Notice notice) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(notice);
        t.commit();
        s.close();
        return notice;
    }

    @Override
    public List<Notice> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Notice> notice = s.createQuery("from Notice").list();
        t.commit();
        s.close();
        return notice;
    }

    @Override
    public void update(Notice notice) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(notice);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Notice notice = (Notice) s.get(Notice.class, id);
        s.delete(notice);
        t.commit();
        s.close();
    }

    @Override
    public Notice getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Notice notice = (Notice) s.get(Notice.class, id);
        t.commit();
        s.close();
        return notice;
    }
    
}
