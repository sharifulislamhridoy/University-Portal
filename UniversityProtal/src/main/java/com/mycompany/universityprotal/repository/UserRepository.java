/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.universityprotal.repository;

import com.mycompany.universityprotal.model.Users;
import com.mycompany.universityprotal.service.I_UsersService;
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
public class UserRepository implements I_UsersService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Users save(Users users) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.save(users);
        t.commit();
        s.close();
        return users;
    }

    @Override
    public List<Users> viewAll() {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        List<Users> usersList = s.createQuery("from Users").list();
        t.commit();
        s.close();
        return usersList;
    }

    @Override
    public void update(Users users) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        s.update(users);
        t.commit();
        s.close();
    }

    @Override
    public void delete(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Users users = (Users) s.get(Users.class, id);
        s.delete(users);
        t.commit();
        s.close();
    }

    @Override
    public Users getById(Integer id) {
        Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Users cm = (Users) s.get(Users.class, id);
        t.commit();
        s.close();
        return cm;
    }

    @Override
    public Users getEmailPassword(String email, String password) {
     Session s = sessionFactory.openSession();
        Transaction t = s.getTransaction();
        t.begin();
        Users users = (Users) s.get(Users.class, email);
        Users users2 = (Users) s.get(Users.class, password);
        t.commit();
        s.close();
        return users;
    }
}
